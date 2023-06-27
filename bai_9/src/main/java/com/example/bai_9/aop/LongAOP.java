package com.example.bai_9.aop;

import com.example.bai_9.dto.FootballDto;
import com.example.bai_9.model.Football;
import com.example.bai_9.service.IFootballService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LongAOP {
    @Autowired
    private IFootballService iFootballService;

    @Pointcut("execution(* com.example.bai_9.controller.FootballController.update(..))&&args(footballDto,*,*,*)")
    public void getAllUpdate(FootballDto footballDto) {
    }

    @After(value = "getAllUpdate(footballDto)", argNames = "footballDto")
    public void printUpdate(FootballDto footballDto) {
        int count = 0;
        for (Football football : iFootballService.findAll()) {
            if (football.isStatus()) {
                count++;
            }
        }
        System.out.println("Player's Status" + footballDto.getName() + " has been converted to " + ((footballDto.isStatus()) ? "Register Play" : "UnRegister play"));
        System.out.println("The number of registered players is: " + count);
    }
}
