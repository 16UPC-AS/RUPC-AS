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
@Table(name = "ordinadors")
public class Ordinador implements Serializable {

	private Objecte id;
	private String marca;
	private String model;

	public Ordinador(Objecte id, String marca, String model) {
		super();
		this.id = id;
		this.marca = marca;
		this.model = model;
	}

	public Ordinador() {
		super();
	}

	@Id
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id", unique = true, nullable = false)
	public Objecte getId() {
		return id;
	}

	public void setId(Objecte id) {
		if (id.getType() == 0)
			this.id = id;
		else
			System.out.println("L'Objecte " + id.getId().getNom() + " no és un Ordinador");
	}

	@Column(name = "marca", nullable = false, length = 20)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Column(name = "model", nullable = false, length = 20)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Transient
	public Object[] getUniqueConstraint() {
		return new Object[] {};
	}

}
