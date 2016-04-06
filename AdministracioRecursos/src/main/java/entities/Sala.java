package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "sales")
public class Sala implements Serializable {

	private Recurs id;
	private String ubicacio;
	private Integer aforament;

	@Id
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", unique = true, nullable = false)
	public Recurs getId() {
		return id;
	}

	public void setId(Recurs id) {
		this.id = id;
	}

	@Column(name = "aforament", nullable = false)
	public Integer getAforament() {
		return aforament;
	}

	public void setAforament(Integer aforament) {
		this.aforament = aforament;
	}

	@Column(name = "ubicacio", nullable = false, length = 10)
	public String getUbicacio() {
		return ubicacio;
	}

	public void setUbicacio(String ubicacio) {
		this.ubicacio = ubicacio;
	}

	@Transient
	public Object[] getUniqueConstraint() {
		return new Object[] {};
	}

}
