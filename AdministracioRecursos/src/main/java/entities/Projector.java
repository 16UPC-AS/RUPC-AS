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
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name = "projectors")
public class Projector extends Recurs {

	private String resolucio;
	private Sala sala;

	public Projector(String nom, Sala sala, String resolucio) {
		super(nom);
		this.resolucio = resolucio;
		this.sala = sala;
	}

	public Projector() {
		super();
	}

	@Column(name = "resolucio", nullable = false, length = 20)
	public String getResolucio() {
		return resolucio;
	}

	public void setResolucio(String resolucio) {
		this.resolucio = resolucio;
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
		info.add(null);
		info.add(null);
		info.add(resolucio);
		info.add(null);
		info.add(null);
		info.add(null);
		info.add(null);
		info.add(null);
		info.add(null);
		return info;
	}

}
