package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.Course;
import auca.rw.registration.AucaRegistration.domain.CourseBean;
import auca.rw.registration.AucaRegistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping(value = "/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody CourseBean courseBean){
        if (courseBean != null){
            Course course = courseService.addCourse(courseBean);
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        return new ResponseEntity<>("not saved", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllCourse(){
        List<Course> courseList = courseService.getAll();
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }


}
