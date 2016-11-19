import java.util.Date;


import it.alfasoft.rossella.model.Fattura;
import it.alfasoft.rossella.service.Servizi;


public class Main {

	public static void main(String[] args) {
		
		Servizi s = new Servizi();
		
		Date d = new Date();
		Fattura f1 = new Fattura(d,1500,"001");
		s.creaFattura(f1);

	}

}
