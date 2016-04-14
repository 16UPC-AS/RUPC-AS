package testHibernate;

import entities.Recurs;
import entities.Sala;
import repositories.RecursRepo;
import repositories.SalaRepo;

public class TestSales {

	public static void main(String[] args) {
		Recurs rec = new Recurs("FakeSala", 0);
		RecursRepo.saveOrUpdate(rec);
		Sala s = new Sala(rec, "Barcelona", 72);
		SalaRepo.saveOrUpdate(s);

		System.out.println(s.getId().getId() + " " + s.getId().getNom() + " " + s.getId().getType() + " "
				+ s.getUbicacio() + " " + s.getAforament());
		// Sala s2 = SalaRepo.getByID(rec.getId());
		// System.out.println(s2.getId().getId() + " " + s2.getId().getNom() + "
		// " + s2.getId().getType() + " "
		// + s2.getUbicacio() + " " + s2.getAforament());
	}
}
