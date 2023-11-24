package auca.rw.registration.AucaRegistration.domain;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "semId")
public class Semester {
	   	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "semId")
	    private int semId;
	    
	    @Column
	    private String name;
	    
	    @Column
	    private LocalDate startDate;
	    
	    @Column
	    private LocalDate endDate;
	    
	    @OneToMany(mappedBy = "semester")
		//@JsonBackReference
		@JsonIgnore
	    private List<Course> courses;  // Note the plural form 'courses' here
	    
	    @OneToMany(mappedBy = "semester", fetch = FetchType.EAGER)

		//@JsonManagedReference
		@JsonIgnore
		private List<Registration> studentRegistrations;  // Note the plural form 'studentRegistrations' here

	    public Semester() {
	        // No-argument constructor
	    }

		public Semester(int semId, String name, LocalDate startDate, LocalDate endDate, List<Course> courses,
				List<Registration> studentRegistrations) {
			super();
			this.semId = semId;
			this.name = name;
			this.startDate = startDate;
			this.endDate = endDate;
			this.courses = courses;
			this.studentRegistrations = studentRegistrations;
		}

		public int getSemId() {
			return semId;
		}

		public void setSemId(int semId) {
			this.semId = semId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}

		public List<Registration> getStudentRegistrations() {
			return studentRegistrations;
		}

		public void setStudentRegistrations(List<Registration> studentRegistrations) {
			this.studentRegistrations = studentRegistrations;
		}

	  
	
}
