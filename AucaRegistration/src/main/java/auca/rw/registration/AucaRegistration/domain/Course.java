package auca.rw.registration.AucaRegistration.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
@Data
@Builder
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	

	@OneToOne
	@JoinColumn(name="course_id")
	@JsonManagedReference
	private CourseDefinition courseDef;
	
	@ManyToMany(mappedBy = "courses")
	private List<Teacher> teachers;
	
	
	@ManyToOne
	@JoinColumn(name="sem_id")
	//@JsonManagedReference
	private Semester semester;

	@ManyToMany(mappedBy = "courseList")
	@JsonBackReference
	private List<Registration> registrations = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name="academicUnit_id")
	//@JsonBackReference

	private AcademicUnit academics;

	public Course(int code, CourseDefinition courseDef, List<Teacher> teachers, Semester semester,
			List<Registration> registrations, AcademicUnit academics) {
		super();
		this.code = code;
		this.courseDef = courseDef;
		this.teachers = teachers;
		this.semester = semester;
		this.registrations = registrations;
		this.academics = academics;
	}

	public Course() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public CourseDefinition getCourseDef() {
		return courseDef;
	}

	public void setCourseDef(CourseDefinition courseDef) {
		this.courseDef = courseDef;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public AcademicUnit getAcademics() {
		return academics;
	}

	public void setAcademics(AcademicUnit academics) {
		this.academics = academics;
	}
	

	
}
