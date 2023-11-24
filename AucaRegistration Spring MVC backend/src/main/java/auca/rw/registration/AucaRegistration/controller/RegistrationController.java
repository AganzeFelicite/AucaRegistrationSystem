package auca.rw.registration.AucaRegistration.controller;

import auca.rw.registration.AucaRegistration.domain.*;
import auca.rw.registration.AucaRegistration.service.AcademicUnitService;
import auca.rw.registration.AucaRegistration.service.RegistrationService;
import auca.rw.registration.AucaRegistration.service.SemesterService;
import auca.rw.registration.AucaRegistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/Registration")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @Autowired
    StudentService studentService;

    @Autowired
    AcademicUnitService academicUnitService;

    @Autowired
    SemesterService semesterService;
    @PostMapping(value = "/newRegistration")
    public ResponseEntity<?> saveRegistration(@RequestBody RegistrationBean obj){
        if (obj != null){
            Student std = studentService.getStudent(obj.getStudId()).orElse(null);
            AcademicUnit acad = academicUnitService.getAcademicUnitById(obj.getAcadId());
            String regStatus = obj.getRegStatus();
            Semester sem = semesterService.getByIdSemester(obj.getSemId());
            Registration reg = new Registration();
            reg.setRegistration_status(regStatus);
            reg.setAcademic_category(acad);
            reg.setRegisteredDate(LocalDate.now());
            reg.setStudent(std);
            reg.setSemester(sem);
            Registration regObj = registrationService.saveRegistration(reg);
            return new ResponseEntity<>(regObj, HttpStatus.OK);
        }
        return  new ResponseEntity<>("wrong inputs", HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll(){
        List<Registration> regList = registrationService.getAllRegistrations();
        return new ResponseEntity<>(regList, HttpStatus.ACCEPTED);
    }
}
