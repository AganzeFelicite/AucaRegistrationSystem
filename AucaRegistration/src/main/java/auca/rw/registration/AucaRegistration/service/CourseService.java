package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.*;
import auca.rw.registration.AucaRegistration.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SemesterRepository semesterRepository;
    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    AcademiUnitRepository academiUnitRepository;
    @Autowired
    CourseDefinitionRepository courseDefinitionRepository;


    public Course addCourse(CourseBean courseBean){
        if (courseBean != null){
            Course course = new Course();
            CourseDefinition courseDefinition = courseDefinitionRepository.findById(courseBean.getCourseDefId()).orElse(null);
            AcademicUnit acad;
            acad = academiUnitRepository.findById(courseBean.getAcadId()).orElse(null);
            Semester sem = semesterRepository.findById(courseBean.getSemesterId()).orElse(null);
            course.setCourseDef(courseDefinition);
            course.setAcademics(acad);
            course.setSemester(sem);
            courseRepository.save(course);
            return course;
        }
        return null;
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

}
