package auca.rw.registration.AucaRegistration.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDefinitionBean {

    private String code;

    private String name;

    private String description;
}
