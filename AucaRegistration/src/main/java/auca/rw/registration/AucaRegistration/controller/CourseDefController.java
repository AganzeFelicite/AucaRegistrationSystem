package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.CourseDefinition;
import auca.rw.registration.AucaRegistration.domain.CourseDefinitionBean;
import auca.rw.registration.AucaRegistration.service.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(value = "/courseDef", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class CourseDefController {

    @Autowired
    CourseDefinitionService courseDefinitionService;

    @PostMapping(value = "/createCourseDefinition")
    public ResponseEntity<?> saveCourseDef(@RequestBody CourseDefinitionBean courseDefOBj) {
        try {
            if (courseDefOBj != null) {
                CourseDefinition courseDef = new CourseDefinition();
                courseDef.setCode(courseDefOBj.getCode());
                courseDef.setName(courseDefOBj.getName());
                courseDef.setDescription(courseDefOBj.getDescription());
                CourseDefinition courseDefinition = courseDefinitionService.createCourseDef(courseDef);
                return new ResponseEntity<>(courseDefinition, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("CourseDefinition object cannot be null", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return new ResponseEntity<>("Error processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseDefinition>> getAll() {
        try {
            List<CourseDefinition> courseDefList = courseDefinitionService.getAllCourses();
            return new ResponseEntity<>(courseDefList, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
