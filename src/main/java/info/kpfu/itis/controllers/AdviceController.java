package info.kpfu.itis.controllers;

import info.kpfu.itis.model.Advice;
import info.kpfu.itis.model.User;
import info.kpfu.itis.model.Wish;
import info.kpfu.itis.repo.UserRepository;
import info.kpfu.itis.repo.WishRepo;
import info.kpfu.itis.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @Autowired
    private WishRepo wishRepo;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "wish/{id}/advice",method = RequestMethod.GET)
    public String adviceForm(@PathVariable int id, ModelMap map){
        map.put("wish", wishRepo.findOne(id));
        map.put("advice",new Advice());
        return "advice/advice_form";
    }

    @RequestMapping(value = "wish/{id}/advice",method = RequestMethod.POST)
    public String adviceHandler(
            @PathVariable int id,
            RedirectAttributes redirectAttributes,
            @ModelAttribute("advice") @Valid Advice advice,
            BindingResult result,
            ModelMap map
            ){
        if (result.hasErrors()) {
            return "advice/advice_form";
        } else {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            adviceService.add(advice, user, wishRepo.findOne(id));
            redirectAttributes.addFlashAttribute("message", "Your advice was posted");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("WC#feed").build();
        }
    }
}
