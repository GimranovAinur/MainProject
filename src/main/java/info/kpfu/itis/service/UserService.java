package info.kpfu.itis.service;

import info.kpfu.itis.model.User;
import info.kpfu.itis.repo.UserRepository;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepo(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new DuplicateKeyException("Duplicate key - username field.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPasswordRepeat(user.getPassword());
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
}
