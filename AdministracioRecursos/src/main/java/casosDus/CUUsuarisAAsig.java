package casosDus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dades.FactoriaDades;
import entities.Reserva;
import entities.Usuari;
import repositories.BasicRepo;

public class CUUsuarisAAsig {

	private static String nomRecurs;
	private static Date data;
	private static Integer horaInici;

	public static String getNomRecurs() {
		return nomRecurs;
	}

	public static void setNomRecurs(String nomRecurs) {
		CUUsuarisAAsig.nomRecurs = nomRecurs;
	}

	public static Date getData() {
		return data;
	}

	public static void setData(Date data) {
		CUUsuarisAAsig.data = data;
	}

	public static Integer getHoraInici() {
		return horaInici;
	}

	public static void setHoraInici(Integer horaInici) {
		CUUsuarisAAsig.horaInici = horaInici;
	}

	public static ArrayList<ArrayList<String>> obteUsuarisAAssignar(String nomR, Date d, Integer hi) {
		Calendar cal = Calendar.getInstance();
		Date dActual = cal.getTime();
		d = cal.getTime();

		if (dActual.after(d)) {
			// activa excepcio [reservaCaducada]
		}
		Reserva r = FactoriaDades.getCtrlReserva().getByPK(nomR, d, hi);
		if (!r.getEsAmbNotificacio())
			;// activa excepcio [NoReservaAmbNotificacio]
		List<Usuari> totsUsuaris = FactoriaDades.getCtrlUsuari().getAll();
		Set<Usuari> usus = r.getUsuaris();
		if (usus.size() >= 10)
			; // activa exc reservaATope
		ArrayList<ArrayList<String>> infoUsuaris = new ArrayList<ArrayList<String>>();

		for (Usuari u : totsUsuaris) {
			if (!usus.contains(u)) {
				infoUsuaris.add(u.getInfo()); // IMPLEMENTAR FUNCIO
			}

		}
		if (infoUsuaris.size() == 0)
			;// activa exp nohihaprouusuaris

		setNomRecurs(nomR);
		setData(d);
		setHoraInici(hi);
		return infoUsuaris;
	}

	public static void afegirUsuarisAReserva(ArrayList<String> usuaris) {

		Set<Usuari> usuReserv = new HashSet<Usuari>();
		for (String u : usuaris) {
			usuReserv.add(FactoriaDades.getCtrlUsuari().getByPK(u));
		}
		Reserva r = FactoriaDades.getCtrlReserva().getByPK(getNomRecurs(), getData(), getHoraInici());
		r.getUsuaris().addAll(usuReserv);
		BasicRepo.saveOrUpdate(r);

	}
}
