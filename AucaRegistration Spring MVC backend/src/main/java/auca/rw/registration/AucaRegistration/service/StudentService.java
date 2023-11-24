package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.Student;
import auca.rw.registration.AucaRegistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student std){
        if (std != null){
            //Optional<Student> student = studentRepository.findById(std.getStudentId());

            studentRepository.save(std);
            return "student created successfully";
        }else{
            return null;
        }
    }

    public List<Student> allStudents(){
        return (List)studentRepository.findAll();
    }


    public Optional<Student> getStudent(Integer id){
        if (id != null){
            return studentRepository.findById(id);
        }
        return null;
    }


    public boolean deleteStudent(Integer id){
       Student std = studentRepository.findById(id).orElse(null);
       if (std != null){
           studentRepository.deleteById(id);
           return true;
       }
    return false;
    }

    public Student updateStudent(Student std, Student student1){
        Student student = studentRepository.findById(student1.getRegNo()).orElse(null);
        if (student != null){
            student1.setFirstName(std.getFirstName());
            student1.setLastName(std.getLastName());
            student1.setDateOfBirth(std.getDateOfBirth());

            student1.setRegistratioList(std.getRegistratioList());
            studentRepository.save(student1);
            return student1;
        }
        return null;
    }


}
