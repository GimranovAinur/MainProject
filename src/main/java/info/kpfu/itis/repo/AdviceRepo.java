package info.kpfu.itis.repo;

import info.kpfu.itis.model.Advice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by asus2 on 22.04.16.
 */
@Repository
public interface AdviceRepo extends CrudRepository<Advice, Integer>{

}
