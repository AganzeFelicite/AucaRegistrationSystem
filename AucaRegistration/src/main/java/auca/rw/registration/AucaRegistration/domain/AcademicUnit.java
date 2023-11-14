package auca.rw.registration.AucaRegistration.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
public class AcademicUnit {
	@Id

	public String code;
	

	private String name;
	
	@Column(name="academic_category")

	private String eacademicUnit;
	
	
	@ManyToOne
	@JoinColumn(name="parent_code", nullable = true)
	private AcademicUnit academicUnit;
	
	
	@OneToOne(mappedBy = "academic_category")
	@JsonIgnore
	private Registration studentRegistration;

	
	@OneToMany(mappedBy = "academics", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Course> listOfCourses;


	public AcademicUnit(String code, String name, String eacademicUnit, AcademicUnit academicUnit,
			Registration studentRegistration, List<Course> listOfCourses) {
		super();
		this.code = code;
		this.name = name;
		this.eacademicUnit = eacademicUnit;
		this.academicUnit = academicUnit;
		this.studentRegistration = studentRegistration;
		this.listOfCourses = listOfCourses;
	}


	public AcademicUnit() {
		super();
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEacademicUnit() {
		return eacademicUnit;
	}


	public void setEacademicUnit(String eacademicUnit) {
		this.eacademicUnit = eacademicUnit;
	}


	public AcademicUnit getAcademicUnit() {
		return academicUnit;
	}


	public void setAcademicUnit(AcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}


	public Registration getStudentRegistration() {
		return studentRegistration;
	}


	public void setStudentRegistration(Registration studentRegistration) {
		this.studentRegistration = studentRegistration;
	}


	public List<Course> getListOfCourses() {
		return listOfCourses;
	}


	public void setListOfCourses(List<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}


	
}
