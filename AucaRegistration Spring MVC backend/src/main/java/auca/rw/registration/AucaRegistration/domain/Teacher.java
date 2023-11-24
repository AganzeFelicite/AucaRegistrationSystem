package auca.rw.registration.AucaRegistration.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Teacher {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	@Column
	private String names;
	
	@Column(name="qualification")
	@Enumerated(EnumType.STRING)
	private EQualification equalification;
	
	@ManyToMany
	@JoinTable(name="teacher_course",
	joinColumns = @JoinColumn(name="teacher_id"),
	inverseJoinColumns = @JoinColumn(name="course_id")
	)
	private List<Course> courses;

	public Teacher(int code, String names, EQualification equalification, List<Course> courses) {
		super();
		this.code = code;
		this.names = names;
		this.equalification = equalification;
		this.courses = courses;
	}
	
	

	public Teacher() {
		super();
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public EQualification getEqualification() {
		return equalification;
	}

	public void setEqualification(EQualification equalification) {
		this.equalification = equalification;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
	
	
	
}
