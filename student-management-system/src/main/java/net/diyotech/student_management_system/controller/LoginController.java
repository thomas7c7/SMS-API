package net.diyotech.student_management_system.controller;

import lombok.RequiredArgsConstructor;
import net.diyotech.student_management_system.model.User;
import net.diyotech.student_management_system.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user) {
        return ResponseEntity.ok(loginService.login(user));
    }
}
