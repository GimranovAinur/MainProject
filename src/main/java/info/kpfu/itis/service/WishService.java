package info.kpfu.itis.service;

import info.kpfu.itis.model.User;
import info.kpfu.itis.model.Wish;
import info.kpfu.itis.repo.WishRepo;
import info.kpfu.itis.utils.SomeAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {

    @Autowired
    private WishRepo wishRepo;

    @SomeAnnotation
    public Wish add(Wish wish, User user){
        wish.setUser(user);
        return wishRepo.save(wish);
    }


}
