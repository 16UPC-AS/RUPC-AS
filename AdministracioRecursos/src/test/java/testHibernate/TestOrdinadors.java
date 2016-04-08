package testHibernate;

import entities.Objecte;
import entities.Ordinador;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.OrdinadorRepo;
import repositories.RecursRepo;

public class TestOrdinadors {

	public static void main(String[] args) {
		Recurs rec = new Recurs();
		rec.setNom("FakePC");
		rec = RecursRepo.getByPK(rec.getUniqueConstraint());
		Objecte obj = ObjecteRepo.getByID(rec.getId());
		Ordinador ord = new Ordinador();
		ord.setId(obj);
		ord.setMarca("FakeMarca");
		ord.setModel("FakeModel");
		OrdinadorRepo.saveOrUpdate(ord);
			
		
//		Sala s = new Sala();
//		s.setId(u2);
//		s.setUbicacio("Barcelona");
//		s.setAforament(72);
//		
//		SalaRepo.saveOrUpdate(s);
//		System.out.println(s.getId().getId() + " " + s.getId().getNom() + " " + s.getId().getType() + " " +s.getUbicacio() + " " +s.getAforament());
//		Sala s2 = SalaRepo.getByID(rec.getId());
//		System.out.println(s2.getId().getId() + " " + s2.getId().getNom() + " " + s2.getId().getType() + " " +s2.getUbicacio() + " " +s2.getAforament());
	}
}
