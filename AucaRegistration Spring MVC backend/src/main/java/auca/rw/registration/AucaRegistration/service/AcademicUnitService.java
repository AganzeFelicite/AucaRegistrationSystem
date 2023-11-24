package auca.rw.registration.AucaRegistration.service;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import auca.rw.registration.AucaRegistration.domain.EAcademicUnit;
import auca.rw.registration.AucaRegistration.repository.AcademiUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicUnitService {
    @Autowired
    AcademiUnitRepository academiUnitRepository;

    public AcademicUnit createAcademicUnit(AcademicUnit acad){
        if (acad != null){

            //acad.setEacademicUnit(EAcademicUnit.PROGRAMME);
            academiUnitRepository.save(acad);
            return acad;
        }
        return null;

    }

    public List<AcademicUnit> ListOfAcademicUnit(){
        return academiUnitRepository.findAll();
    }

    public AcademicUnit getAcademicUnitById(String code){
        AcademicUnit academicUnit = academiUnitRepository.findById(code).orElse(null);
        return academicUnit;
    }

    public AcademicUnit updateAcademicUnit(AcademicUnit oldAcad, AcademicUnit newAcad){
        if (newAcad != null){
            oldAcad.setCode(newAcad.getCode());
            oldAcad.setAcademicUnit(newAcad.getAcademicUnit());
            oldAcad.setName(newAcad.getName());
            oldAcad.setEacademicUnit(newAcad.getEacademicUnit());
            academiUnitRepository.save(oldAcad);
        }
        return null;
    }


}
