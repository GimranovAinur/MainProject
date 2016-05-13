package info.kpfu.itis.service;

import info.kpfu.itis.exceptions.NotFoundException;
import info.kpfu.itis.exceptions.UserRegisterException;
import info.kpfu.itis.model.User;
import info.kpfu.itis.model.UserAuthority;
import info.kpfu.itis.repo.UserAuthorityRepo;
import info.kpfu.itis.repo.UserRepository;
import info.kpfu.itis.utils.SomeAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService implements UserDetailsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserAuthorityRepo authorityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepo(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public void addUser(User user) throws UserRegisterException{
        if (emailExists(user.getUsername())) {
            throw new UserRegisterException("There is an account with that email address: " + user.getUsername());
        }


        String password = passwordEncoder.encode(user.getPassword());

        user.setPassword(password);
        user.setPasswordRepeat(password);

        user.addAuthority(authorityRepo.findByAuthority("ROLE_USER"));

        setDefaultImage(user);

        if (userRepo.save(user) == null) {
            throw new UserRegisterException("Database error! Can't save user!");
        }
    }

    public User update(String username ,String name,String surname, String image, String avatar){
        User user = userRepo.findByUsernameIgnoreCase(username);
        user.setPasswordRepeat(user.getPassword());
        user.setName(name);
        user.setSurname(surname);
        user.setBackgroundImage(image);
        user.setAvatar(avatar);
        return user;
    }

    private void setDefaultImage(User user) {
        user.setAvatar(user.getGender().equalsIgnoreCase("male") ?
                "/assets/images/img/default_user_avatar_0.png" :
                "/assets/images/img/default_user_avatar_1.png");
        user.setBackgroundImage("/assets/images/img/default_user_image.png");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsernameIgnoreCase(username);
    }

    private boolean emailExists(String email) {
        return userRepo.findByUsernameIgnoreCase(email) != null;
    }

    public User findUserByUsername(String login) {

        User user = userRepo.findByUsernameIgnoreCase(login);

        checkUser(user);

        return user;
    }

    private void checkUser(User user) {
        if (user == null || !user.isEnabled()) {
            throw new NotFoundException("User profile is not exists or it isn't enabled yet!");
        }
    }


}
