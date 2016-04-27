package info.kpfu.itis.repo;

import info.kpfu.itis.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by asus2 on 19.04.16.
 */
@Repository
public interface CityRepo extends CrudRepository<City, Integer>{

}