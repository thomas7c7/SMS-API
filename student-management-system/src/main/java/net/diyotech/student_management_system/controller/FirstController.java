package net.diyotech.student_management_system.controller;

import jakarta.validation.Valid;
import net.diyotech.student_management_system.model.User;
import net.diyotech.student_management_system.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController //accepts client request and sends response
@RequestMapping("/first")
public class FirstController {

    //Field based injection
//    @Autowired
//    private FirstService firstService;

    //Constructor injection
    private final FirstService firstService;

    public FirstController(FirstService firstService){
        this.firstService = firstService;
    }

    @PostMapping("/end2end")
    public ResponseEntity<User> test(@RequestBody User user){
        User usr = firstService.saveUser(user);
        return ResponseEntity.ok(usr);
    }


    //URL = localhost:8080/first/
    @PostMapping("/")
    //@Valid validates client data
    public ResponseEntity<?> save(@Valid @RequestBody User user, BindingResult bindingResult) {//extracts data from User class

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().stream().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }
        user.getHobbies().stream().forEach(System.out::println); //output lists
        System.out.println(user.getAddress());
        return ResponseEntity.ok().body(firstService.saveUser(user));//prints user info from the User class
    }

    @PostMapping("/test")
    public String postdata(@RequestBody Integer password){
        return "Your password is: "+password;
    }

    //URL = localhost:8080/first?fname=Thomas&lname=Limbu
    @GetMapping //get resource from the server and is visible in the url
    public String queryParam(@RequestParam("fname") String firstName,
                             @RequestParam("lname") String lastName){
        return "Query param " +firstName+" "+lastName;
    }

    //localhost:8080/first/sum/10/20
    @GetMapping("/sum/{num1}/{num2}")
    public Integer sum(@PathVariable("num1") Integer n1,
                       @PathVariable("num2") Integer n2){
        return n1+n2;
    }

    //URL = locahost:8080/first/thomas/user/limbu
    @GetMapping("/{fname}/user/{lname}")
    public String helloUser1(@PathVariable("fname") String firstName,
                            @PathVariable("lname") String lastName){
        return "Hello user: "+ firstName +" "+lastName;
    }

    //URL = locahost:8080/first/thomas/limbu
    @GetMapping("/{fname}/{lname}")
    public String helloUser(@PathVariable("fname") String firstName,
                            @PathVariable("lname") String lastName){
        return "Hello "+ firstName +" "+lastName;
    }

    // URL = localhost:8080/first/
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    //URL = localhost:8080/first/first
    @GetMapping("/first")
    public String hello1(){
        return "Hello world";
    }
}
