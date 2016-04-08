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
		 Recurs rec = RecursRepo.getByID(2L);
		 Usuari u = UsuariRepo.getByID(1L);
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.YEAR, 2016);
		 cal.set(Calendar.MONTH, Calendar.APRIL);
		 cal.set(Calendar.DAY_OF_MONTH, 10);
		 Date d = cal.getTime();
		
		
		 Reserva resv = new Reserva();
		 resv.setData(d);
		 resv.setRecurs(rec);
		 resv.setUsuari(u);
		 resv.setHoraInici(10);
		 resv.setHoraFi(12);
		 resv.setEsAmbNotificacio(false);
		 OrdinadorRepo.saveOrUpdate(resv);

//		Reserva res = ReservaRepo.getByID(2L);
//		System.out.println(res.getData() + " " + res.getHoraInici() + "-" + res.getHoraFi() + " "
//				+ res.getRecurs().getNom() + " " + res.getUsuari().getUsername());

	}
}
