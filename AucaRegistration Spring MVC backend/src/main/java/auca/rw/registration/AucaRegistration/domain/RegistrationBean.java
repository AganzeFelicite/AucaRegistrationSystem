package auca.rw.registration.AucaRegistration.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationBean {
    private int studId;
    private int semId;
    private String acadId;
    private String regStatus;
}
