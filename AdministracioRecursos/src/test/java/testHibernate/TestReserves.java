package testHibernate;

import java.util.Calendar;
import java.util.Date;

import entities.Recurs;
import entities.Reserva;
import entities.Usuari;
import repositories.OrdinadorRepo;
import repositories.RecursRepo;
import repositories.ReservaRepo;
import repositories.UsuariRepo;

public class TestReserves {

	public static void main(String[] args) {
		Recurs rec = RecursRepo.getByPK(new Object[]{"FakeSala"});
		Usuari u = UsuariRepo.getByPK(new Object[]{"FakeUser"});
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 17);
		Date d = cal.getTime();

		Reserva resv = new Reserva(rec, u, d, 10, 12, "Prova diversa", false);
		OrdinadorRepo.saveOrUpdate(resv);

		// Reserva res = ReservaRepo.getByID(2L);
		// System.out.println(res.getData() + " " + res.getHoraInici() + "-" +
		// res.getHoraFi() + " "
		// + res.getRecurs().getNom() + " " + res.getUsuari().getUsername());

	}
}
