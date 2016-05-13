package info.kpfu.itis.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

import info.kpfu.itis.utils.FieldMatch;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordRepeat", message = "The password fields must match")
})
@DynamicUpdate
@Entity
@Table(name = "user")
public class User implements CredentialsContainer, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Length(max = 255)
    @NotBlank
    @Column
    private String name;


    @Length(max = 255)
    private String surname;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Transient
    private String passwordRepeat;

    @NotBlank
    @Column(name = "gender")
    private String gender;

    @Column(name = "background_image")
    @Length(max = 1000)
    private String backgroundImage;

    @Column(name = "avatar")
    @Length(max = 1000)
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER, cascade={CascadeType.MERGE})
    @JoinTable(
            name = "user_user_role",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "user_role")
    )
    private Set<UserAuthority> authorities = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Wish> wishes;

    public void eraseCredentials(){
        this.password = null;
    }

    public User(String name, String surname, String username, String password, String passwordRepeat) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String name, String surname, String username, String password, String passwordRepeat) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
    }

    public User(String name, String surname, String username, String password, String passwordRepeat, String gender, String backgroundImage, String avatar, Set<UserAuthority> authorities, Set<Wish> wishes) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
        this.gender = gender;
        this.backgroundImage = backgroundImage;
        this.avatar = avatar;
        this.authorities = authorities;
        this.wishes = wishes;
    }

    public User(String name, String surname, String username, String password, String passwordRepeat, String gender, String backgroundImage, String avatar) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
        this.gender = gender;
        this.backgroundImage = backgroundImage;
        this.avatar = avatar;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }


    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    @Override
    public Set<UserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<UserAuthority> authorities) {
        this.authorities = authorities;
    }

    public Set<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(Set<Wish> wishes) {
        this.wishes = wishes;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (passwordRepeat != null ? !passwordRepeat.equals(user.passwordRepeat) : user.passwordRepeat != null)
            return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (backgroundImage != null ? !backgroundImage.equals(user.backgroundImage) : user.backgroundImage != null)
            return false;
        if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null) return false;
        if (authorities != null ? !authorities.equals(user.authorities) : user.authorities != null) return false;
        return !(wishes != null ? !wishes.equals(user.wishes) : user.wishes != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passwordRepeat != null ? passwordRepeat.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (backgroundImage != null ? backgroundImage.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (authorities != null ? authorities.hashCode() : 0);
        result = 31 * result + (wishes != null ? wishes.hashCode() : 0);
        return result;
    }

    public void addAuthority(UserAuthority authority) {
        this.authorities.add(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
