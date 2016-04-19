package transactions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.type.SerializationException;

import dades.FactoriaDades;
import entities.Reserva;
import entities.Usuari;

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
}
