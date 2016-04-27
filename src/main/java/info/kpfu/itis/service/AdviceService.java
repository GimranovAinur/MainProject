package info.kpfu.itis.service;

import info.kpfu.itis.model.Advice;
import info.kpfu.itis.model.User;
import info.kpfu.itis.repo.AdviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by asus2 on 22.04.16.
 */
@Service
public class AdviceService {

    private AdviceRepo adviceRepo;

    @Autowired
    public void setAdviceRepo(AdviceRepo adviceRepo){
        this.adviceRepo=adviceRepo;
    }

    public Advice add(Advice advice,User user){
        advice.setUser(user);
        return adviceRepo.save(advice);
    }
}
