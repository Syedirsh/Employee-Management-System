package com.example.irshad.irshad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // making method on rest controller and using request mapping pon it to give response 
public class mycontroller{
    @RequestMapping("m") // ("M") is the end point.and RequestMapping() is 
    //used to receive the requets from the user 
    public static String mymethod(){
        return "<h1>im ironman </h1>";
    }


    @GetMapping("process-form")
    public static String getData(@RequestParam int num1 ,@RequestParam int num2){
       int res=num1+num2;
        return "Result="+res;

    }
}