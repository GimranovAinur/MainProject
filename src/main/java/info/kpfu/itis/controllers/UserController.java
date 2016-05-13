package info.kpfu.itis.controllers;

import info.kpfu.itis.model.User;
import info.kpfu.itis.model.Wish;
import info.kpfu.itis.repo.UserRepository;
import info.kpfu.itis.repo.WishRepo;
import info.kpfu.itis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.enterprise.inject.Model;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WishRepo wishRepo;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String profile(@PathVariable int id,ModelMap map){
        User user = userRepository.findOne(id);
        map.put("user", user);
        return "user/profile";
    }

    @RequestMapping(value = "/my_wishes", method = RequestMethod.GET)
    public String myWishes(ModelMap map){
        if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            map.put("wishes",wishRepo.findWishByUserIdOrderByIdDesc(user.getId()));
        }
        return "user/my_wishes";
    }
}
