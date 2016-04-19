package casosDus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.jandex.Main;

import dades.FactoriaDades;
import entities.Recurs;

public class CUConsultaRecurs {

	private static Date data;
	private static Integer horaInici;
	private static Integer horaFi;

	public static Date getData() {
		return data;
	}

	public static void setData(Date data) {
		CUConsultaRecurs.data = data;
	}

	public static Integer getHoraInici() {
		return horaInici;
	}

	public static void setHoraInici(Integer horaInici) {
		CUConsultaRecurs.horaInici = horaInici;
	}

	public static Integer getHoraFi() {
		return horaFi;
	}

	public static void setHoraFi(Integer horaFi) {
		CUConsultaRecurs.horaFi = horaFi;
	}

	public static ArrayList<ArrayList<String>> consultaRecurs(Date d, Integer hi, Integer hf) {
		List<Recurs> recs = FactoriaDades.getCtrlRecurs().getAll();

		ArrayList<ArrayList<String>> recDisps = new ArrayList<ArrayList<String>>();
		for (Recurs r : recs) {
			ArrayList<String> recInfo = r.estasDisp(d, hi, hf);
			if (recInfo != null)
				recDisps.add(recInfo);
		}
		if (recDisps.isEmpty())
			;// activa EXC;

		System.out.println(recDisps.toString());

		setData(d);
		setHoraInici(hi);
		setHoraFi(hf);

		return recDisps;
	}

}
