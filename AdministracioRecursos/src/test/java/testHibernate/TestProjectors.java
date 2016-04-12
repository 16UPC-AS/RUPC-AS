package testHibernate;

import entities.Objecte;
import entities.Projector;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.ProjectorRepo;
import repositories.RecursRepo;

public class TestProjectors {

	public static void main(String[] args) {
		
		Recurs recProj = new Recurs("FakeProjector", 1);
		RecursRepo.saveOrUpdate(recProj);
		Objecte objProj = new Objecte(recProj, null, 1);
		ObjecteRepo.saveOrUpdate(objProj);
		
		Projector proj = new Projector(objProj, "1234x5678");
		ProjectorRepo.saveOrUpdate(proj);
	}
}
