package testHibernate;

import entities.Objecte;
import entities.Ordinador;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.CtrlOrdinador;
import repositories.CtrlRecurs;
import repositories.CtrlSala;

public class TestOrdinadors {
//
//	private static Ordinador newOrdinador(String nom, String nomSala, String marca, String model) {
//		Recurs recOrd = new Recurs(nom, 1);
//		CtrlRecurs.saveOrUpdate(recOrd);
//		Objecte objOrd = new Objecte(recOrd, CtrlSala.getByPK(new Object[] { nomSala }), 0);
//		ObjecteRepo.saveOrUpdate(objOrd);
//		Ordinador ord = new Ordinador(objOrd, marca, model);
//		CtrlOrdinador.saveOrUpdate(ord);
//		return ord;
//	}
//
//	public static void main(String[] args) {
//		Ordinador ord = newOrdinador("FakePC4", "Sala d'actes", "FakeMarca", "FakeModel");
//		System.out.println(ord.getId().getId().getNom());
//	}
}
