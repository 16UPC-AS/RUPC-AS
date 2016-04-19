package entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import repositories.CtrlOrdinador;
import repositories.CtrlProjector;

@Entity
@Table(name = "objectes")
public class Objecte extends Recurs {

	private Sala sala;
	
	public Objecte(String nom, Sala sala) {
		super(nom);
		this.sala = sala;
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
	public ArrayList<String> getInfo(CtrlOrdinador ordRep, CtrlProjector projRep) {
		ArrayList<String> toReturn = new ArrayList<String>();
		// if (type == 0) {
		//// Ordinador ord = ordRep.getByID(getId().getId());
		// toReturn.addAll(ordRep.getByID(getId().getId()).getInfo());
		// toReturn.add(null);
		// } else {
		// toReturn.add(null);
		// toReturn.add(null);
		// toReturn.add(projRep.getByID(getId().getId()).getResolucio().toString());
		// }
		return toReturn;

	}

}
