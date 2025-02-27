package net.diyotech.student_management_system.controller;

import net.diyotech.student_management_system.entity.StudentManager;
import net.diyotech.student_management_system.service.StudentManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
@CrossOrigin("http://localhost:4200") //allows angular to call this class
public class StudentManagerController {

    private final StudentManagerService studentManagerService;

    public StudentManagerController(StudentManagerService studentManagerService){
        this.studentManagerService = studentManagerService;
    }

    //Sign Up
    @PostMapping
    public ResponseEntity<String> saveStudentManager(@RequestBody StudentManager studentManager){
        System.out.println("test");
        return ResponseEntity.ok(studentManagerService.saveStudentManager(studentManager));
    }

    //Log In
    @PostMapping("/login")
    public ResponseEntity<StudentManager> checkValidStudentManager (@RequestBody StudentManager studentManager){
        return ResponseEntity.ok(this.studentManagerService.checkValidStudentManager(studentManager));
    }
}
