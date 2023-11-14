package auca.rw.registration.AucaRegistration.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCourseBean {
    private Integer stId;
    private Integer CourseId;
}
