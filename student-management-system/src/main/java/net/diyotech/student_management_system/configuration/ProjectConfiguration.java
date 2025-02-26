package net.diyotech.student_management_system.configuration;

import net.diyotech.student_management_system.model.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Configuration //need this annotation in order to use @Bean
public class ProjectConfiguration {

    @Bean
    @Primary() //makes this primary object if more than 1 bean with same type
    public Project project1(){
//        System.err.println("Inside project 1");
        return Project.builder()
                .name("SMS")
                .budget(500d)
                .months(12f)
                .build();
    }

    @Bean("hospitalProject")
    @Profile("localdev")
    public Project project2(){
//        System.err.println("Inside hospital project");
        return Project.builder()
                .name("HMS")
                .budget(600d)
                .months(6f)
                .build();
    }
}
