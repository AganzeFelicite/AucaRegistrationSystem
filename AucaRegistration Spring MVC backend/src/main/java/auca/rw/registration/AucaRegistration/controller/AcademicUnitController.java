package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.Student;
import auca.rw.registration.AucaRegistration.service.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/academicUnit", produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class AcademicUnitController {

    @Autowired
    private AcademicUnitService academicUnitService;

    @PostMapping(value="/createAcademicUnit")
    public ResponseEntity<?> saveAcademicUnit(@RequestBody AcademicUnit acad){
        if (acad != null){
            academicUnitService.createAcademicUnit(acad);
            return new ResponseEntity<>(acad, HttpStatus.OK);
        }
        return new ResponseEntity<>("not created", HttpStatus.NOT_ACCEPTABLE);

    }
    @GetMapping(value = "/all")
    public  ResponseEntity<List<AcademicUnit>> getAll(){
        List<AcademicUnit> acad = academicUnitService.ListOfAcademicUnit();
        return new ResponseEntity<>(acad, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        if (id != null) {
            AcademicUnit acad = academicUnitService.getAcademicUnitById(id);
            return new ResponseEntity<>(acad, HttpStatus.OK);
        }
        return new ResponseEntity<>("Enter the Id", HttpStatus.OK);
    }
}
