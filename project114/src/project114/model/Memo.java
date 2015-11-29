package project114.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Memo {
	
	@Id @GeneratedValue
	private long memo_id;
    private String title;
    private String url;
    private String description;
    
    @OneToMany(mappedBy = "memo", cascade = CascadeType.ALL)
    private Set<Memo_Person> memoPerson = new HashSet<Memo_Person>();
    
    public Memo() {}
    public Memo(String title, String url, String description) {
    	this.title = title;
    	this.url = url;
    	this.description = description;
    }
    
	public long getMemo_id() {
		return memo_id;
	}
	public void setMemo_id(long memo_id) {
		this.memo_id = memo_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Memo_Person> getMemoPerson() {
		return memoPerson;
	}
	public void setMemoPerson(Set<Memo_Person> memoPerson) {
		this.memoPerson = memoPerson;
	}
	


    
    

}
