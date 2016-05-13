package info.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("changeLocaleController")
public class LocaleController {


    private MessageSourceAccessor msa;

    @Autowired
    private void setMessageSourceAccessor(MessageSource ms) {
        this.msa = new MessageSourceAccessor(ms);
    }

    @RequestMapping(value = "/locale", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("message", this.msa.getMessage("message"));
        return "changeLocale";
    }
}
