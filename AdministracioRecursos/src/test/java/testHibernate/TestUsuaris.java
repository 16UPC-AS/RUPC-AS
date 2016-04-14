package testHibernate;

import entities.Usuari;
import repositories.UsuariRepo;

public class TestUsuaris {

	public static void main(String[] args) {
		Usuari u2 = new Usuari();
		u2.setUsername("FakeUser");

		u2.setNom("FakeName");
		u2.setMail("Fake@Mail.com");
		UsuariRepo.saveOrUpdate(u2);

		System.out.println(u2.getNom() + " " + u2.getUsername() + " " + u2.getMail());
		// u2 = UsuariRepo.getByPK(u2.getUniqueConstraint());

	}
}
