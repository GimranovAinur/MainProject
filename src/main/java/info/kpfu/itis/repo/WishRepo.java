package info.kpfu.itis.repo;

import info.kpfu.itis.model.Wish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by asus2 on 22.04.16.
 */
@Repository
public interface WishRepo extends CrudRepository<Wish, Integer>{
}
