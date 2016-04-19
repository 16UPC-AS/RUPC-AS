package entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "sales")
public class Sala extends Recurs {

	private String ubicacio;
	private Integer aforament;
	private Ordinador ordinador;
	private Projector projector;

	public Sala(String nom, String ubicacio, Integer aforament) {
		super(nom);
		this.ubicacio = ubicacio;
		this.aforament = aforament;
	}

	public Sala() {
		super();
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

	@OneToOne(mappedBy = "sala")
	public Ordinador getOrdinador() {
		return ordinador;
	}

	public void setOrdinador(Ordinador ordinador) {
		this.ordinador = ordinador;
	}

	@OneToOne(mappedBy = "sala")
	public Projector getProjector() {
		return projector;
	}

	public void setProjector(Projector projector) {
		this.projector = projector;
	}

	@Transient
	public Object[] getUniqueConstraint() {
		return super.getUniqueConstraint();
	}

	@Transient
	@Override
	public Boolean etsSala() {
		return true;
	}

	@Transient
	@Override
	public ArrayList<String> getInfo() {
		ArrayList<String> info = new ArrayList<String>();
		info.add(getNom());
		info.add(null);
		info.add(null);
		info.add(null);
		info.add(ubicacio);
		info.add(aforament.toString());
		if (getOrdinador() != null) {
			info.add(getOrdinador().getMarca());
			info.add(getOrdinador().getModel());
		} else {
			info.add(null);
			info.add(null);
		}
		if (getProjector() != null)
			;
		else
			info.add(null);
		return info;
	}

}
