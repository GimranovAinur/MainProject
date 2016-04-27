package info.kpfu.itis.repo;

import info.kpfu.itis.model.UserAuthority;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by asus2 on 25.04.16.
 */
public interface UserAuthorityRepo extends CrudRepository<UserAuthority, Integer> {

    public UserAuthority findByAuthority(String role_user);
}