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

	}
}
