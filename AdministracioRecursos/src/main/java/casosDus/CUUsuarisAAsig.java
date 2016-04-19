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

		setNomRecurs(nomR);
		setData(d);
		setHoraInici(hi);
		return CUCreaReservaAmbNotificacio.obteUsuarisPerAssignar(nomR, d, hi);
	}

	public static void afegirUsuarisAReserva(ArrayList<String> usuaris) {
		CUCreaReservaAmbNotificacio.assignarUsuarisAReserva(usuaris);
	}
}
