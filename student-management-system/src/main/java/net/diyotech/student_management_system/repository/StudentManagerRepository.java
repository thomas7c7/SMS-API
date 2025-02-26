package net.diyotech.student_management_system.repository;

import net.diyotech.student_management_system.entity.StudentManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentManagerRepository extends JpaRepository<StudentManager, Long> {

    public StudentManager findStudentManagerByUserNameAndPassword (String username, String password);

}
