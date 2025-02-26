package net.diyotech.student_management_system.service;

import net.diyotech.student_management_system.model.User;
import net.diyotech.student_management_system.repository.FirstRepository;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

//    private final FirstRepository firstRepository;
//
//    public FirstService(FirstRepository firstRepository){
//        this.firstRepository = firstRepository;
//    }

    public User saveUser(User user){
        return user;
    }


}
