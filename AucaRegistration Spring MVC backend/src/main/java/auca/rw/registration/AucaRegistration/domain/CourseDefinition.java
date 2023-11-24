package auca.rw.registration.AucaRegistration.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@Entity
public class CourseDefinition {
	@Id

	private String code;

	private String name;

	private String description;
	
	@OneToOne(mappedBy = "courseDef", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private Course course;
	
	public CourseDefinition() {
		super();
	}

	public CourseDefinition(String code, String name, String description, Course course) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.course = course;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	

}
