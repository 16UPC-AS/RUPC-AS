package testHibernate;

import entities.Objecte;
import entities.Ordinador;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.OrdinadorRepo;
import repositories.RecursRepo;

public class TestOrdinadors {

	public static void main(String[] args) {
		Recurs recOrd = new Recurs("FakePC", 1);
		RecursRepo.saveOrUpdate(recOrd);
		Objecte objOrd = new Objecte(recOrd, null, 0);
		ObjecteRepo.saveOrUpdate(objOrd);
		Ordinador ord = new Ordinador(objOrd,"FakeMarca","FakeModel");
		OrdinadorRepo.saveOrUpdate(ord);
	}
}
