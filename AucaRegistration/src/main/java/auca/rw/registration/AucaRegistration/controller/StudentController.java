package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.Student;
import auca.rw.registration.AucaRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.Option;
import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student", produces = {MediaType.APPLICATION_JSON_VALUE},
                                    consumes = {MediaType.APPLICATION_JSON_VALUE})
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping(value="/saveStudent")
    public ResponseEntity<?> createStudent(@RequestBody Student std){
        if (std != null){
            String message = studentService.createStudent(std);
            if (message != null){
                return new ResponseEntity<>("SAVED", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("not saved", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> stdList = studentService.allStudents();
        return new ResponseEntity<>(stdList, HttpStatus.OK);

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Student>> getOne(@PathVariable Integer id){
        Optional<Student> std = studentService.getStudent(id);
        return  new ResponseEntity<>(std, HttpStatus.OK);

    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Student std){
        Student student1 = studentService.getStudent(id).orElse(null);
        if (std != null){
            Student student = studentService.updateStudent(std, student1);
            return new ResponseEntity<>(student, HttpStatus.OK);

        }
        return new ResponseEntity<>("request body is empty", HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        if (id != null){
            Boolean flag = studentService.deleteStudent(id);
            return new ResponseEntity<>(flag, HttpStatus.OK);
        }
        return new ResponseEntity<>("provide the id and try again", HttpStatus.NOT_FOUND);
    }
}
