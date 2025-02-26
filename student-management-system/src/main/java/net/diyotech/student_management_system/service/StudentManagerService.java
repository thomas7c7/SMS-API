package net.diyotech.student_management_system.service;

import net.diyotech.student_management_system.entity.StudentManager;
import net.diyotech.student_management_system.repository.StudentManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentManagerService {

    private final StudentManagerRepository studentManagerRepository;

    public StudentManagerService(StudentManagerRepository studentManagerRepository){
        this.studentManagerRepository = studentManagerRepository;
    }

    public String saveStudentManager(StudentManager studentManager){
        StudentManager saveStudentManager = studentManagerRepository.save(studentManager);
        if (saveStudentManager != null){
            return "success";
        } else {
            return "failed";
        }
    }

    public StudentManager checkValidStudentManager (StudentManager studentManager){
        StudentManager validatedStudentManager = this.studentManagerRepository.findStudentManagerByUserNameAndPassword
                (studentManager.getUserName(), studentManager.getPassword());
        if (validatedStudentManager != null){
            return validatedStudentManager;
        }
        return studentManager;
    }
}
