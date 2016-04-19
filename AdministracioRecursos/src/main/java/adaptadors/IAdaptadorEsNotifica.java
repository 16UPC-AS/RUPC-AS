package adaptadors;

import entities.Reserva;

public interface IAdaptadorEsNotifica {

	void enviarMissatge(Reserva r) throws Exception;
	
}
