package info.kpfu.itis.repo;

import info.kpfu.itis.model.Log;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by asus2 on 28.04.16.
 */
public interface LogRepo extends CrudRepository<Log,Integer > {
}
