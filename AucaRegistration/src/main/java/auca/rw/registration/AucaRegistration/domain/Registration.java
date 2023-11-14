package auca.rw.registration.AucaRegistration.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name="Student_registration")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentId")
public class Registration{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	@Column
	private LocalDate registeredDate;
	
	@Column(name="regitration_status")

	private String registration_status;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "code")
	//@JsonIgnore
	//@JsonManagedReference
	private Student student;

	@ManyToOne
	@JoinColumn(name="academic_unit")
	//@JsonManagedReference
	private AcademicUnit academic_category;
//	
//	@ManyToMany
//	private Course course;
	
	@ManyToOne
	@JoinColumn(name="sem_id")
	//@JsonBackReference
	private Semester semester;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(name = "studentId"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	@JsonManagedReference
	private List<Course> courseList = new ArrayList<Course>();

	public Registration(int studentId, LocalDate registeredDate, String registration_status,
			Student student, AcademicUnit academic_category, Semester semester, List<Course> courseList) {
		super();
		this.studentId = studentId;
		this.registeredDate = registeredDate;
		this.registration_status = registration_status;
		this.student = student;
		this.academic_category = academic_category;
		this.semester = semester;
		this.courseList = courseList;
	}

	public Registration() {
		super();
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getRegistration_status() {
		return registration_status;
	}

	public void setRegistration_status(String registration_status) {
		this.registration_status = registration_status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AcademicUnit getAcademic_category() {
		return academic_category;
	}

	public void setAcademic_category(AcademicUnit academic_category) {
		this.academic_category = academic_category;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	
	
	
}
