package casosDus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.type.SerializationException;

import dades.FactoriaDades;
import entities.Reserva;
import entities.Usuari;
import repositories.BasicRepo;

public class CUAfegirUsuaris {

	private static String nomRecurs;
	private static Date data;
	private static Integer horaInici;

	public static String getNomRecurs() {
		return nomRecurs;
	}

	public static void setNomRecurs(String nomRecurs) {
		CUAfegirUsuaris.nomRecurs = nomRecurs;
	}

	public static Date getData() {
		return data;
	}

	public static void setData(Date data) {
		CUAfegirUsuaris.data = data;
	}

	public static Integer getHoraInici() {
		return horaInici;
	}

	public static void setHoraInici(Integer horaInici) {
		CUAfegirUsuaris.horaInici = horaInici;
	}

	public static void obteUsuarisAAssignar(ArrayList<String> usuaris) {

		Set<Usuari> usuReserv = new HashSet<Usuari>();		
		for (String u: usuaris){
			usuReserv.add(FactoriaDades.getCtrlUsuari().getByPK(u));
		}				
		Reserva r = FactoriaDades.getCtrlReserva().getByPK(CUUsuarisAAsig.getNomRecurs(), CUUsuarisAAsig.getData(),CUUsuarisAAsig.getHoraInici());		
		r.getUsuaris().addAll(usuReserv);		
		BasicRepo.saveOrUpdate(r);
		
		
	}
}
