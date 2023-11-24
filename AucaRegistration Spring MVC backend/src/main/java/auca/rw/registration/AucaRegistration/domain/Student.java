package auca.rw.registration.AucaRegistration.domain;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "regNo")
public class Student {
    @Id
    @Column
    @GeneratedValue(generator = "regNo")
    @GenericGenerator(name="regNo", strategy = "auca.rw.registration.AucaRegistration.domain.CustomIDGenerator")
    private Integer regNo;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String dateOfBirth;

    //
    @OneToMany(mappedBy ="student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Registration> registratioList = new ArrayList<Registration>();

    public Student() {
    }

    public Student(Integer regNo, String firstName, String lastName, String dateOfBirth, List<Registration> registratioList) {
        this.regNo = regNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.registratioList = registratioList;
    }

    public Integer getRegNo() {
        return regNo;
    }

    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Registration> getRegistratioList() {
        return registratioList;
    }

    public void setRegistratioList(List<Registration> registratioList) {
        this.registratioList = registratioList;
    }
}
