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

import repositories.CtrlReserva;

@Entity
@Table(name = "recursos", uniqueConstraints = @UniqueConstraint(columnNames = { "nom" }))
public class Recurs {

	private String nom;

	public Recurs(String nom, Integer type) {
		super();
		this.nom = nom;
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

	@Transient
	public Object[] getUniqueConstraint() {
		return new Object[] { this.getNom() };
	}

	@Transient
	public ArrayList<String> estasDisp(Date d, Integer hi, Integer hf) {

		List<Reserva> lReserv = CtrlReserva.getByRecurs(this);
		if (lReserv != null)
			for (Reserva r : lReserv) {
				if (!r.esDisponible(d, hi, hf))
					return null;
			}
		return this.getInfo();

	}

	@Transient
	public ArrayList<String> getInfo() {
		return null;
	}

}
