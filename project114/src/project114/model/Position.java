package project114.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Position {
	
	@Id @GeneratedValue
	private long position_id;
	private String position;
	@OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
	private Set<Person> persons;
	
	public Position() {}
	public Position(String p) {
		this.position = p;
	}
	public long getPosition_id() {
		return position_id;
	}
	public void setPosition_id(long position_id) {
		this.position_id = position_id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
	
	
}
