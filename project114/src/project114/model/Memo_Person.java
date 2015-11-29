package project114.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Memo_Person {
	
	@Id @GeneratedValue
	private long memo_person_id;
	@ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "memo")
	private Memo memo;
	@ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "person")
	private Person person;
	private boolean signed;
	@Temporal(TemporalType.DATE)
	private Date signDate;
	public long getMemo_person_id() {
		return memo_person_id;
	}
	public void setMemo_person_id(long memo_person_id) {
		this.memo_person_id = memo_person_id;
	}
	public Memo getMemo() {
		return memo;
	}
	public void setMemo(Memo memo) {
		this.memo = memo;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public boolean isSigned() {
		return signed;
	}
	public void setSigned(boolean signed) {
		this.signed = signed;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	
	
}
