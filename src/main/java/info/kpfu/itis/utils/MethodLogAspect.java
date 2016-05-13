package info.kpfu.itis.utils;

import info.kpfu.itis.model.Log;
import info.kpfu.itis.model.User;
import info.kpfu.itis.repo.LogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.Date;


@Aspect
public class MethodLogAspect
{

    @Autowired
    private LogRepo logRepo;

    @Around("@annotation(info.kpfu.itis.utils.SomeAnnotation)")
    public void log(ProceedingJoinPoint point) throws Throwable{
        String date = new Date().toString();
        String methodName = point.getSignature().getName();
        Object o = point.proceed(point.getArgs());
        String returnValue = o == null ? "void" : o.getClass().getSimpleName();
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        logRepo.save(new Log(date,methodName,returnValue,username));
    }
}

