package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents(){
        return  studentRepo.findAll();
    }
    public void addNewStudent(Student student){
       Optional<Student> studentOptional =
               studentRepo.findStudentByEmail(student.getEmail());
       if(studentOptional.isPresent()){
           throw new IllegalStateException("Email already used!");
       }
       studentRepo.save(student);
        System.out.println("-------Student Added!!------");
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepo.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with ID "+ studentId+" does not exists!");
        }
        studentRepo.deleteById(studentId);
        System.out.println("-------Student Deleted!!------");
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        Student student= studentRepo.findById(studentId).orElseThrow(()-> new IllegalStateException("Student with ID "+ studentId+" does not exists!"));
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            student.setEmail(email);
        }
        System.out.println("-------Student Updated!!------");
    }

}
