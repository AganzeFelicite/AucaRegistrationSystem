package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/semester", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class SemesterController {
    @Autowired
    SemesterService semesterService;

    @PostMapping(value = "/createSemester")
    public ResponseEntity<?> createSemester(@RequestBody Semester sem){
        if (sem != null){
            Semester semObj = semesterService.createSemester(sem);
            return new ResponseEntity<>(semObj, HttpStatus.OK);

        }
        return new ResponseEntity<>("the object is empty", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllSemester(){
        List<Semester> semList = semesterService.getAllSemester();
        return new ResponseEntity<>(semList, HttpStatus.OK);
    }

}
