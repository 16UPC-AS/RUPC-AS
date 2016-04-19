package adaptadors;

import entities.Reserva;
import services.ServiceLocator;
import services.SvMissatgeria;

public class AdaptadorEsNotifica implements IAdaptadorEsNotifica {

	public void enviarMissatge(Reserva r) throws Exception {
		r.getInfoPerServei();
		((SvMissatgeria) ServiceLocator.getInstance().find("SvMissatgeria")).enviarDadesReserva();
	}
}
