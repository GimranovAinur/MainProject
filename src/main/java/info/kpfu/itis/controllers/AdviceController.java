package info.kpfu.itis.controllers;

import info.kpfu.itis.model.Advice;
import info.kpfu.itis.model.User;
import info.kpfu.itis.model.Wish;
import info.kpfu.itis.repo.UserRepository;
import info.kpfu.itis.repo.WishRepo;
import info.kpfu.itis.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @Autowired
    private WishRepo wishRepo;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String profile(@PathVariable int id,ModelMap map){
        User user = userRepository.findOne(id);
        map.put("user", user);
        return "advice/profile";
    }

    @RequestMapping(value = "/advice", method = RequestMethod.GET)
    public String giveAdviceForm(ModelMap map){
        map.put("advice",new Advice());
        return "advice/advice_form";
    }
}
