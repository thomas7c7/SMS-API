package net.diyotech.student_management_system.service;

import lombok.RequiredArgsConstructor;
import net.diyotech.student_management_system.model.User;
import net.diyotech.student_management_system.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public String login(User user) {
      loginRepository.save(user);
      return "login successful";
    }
}
