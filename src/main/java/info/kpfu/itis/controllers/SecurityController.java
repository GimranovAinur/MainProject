package info.kpfu.itis.controllers;

import info.kpfu.itis.exceptions.NotFoundException;
import info.kpfu.itis.exceptions.UserRegisterException;
import info.kpfu.itis.model.User;
import info.kpfu.itis.model.forms.LoginForm;
import info.kpfu.itis.repo.UserAuthorityRepo;
import info.kpfu.itis.repo.UserRepository;
import info.kpfu.itis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.groups.Default;
import javax.validation.Validator;
import java.security.Principal;
import java.util.Set;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepo userAuthorityRepo;

    @Autowired
    private Validator validator;

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
            } catch (UserRegisterException e) {
                result.rejectValue("email", "register.email.exists", new Object[]{user.getUsername()},"");
                return showRegisterForm(map);
            }
        }
        return showRegisterForm(map);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String profile(HttpServletRequest request, ModelMap map, Principal principal) {
        User user = userService.findUserByUsername(principal.getName());
        map.put("user",user);
        return "security/profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String edit(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("user")User data,
            BindingResult result,
            ModelMap map,
            Principal principal
    ){
        User user;
        try{
            user = userService.update(principal.getName(), data.getName(), data.getSurname(), data.getBackgroundImage(), data.getAvatar());
        }
        catch(EntityNotFoundException ex){
            throw new NotFoundException("user");
        }
        Set<ConstraintViolation<User>> cv = validator.validate(user, Default.class);
        if (cv.isEmpty()){
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("message", "User \"" + user.getUsername() + "\" has been saved successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#profile").arg(0, user.getId()).build();
        }
        return "security/profile";
    }
}
