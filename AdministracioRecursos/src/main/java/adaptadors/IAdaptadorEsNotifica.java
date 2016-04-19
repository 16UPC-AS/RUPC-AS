package adaptadors;

import entities.Reserva;

public interface IAdaptadorEsNotifica {

	void enviarMissatge(Reserva r) throws Exception;
	// Boolean pagament(String dniClient, String numTarg, float f, Date dataCad) throws Exception;
	
}
