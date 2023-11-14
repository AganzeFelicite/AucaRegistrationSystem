package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
