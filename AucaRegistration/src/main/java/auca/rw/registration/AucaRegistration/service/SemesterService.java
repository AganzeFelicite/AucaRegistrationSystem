package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.Semester;
import auca.rw.registration.AucaRegistration.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {
    @Autowired
    SemesterRepository semesterRepository;

    public Semester createSemester(Semester sem){
        if (sem != null){
            semesterRepository.save(sem);
            return sem;
        }
        return null;
    }

    public List<Semester> getAllSemester(){
        return semesterRepository.findAll();
    }

    public Semester getByIdSemester(int id){
        return semesterRepository.findById(id).orElse(null);
    }
}
