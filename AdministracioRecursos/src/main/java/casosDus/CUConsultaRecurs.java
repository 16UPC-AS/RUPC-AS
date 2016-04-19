package casosDus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.jandex.Main;

import dades.FactoriaDades;
import entities.Recurs;

public class CUConsultaRecurs {
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
		return recDisps;
	}
	
	
}
