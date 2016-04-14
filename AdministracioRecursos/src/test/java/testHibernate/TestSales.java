package testHibernate;

import entities.Projector;
import entities.Recurs;
import entities.Sala;
import repositories.RecursRepo;
import repositories.SalaRepo;

public class TestSales {

	private static Sala newSala(String nom, String ubicacio, Integer aforament) {
		Recurs rec = new Recurs(nom, 0);
		RecursRepo.saveOrUpdate(rec);
		Sala s = new Sala(rec, ubicacio, aforament);
		SalaRepo.saveOrUpdate(s);
		return s;
	}

	public static void main(String[] args) {
		Sala s = newSala("Sala d'actes", "CampusNord", 72);
		System.out.println(s.getId().getId() + " " + s.getId().getNom() + " " + s.getId().getType() + " "
				+ s.getUbicacio() + " " + s.getAforament());
		// Sala s2 = SalaRepo.getByID(rec.getId());
		// System.out.println(s2.getId().getId() + " " + s2.getId().getNom() + "
		// " + s2.getId().getType() + " "
		// + s2.getUbicacio() + " " + s2.getAforament());
	}
}
