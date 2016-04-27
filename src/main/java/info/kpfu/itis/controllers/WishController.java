package info.kpfu.itis.controllers;

import info.kpfu.itis.model.User;
import info.kpfu.itis.model.Wish;
import info.kpfu.itis.repo.WishRepo;
import info.kpfu.itis.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class WishController {

    @Autowired
    private WishService wishService;

    @Autowired
    private WishRepo wishRepo;

    protected String showForm(ModelMap map) {
        return "wish/wish_form";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(ModelMap map){
        return "mainPage";
    }

    @RequestMapping(value = "/wish/new", method = RequestMethod.GET)
    public String add(ModelMap map){
        map.put("wish", new Wish());
        return showForm(map);
    }

    @RequestMapping(value = "/wish/new", method = RequestMethod.POST)
    public String addHandler(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("wish") @Valid Wish wish,
            BindingResult result,
            ModelMap map
    ) {
        if (result.hasErrors()) {
            return showForm(map);
        } else {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            wishService.add(wish, user);
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("WC#add").build();
        }
    }

    @RequestMapping("/list")
    public String feed(ModelMap map) {
        map.put("wishes",wishRepo.findAll());
        return "advice/list";
    }
}
