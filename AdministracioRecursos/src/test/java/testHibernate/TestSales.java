package testHibernate;

import entities.Recurs;
import entities.Sala;
import repositories.RecursRepo;
import repositories.SalaRepo;

public class TestSales {

	public static void main(String[] args) {
		Recurs u2 = new Recurs();
		u2.setNom("FakeSala2");
		u2 = RecursRepo.getByPK(u2.getUniqueConstraint());
		// Sala s = new Sala();
		// s.setId(u2);
		// s.setUbicacio("Barcelona");
		// s.setAforament(72);
		//
		// SalaRepo.saveOrUpdate(s);
		// System.out.println(s.getId().getId() + " " + s.getId().getNom() + " "
		// + s.getId().getType() + " " +s.getUbicacio() + " "
		// +s.getAforament());
		Sala s2 = SalaRepo.getByID(u2.getId());
		System.out.println(s2.getId().getId() + " " + s2.getId().getNom() + " " + s2.getId().getType() + " "
				+ s2.getUbicacio() + " " + s2.getAforament());
	}
}
