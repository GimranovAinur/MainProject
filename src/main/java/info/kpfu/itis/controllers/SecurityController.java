package info.kpfu.itis.controllers;

import info.kpfu.itis.model.User;
import info.kpfu.itis.model.UserAuthority;
import info.kpfu.itis.model.forms.LoginForm;
import info.kpfu.itis.repo.UserAuthorityRepo;
import info.kpfu.itis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthorityRepo userAuthorityRepo;

    public String showRegisterForm(ModelMap map){
        map.put("userAuthorities",userAuthorityRepo.findAll());
        return "security/register_form";
    }

    @RequestMapping(value = "/login")
    @PreAuthorize("isAnonymous()")
    public String login(@RequestParam(required = false) String error, @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap map) {
        map.put("error", error);
        return "security/login_form";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String register(ModelMap map) {
        map.put("user", new User());
        return showRegisterForm(map);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String registerHandler(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("user")@Valid User user,
            BindingResult result,
            ModelMap map
    ){
        if(!result.hasErrors()){
            try{
                userService.addUser(user);
                redirectAttributes.addFlashAttribute("message", "User " + user.getName() + " " + user.getSurname() + " was successfully added!");
                return "redirect:profile";
            }catch (DuplicateKeyException e){
                result.rejectValue("username", "entry.duplicate", "There is account with such email already.");
            }
        }
        return showRegisterForm(map);
    }

    @RequestMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile(HttpServletRequest request) {
        return "security/profile";
    }
}
