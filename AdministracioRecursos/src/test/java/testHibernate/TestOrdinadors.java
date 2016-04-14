package testHibernate;

import entities.Objecte;
import entities.Ordinador;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.OrdinadorRepo;
import repositories.RecursRepo;
import repositories.SalaRepo;

public class TestOrdinadors {

	private static Ordinador newOrdinador(String nom, String nomSala, String marca, String model) {
		Recurs recOrd = new Recurs(nom, 1);
		RecursRepo.saveOrUpdate(recOrd);
		Objecte objOrd = new Objecte(recOrd, SalaRepo.getByPK(new Object[] { nomSala }), 0);
		ObjecteRepo.saveOrUpdate(objOrd);
		Ordinador ord = new Ordinador(objOrd, marca, model);
		OrdinadorRepo.saveOrUpdate(ord);
		return ord;
	}

	public static void main(String[] args) {
		Ordinador ord = newOrdinador("FakePC3", "FakeSala", "FakeMarca", "FakeModel");
		System.out.println(ord.getId().getId().getNom());
	}
}
