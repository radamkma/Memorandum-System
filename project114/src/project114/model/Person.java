package project114.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id @GeneratedValue
	private long person_id;
	private String firstname;
	private String lastname;
	@ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "department")
	private Department department;
	@ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "position")
	private Position position;
	@ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "role")
	private Role role;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Memo_Person> memoPerson = new HashSet<Memo_Person>();
	//private long sign_id;
	//private long role_id;
	
	public Person() {}
	public Person(String fn, String ln, Department d, Position p, Role r) {
		this.firstname = fn;
		this.lastname = ln;
		this.department = d;
		this.position = p;
		this.role = r;
	}
	
	public long getPerson_id() {
		return person_id;
	}
	public void setPerson_id(long person_id) {
		this.person_id = person_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
