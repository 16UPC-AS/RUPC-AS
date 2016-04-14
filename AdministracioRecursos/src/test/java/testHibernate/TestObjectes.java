package testHibernate;

import entities.Objecte;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.RecursRepo;

public class TestObjectes {

	public static void main(String[] args) {

		/**
		 * Objecte (pc {type = 0 }) sense sala
		 */
		Recurs recPC = new Recurs();
		recPC.setNom("FakePC");
		recPC = RecursRepo.getByPK(recPC.getUniqueConstraint());
		Objecte pc = new Objecte();
		pc.setId(recPC);
		pc.setType(0);

		ObjecteRepo.saveOrUpdate(pc);
		System.out.println(pc.getId().getId() + " " + pc.getId().getNom() + " " + pc.getId().getType() + " "
				+ pc.getType() + " " + pc.getSala());

		/**
		 * Objecte (projector {type = 1 }) amb sala
		 */
		// Recurs recProj = new Recurs();
		// recProj.setNom("FakeProjector");
		// recProj = RecursRepo.getByPK(recProj.getUniqueConstraint());
		// Objecte proj = new Objecte();
		// proj.setId(recProj);
		// Recurs recSala = new Recurs();
		// recSala.setNom("FakeSala");
		// recSala = RecursRepo.getByPK(recSala.getUniqueConstraint());
		// proj.setSala(SalaRepo.getByID(recSala.getId()));
		// proj.setType(1);
		//
		// SalaRepo.saveOrUpdate(proj);
		// System.out.println(proj.getId().getId() + " " + proj.getId().getNom()
		// + " " + proj.getId().getType() + " "
		// + proj.getType() + " " + proj.getSala());

		// Sala s = SalaRepo.getByID(u2.getId());
		// System.out.println(s.getId().getId() + " " + s.getId().getNom() + " "
		// + s.getId().getType() + " " +s.getUbicacio() + " "
		// +s.getAforament());
	}
}
