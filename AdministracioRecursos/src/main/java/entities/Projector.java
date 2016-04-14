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
@Table(name = "projectors")
public class Projector implements Serializable {

	private Objecte id;
	private String resolucio;

	@Id
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id", unique = true, nullable = false)
	public Objecte getId() {
		return id;
	}

	public void setId(Objecte id) {
		if (id.getType() == 1)
			this.id = id;
		else
			System.out.println("L'Objecte " + id.getId().getNom() + " no és un Projector");
	}

	@Column(name = "resolucio", nullable = false, length = 20)
	public String getResolucio() {
		return resolucio;
	}

	public void setResolucio(String resolucio) {
		this.resolucio = resolucio;
	}

	@Transient
	public Object[] getUniqueConstraint() {
		return new Object[] {};
	}

}
