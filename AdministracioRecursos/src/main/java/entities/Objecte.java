package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "objectes")
public class Objecte implements Serializable {

	private Recurs id;
	private Sala sala;
	private Integer type;

	@Id
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id", unique = true, nullable = false)
	public Recurs getId() {
		return id;
	}

	public void setId(Recurs id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "idsala", referencedColumnName = "id", nullable = true)
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Transient
	public Object[] getUniqueConstraint() {
		return new Object[] {};
	}

}
