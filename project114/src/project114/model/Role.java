package project114.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Role {
	@Id @GeneratedValue
	private long role_id;
	private String role;
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<Person> persons;
	
	public Role() {}
	public Role(String r) {
		this.role = r;
	}
	public long getRole_id() {
		return role_id;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
	
}
