package FirstHibernate.com.myhibernate;

import entities.Usuari;
import repositories.UsuariRepo;

public class MainTest {

	public static void main(String[] args) {
		// List<Recurs> recs =RecursRepo.getAll();
		// for (Recurs rec : recs){
		// System.out.println(rec.getId()+" "+rec.getNom());
		// }
		Usuari u2 = new Usuari();
		u2.setUsername("jj");

		u2 = UsuariRepo.getByPK(u2.getUniqueConstraint());
		u2.setNom("Joan");
		u2.setMail("bbb@bbb.as");
		UsuariRepo.saveOrUpdate(u2);

		System.out.println(u2.getNom() + " " + u2.getUsername() + " " + u2.getMail());
		// Usuari u = UsuariRepo.getByID(1L);
		// Map<String, ClassMetadata> m =
		// HibernateUtil.getSessionFactory().getAllClassMetadata();
		// System.out.println(m.toString());
		// System.out.println(u.getNom() + " " + u.getUsername() + " " +
		// u.getMail());
	}
}
