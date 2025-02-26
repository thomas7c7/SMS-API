package net.diyotech.student_management_system.controller;

import net.diyotech.student_management_system.entity.Student;
import net.diyotech.student_management_system.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
     studentService.saveStudent(student);
        return ResponseEntity.ok("Student Saved Successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudentList(){
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable("id") Long studentId){
       return ResponseEntity.ok(studentService.getStudentById(studentId));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long studentId, @RequestBody Student student){
        studentService.updateStudent(studentId, student);
        return ResponseEntity.ok("Student Updated");
    }
}
