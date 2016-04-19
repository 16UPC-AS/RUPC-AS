package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import repositories.ObjecteRepo;
import repositories.CtrlOrdinador;
import repositories.CtrlProjector;

@Entity
@Table(name = "sales")
public class Sala extends Recurs {

	private String ubicacio;
	private Integer aforament;

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

	@Transient
	public Object[] getUniqueConstraint() {
		return super.getUniqueConstraint();
	}

	@Transient
	public ArrayList<String> getInfo(ObjecteRepo objRep, CtrlOrdinador ordRep, CtrlProjector projRep) {
		ArrayList<String> info = new ArrayList<String>();
//		info.add(ubicacio);
//		info.add(aforament.toString());
//		// ArrayList<String> infoObj = new ArrayList<String>();
//		List<Objecte> oList = objRep.getBySala(this);
//		if (oList != null) {
//			ArrayList<String> auxPc = null;
//			ArrayList<String> auxPr = null;
//			for (Objecte o : oList) {
//				if (o.getType() == 0)
//					auxPc = o.getInfo(ordRep, projRep);
//				else
//					auxPr = o.getInfo(ordRep, projRep);
//			}
//			if (auxPc != null) {
//				info.add(auxPc.get(0));
//				info.add(auxPc.get(1));
//			} else {
//				info.add(null);
//				info.add(null);
//			}
//			if (auxPr != null)
//				info.add(auxPr.get(2));
//			else
//				info.add(null);
//		}
		return info;
	}

}
