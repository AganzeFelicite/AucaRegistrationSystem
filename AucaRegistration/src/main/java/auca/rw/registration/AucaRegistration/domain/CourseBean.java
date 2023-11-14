package auca.rw.registration.AucaRegistration.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;


public class CourseBean {
    private String courseDefId;
    private int semesterId;
    //private int teacherId;
    //private int registrationId;
    private String acadId;

    public CourseBean(String courseDefId, int semesterId, String acadId) {
        this.courseDefId = courseDefId;
        this.semesterId = semesterId;
        this.acadId = acadId;
    }

    public String getCourseDefId() {
        return courseDefId;
    }

    public void setCourseDefId(String courseDefId) {
        this.courseDefId = courseDefId;
    }


    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getAcadId() {
        return acadId;
    }

    public void setAcadId(String acadId) {
        this.acadId = acadId;
    }

    public CourseBean() {
    }
}
