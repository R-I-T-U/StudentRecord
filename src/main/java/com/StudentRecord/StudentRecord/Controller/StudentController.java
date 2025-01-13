package com.StudentRecord.StudentRecord.Controller;

import com.StudentRecord.StudentRecord.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private List<Student>  list = new ArrayList<>();

    @GetMapping
    public List<Student> getAllStudents(){
        return list;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student s){
        list.add(s);
        return s;
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student us){
        for(Student s: list){
            if(s.getId()==id){
                s.setName(us.getName());
                s.setAddress(us.getAddress());
                s.setRoll(us.getRoll());
                return s;
            }
        }
        throw new RuntimeException("Student with ID "+id+" not found.");
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        list.removeIf(student -> student.getId()==id);
        return "Student with ID "+id+" is deleted";
    }

}
