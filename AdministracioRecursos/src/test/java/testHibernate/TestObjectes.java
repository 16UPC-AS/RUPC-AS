package testHibernate;

import entities.Objecte;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.RecursRepo;
import repositories.SalaRepo;

public class TestObjectes {

	public static void main(String[] args) {

		/**
		 * Objecte (pc {type = 0 }) sense sala
		 */
		Recurs recPC = new Recurs("FakePC", 1);
		RecursRepo.saveOrUpdate(recPC);

		Objecte pc = new Objecte(recPC, null, 0);
		ObjecteRepo.saveOrUpdate(pc);

		System.out.println(pc.getId().getId() + " " + pc.getId().getNom() + " " + pc.getId().getType() + " "
				+ pc.getType() + " " + pc.getSala());

		/**
		 * Objecte (projector {type = 1 }) amb sala
		 */
		Recurs recProj = new Recurs("FakeProjector", 1);
		RecursRepo.saveOrUpdate(recProj);

		Recurs recSala = new Recurs("FakeSala");
		recSala = RecursRepo.getByPK(recSala.getUniqueConstraint());

		Objecte proj = new Objecte(recProj, SalaRepo.getByID(recSala.getId()), 1);

		ObjecteRepo.saveOrUpdate(proj);
		System.out.println(proj.getId().getId() + " " + proj.getId().getNom() + " " + proj.getId().getType() + " "
				+ proj.getType() + " " + proj.getSala());

		// Sala s = SalaRepo.getByID(u2.getId());
		// System.out.println(s.getId().getId() + " " + s.getId().getNom() + " "
		// + s.getId().getType() + " " +s.getUbicacio() + " "
		// +s.getAforament());
	}
}
