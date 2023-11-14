package auca.rw.registration.AucaRegistration.repository;

import auca.rw.registration.AucaRegistration.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
