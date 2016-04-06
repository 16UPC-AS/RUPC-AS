package testHibernate;

import entities.Recurs;
import repositories.RecursRepo;

public class TestRecursos {

	public static void main(String[] args) {
		Recurs u2 = new Recurs();
		u2.setNom("FakeResource2");
		u2.setType(0);
		RecursRepo.saveOrUpdate(u2);

		System.out.println(u2.getId() + " " + u2.getNom() + " " + u2.getType());
		// u2 = UsuariRepo.getByPK(u2.getUniqueConstraint());

	}
}
