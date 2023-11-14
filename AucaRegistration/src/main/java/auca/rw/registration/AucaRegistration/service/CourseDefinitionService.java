package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.CourseDefinition;
import auca.rw.registration.AucaRegistration.repository.CourseDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDefinitionService {
    @Autowired
    CourseDefinitionRepository courseDefinitionRepository;

    public CourseDefinition createCourseDef(CourseDefinition courDef){

        if (courDef != null){
            courseDefinitionRepository.save(courDef);
            return courDef;
        }
        return null;
    }

    public List<CourseDefinition> getAllCourses(){
        List<CourseDefinition> courseList = courseDefinitionRepository.findAll();
        return courseList;
    }

    public CourseDefinition getByIdCourseDef(String code){
        return courseDefinitionRepository.findById(code).orElse(null);
    }
}
