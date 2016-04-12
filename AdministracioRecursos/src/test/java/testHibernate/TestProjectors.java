package testHibernate;

import entities.Objecte;
import entities.Projector;
import entities.Recurs;
import repositories.ObjecteRepo;
import repositories.ProjectorRepo;
import repositories.RecursRepo;

public class TestProjectors {

	public static void main(String[] args) {
		Recurs rec = new Recurs("FakeProjector");
		rec = RecursRepo.getByPK(rec.getUniqueConstraint());
		Objecte obj = ObjecteRepo.getByID(rec.getId());
		Projector proj = new Projector(obj, "1234x5678");
		ProjectorRepo.saveOrUpdate(proj);
	}
}
