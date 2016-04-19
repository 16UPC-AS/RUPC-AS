package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import repositories.ObjecteRepo;
import repositories.CtrlOrdinador;
import repositories.CtrlProjector;
import repositories.CtrlReserva;
import repositories.CtrlSala;

@Entity
@Table(name = "recursos", uniqueConstraints = @UniqueConstraint(columnNames = { "nom" }))
public class Recurs {

	private String nom;
	private Integer type;

	public Recurs(String nom, Integer type) {
		super();
		this.nom = nom;
		this.type = type;
	}

	public Recurs(String nom) {
		super();
		this.nom = nom;
	}

	public Recurs() {
		super();
	}

	@Id
	@Column(name = "nom", nullable = false, length = 20)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		return new Object[] { this.getNom() };
	}

	@Transient
	public ArrayList<String> estasDisp(Date d, Integer hi, Integer hf, ObjecteRepo objRep, CtrlSala salaRep,
			CtrlProjector projRep, CtrlOrdinador ordRep) {

		List<Reserva> lReserv = CtrlReserva.getByRecurs(this);
		if (lReserv != null)
			for (Reserva r : lReserv) {
				if (!r.esDisponible(d, hi, hf))
					return null;
			}
		return this.getInfo(salaRep, objRep, ordRep, projRep);

	}

	@Transient
	private ArrayList<String> getInfo(CtrlSala salaRep, ObjecteRepo objRep, CtrlOrdinador ordRep,
			CtrlProjector projRep) {
		ArrayList<String> toReturn = new ArrayList<String>();
//		if (type == 0) {
//			toReturn.add(nom);
//			toReturn.add(null);
//			toReturn.add(null);
//			toReturn.add(null);
//			toReturn.addAll(salaRep.getByID(id).getInfo(objRep, ordRep, projRep));
//		} else {
//			Objecte obj = objRep.getByID(id);
//			if (obj.getSala() == null) {
//				toReturn.add(nom);
//				toReturn.addAll(obj.getInfo(ordRep, projRep));
//				toReturn.add(null);
//				toReturn.add(null);
//				toReturn.add(null);
//				toReturn.add(null);
//				toReturn.add(null);
//			}
//			else return null;
//		}
		return toReturn;
	}

}
