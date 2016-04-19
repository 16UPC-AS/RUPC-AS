package testHibernate;

import entities.Ordinador;
import entities.Sala;
import repositories.CtrlOrdinador;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CtrlOrdinador ctrl = new CtrlOrdinador();
		Ordinador ord = new Ordinador("pc1",null , "marca1", "model1");
		CtrlOrdinador.saveOrUpdate(ord);
		Sala sal = new Sala("sala2", "bcn", 710);
		CtrlOrdinador.saveOrUpdate(sal);
	}

}
