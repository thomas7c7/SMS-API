package net.diyotech.student_management_system.service;

import net.diyotech.student_management_system.model.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String login(User user) {
      return "login successful";
    }
}
