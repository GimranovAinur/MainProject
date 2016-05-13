package info.kpfu.itis.controllers;

import info.kpfu.itis.exceptions.NotFoundException;
import info.kpfu.itis.model.User;
import info.kpfu.itis.model.Wish;
import info.kpfu.itis.repo.WishRepo;
import info.kpfu.itis.service.UserService;
import info.kpfu.itis.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class WishController {

    @Autowired
    private WishService wishService;

    @Autowired
    private UserService userService;

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
            wishService.add(wish,user);
            redirectAttributes.addFlashAttribute("message", "Wish has been posted successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("UC#myWishes").build();
        }
    }

    @RequestMapping("/feed")
    public String feed(ModelMap map) {
        if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            List<Wish> allWishes = wishRepo.findWishByOrderByIdDesc();
            List<Wish> wishes = new LinkedList<>();
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            for(Wish wish : allWishes){
                if(wish.getUser().getId() != user.getId()){
                    wishes.add(wish);
                }
            }

            map.put("wishes",wishes);
        }
        return "wish/list";
    }

    @RequestMapping("/wish/{id}")
    public String wishPage(@PathVariable int id, Principal principal, ModelMap map){
        Wish wish = wishRepo.findOne(id);
        User user = userService.findUserByUsername(principal.getName());
        if(user.getId() == wish.getUser().getId())  {
            map.put("wish",wish);
            return "wish/wish_page";
        }else{
            throw new NotFoundException("Wish");
        }
    }

    @RequestMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public String allWishes(ModelMap map){
        map.put("wishes",wishRepo.findAll());
        return "wish/all";
    }

    @RequestMapping("/wish/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes, ModelMap map) {
        Wish wish = wishRepo.findOne(id);
        try {
            wishRepo.delete(wish);
            redirectAttributes.addFlashAttribute("message", "Wish has been deleted successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
        }catch (DataAccessException e) {
            redirectAttributes.addFlashAttribute("message", "Can't delete wish.");
            redirectAttributes.addFlashAttribute("messageType", "fail");
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("WC#allWishes").build();
    }
}
