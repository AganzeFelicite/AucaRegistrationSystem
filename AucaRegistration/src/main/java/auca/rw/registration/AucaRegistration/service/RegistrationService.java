package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.Course;
import auca.rw.registration.AucaRegistration.domain.Registration;
import auca.rw.registration.AucaRegistration.domain.StudentCourseBean;
import auca.rw.registration.AucaRegistration.repository.CourseRepository;
import auca.rw.registration.AucaRegistration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    CourseRepository courseRepository;


    public Registration saveRegistration(Registration reg){
        if (reg != null){
            registrationRepository.save(reg);
            return reg;
        }
        return  null;
    }

    public Optional<Registration> getRegObjById(int id){
        return Optional.ofNullable(registrationRepository.findById(id).orElse(null));
    }

    public List<Registration> getAllRegistrations(){
        return registrationRepository.findAll();
    }

    public Registration giveCourse(StudentCourseBean std){
        if (std != null){
            Registration regStd = registrationRepository.getReferenceById(std.getStId());
            Course course  = courseRepository.getReferenceById(std.getCourseId());
            regStd.getCourseList().add(course);
            registrationRepository.save(regStd);
            return regStd;
        }
        return null;
    }


}
