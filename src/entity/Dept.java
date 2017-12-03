package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dept database table.
 * 
 */
@Entity
@NamedQuery(name="Dept.findAll", query="SELECT d FROM Dept d")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToMany(mappedBy="id")
	private long id;

	@Column
	private String name;

	public Dept() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}