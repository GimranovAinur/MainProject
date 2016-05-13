package info.kpfu.itis.controllers;

import info.kpfu.itis.exceptions.NotFoundException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView exception(HttpServletRequest req,Exception exception) throws Exception{
        ModelAndView mav = new ModelAndView("error/404exception");
        if (exception instanceof NotFoundException) {
            mav.addObject("code", "404 Not Found");
            mav.addObject("message", "Sorry, an error has occured, Requested page not found!");
            return mav;
        }else if (exception instanceof NoHandlerFoundException) {
            mav.addObject("code", "404 Not Found");
            mav.addObject("message", "Sorry, an error has occured, Requested page not found!");
            return mav;
        }
        return mav;
    }
}
