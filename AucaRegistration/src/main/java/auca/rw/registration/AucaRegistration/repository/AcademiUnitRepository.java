package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademiUnitRepository extends JpaRepository<AcademicUnit, String> {
}
