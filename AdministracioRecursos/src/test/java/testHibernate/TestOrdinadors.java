package testHibernate;

import entities.Objecte;
import entities.Ordinador;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.OrdinadorRepo;
import repositories.RecursRepo;

public class TestOrdinadors {

	public static void main(String[] args) {
		Recurs rec = new Recurs("FakePC");
		rec = RecursRepo.getByPK(rec.getUniqueConstraint());
		Objecte obj = ObjecteRepo.getByID(rec.getId());
		Ordinador ord = new Ordinador(obj,"FakeMarca","FakeModel");
		OrdinadorRepo.saveOrUpdate(ord);

	}
}
