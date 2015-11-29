package project114.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Department {
	
	@Id @GeneratedValue
	private long department_id;
	private String department;
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Person> persons;
	
	public Department() {}
	public Department(String d) {
		this.department = d;
	}
	
	public long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
	
	
}
