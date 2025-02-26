package net.diyotech.student_management_system.service;

import net.diyotech.student_management_system.entity.Student;
import net.diyotech.student_management_system.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student){
     Student savedStudent = studentRepository.save(student);
    }

    public List<Student> getStudentList(){
      return studentRepository.findAll();
    }

    public void deleteStudent( Long studentId ){
        studentRepository.deleteById(studentId);
    }

    public Student getStudentById (Long studentId){
       Optional<Student> studentOptional = studentRepository.findById(studentId);
       if (studentOptional.isPresent()){
           return studentOptional.get();
       } else {
           throw new RuntimeException("Student not found");
       }
    }

    public void updateStudent(Long studentId, Student student){
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        if (student.getName() != null){
            existingStudent.setName(student.getName());
        }if (student.getGender() != null){
            existingStudent.setGender(student.getGender());
        }if (student.getMajor() != null){
            existingStudent.setMajor(student.getMajor());
        }if (student.getEmailAddress() != null){
            existingStudent.setEmailAddress(student.getEmailAddress());
        }if (student.getPhoneNumber() != null){
            existingStudent.setPhoneNumber(student.getPhoneNumber());
        }
        studentRepository.save(existingStudent);
    }
}
