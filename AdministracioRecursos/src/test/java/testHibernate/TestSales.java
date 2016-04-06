package testHibernate;

import entities.Recurs;
import entities.Sala;
import repositories.RecursRepo;
import repositories.SalaRepo;

public class TestSales {

	public static void main(String[] args) {
		Recurs u2 = new Recurs();
		u2.setNom("FakeResource2");
		u2 = RecursRepo.getByPK(u2.getUniqueConstraint());
		Sala s = new Sala();
		s.setId(u2);
		s.setUbicacio("Barcelona");
		s.setAforament(100);
		
		SalaRepo.saveOrUpdate(s);
//		System.out.println(u2.getId() + " " + u2.getNom() + " " + u2.getType());
		// u2 = UsuariRepo.getByPK(u2.getUniqueConstraint());

	}
}
