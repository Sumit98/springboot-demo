package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
        return args -> {
            Student sumit=  new Student(
                    1,"Sumit", LocalDate.of(1992,9,13),"xyz@gmail.com"
            );
            Student alex=  new Student(
                    2,"alex", LocalDate.of(1998,10,15),"abc@gmail.com"
            );
            studentRepo.saveAll(List.of(sumit,alex));
        };

    }

}
