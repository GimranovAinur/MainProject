package info.kpfu.itis.controllers;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

class ControllerAdvise {

    @ExceptionHandler(Throwable.class)
    public ModelAndView exception(HttpServletRequest req,Exception exception) throws Exception{
        if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null) {
            throw exception;
        }
        ModelAndView mav = new ModelAndView("error/404exception");
        if (exception instanceof NoHandlerFoundException) {
            mav.addObject("url", req.getRequestURL());
            mav.setViewName("error/404exception");
            return mav;
        }
        return mav;
    }
}
