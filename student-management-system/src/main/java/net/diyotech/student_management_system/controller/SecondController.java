package net.diyotech.student_management_system.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {

    //URL = localhost:8080/first/
    @GetMapping("/")
    public String second(){
        return "Second Controller";
    }

    @GetMapping("/second")
    public String second1(){
        return "Second controller";
    }
}
