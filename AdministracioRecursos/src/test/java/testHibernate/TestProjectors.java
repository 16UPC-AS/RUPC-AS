package testHibernate;

import entities.Objecte;
import entities.Projector;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.CtrlProjector;
import repositories.CtrlRecurs;
import repositories.CtrlSala;

public class TestProjectors {
//
//	private static Projector newProjector(String nom, String nomSala, String resolucio) {
//		Recurs recProj = new Recurs(nom, 1);
//		CtrlRecurs.saveOrUpdate(recProj);
//		Objecte objProj = new Objecte(recProj, CtrlSala.getByPK(new Object[] { nomSala }), 1);
//		ObjecteRepo.saveOrUpdate(objProj);
//		Projector proj = new Projector(objProj, resolucio);
//		CtrlProjector.saveOrUpdate(proj);
//		return proj;
//	}
//
//	public static void main(String[] args) {
//		Projector proj = newProjector("FakeProjector3", "", "1024x768");
//		System.out.println(proj.getId().getId().getNom());
//	}
}
