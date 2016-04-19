package entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE )
@Table(name = "ordinadors")
public class Ordinador extends Recurs {

	private String marca;
	private String model;
	private Sala sala;

	public Ordinador(String nom, Sala sala, String marca, String model) {
		super(nom);
		this.marca = marca;
		this.model = model;
		this.sala = sala;
	}

	public Ordinador() {
		super();
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

	@OneToOne
	@JoinColumn(name = "sala", referencedColumnName = "nom", nullable = true)
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Transient
	public Object[] getUniqueConstraint() {
		return super.getUniqueConstraint();
	}

	@Transient
	@Override
	public ArrayList<String> getInfo() {
		ArrayList<String> info = new ArrayList<String>();
		info.add(getNom());
		info.add(marca);
		info.add(model);
		info.add(null);
		info.add(null);
		info.add(null);
		info.add(null);
		info.add(null);
		info.add(null);
		return info;
	}

}
