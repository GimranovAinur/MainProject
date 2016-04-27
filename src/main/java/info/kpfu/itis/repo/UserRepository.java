package info.kpfu.itis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import info.kpfu.itis.model.User;

/**
 * Created by asus2 on 15.04.16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String username);
}
