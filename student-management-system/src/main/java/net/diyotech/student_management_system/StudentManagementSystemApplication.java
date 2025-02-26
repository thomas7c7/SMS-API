package net.diyotech.student_management_system;

import net.diyotech.student_management_system.service.FirstService;
import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.beans.beancontext.BeanContext;

@SpringBootApplication
//@Configuration - Looks for beat definition @Bean
//@ComponentScan
//@EnableAutoConfiguration
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
	SpringApplication.run(StudentManagementSystemApplication.class, args);


	}

}
