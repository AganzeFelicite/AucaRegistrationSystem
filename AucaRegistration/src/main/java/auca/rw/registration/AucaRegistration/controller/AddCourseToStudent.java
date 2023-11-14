package auca.rw.registration.AucaRegistration.controller;


import auca.rw.registration.AucaRegistration.domain.Registration;
import auca.rw.registration.AucaRegistration.domain.StudentCourseBean;
import auca.rw.registration.AucaRegistration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/studentCourse", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class AddCourseToStudent {
    @Autowired
    RegistrationService registrationService;

    @PostMapping(value = "/giveCourse")
    public ResponseEntity<?> addCourse(@RequestBody StudentCourseBean obj){
        Registration reg = registrationService.giveCourse(obj);
        if (reg == null)
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reg, HttpStatus.OK);
    }


}
