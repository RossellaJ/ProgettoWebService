import java.util.Calendar;
import java.util.Date;




import it.alfasoft.rossella.dao.FatturaDao;
import it.alfasoft.rossella.model.Fattura;
import it.alfasoft.rossella.service.Servizi;


public class Main {

	public static void main(String[] args) {
		
		Servizi s = new Servizi();
		
//		Date d = new Date();
//		Fattura f1 = new Fattura(d,1500,"001");
//		s.creaFattura(f1);
		
//		Date d = new Date();
//		Fattura f2 = new Fattura(d,2100,"002");
//		s.creaFattura(f2);
		
		FatturaDao f = new FatturaDao();
		
		System.out.println("la lista è:"+f.readFattureConMeseEAnno(Calendar.getInstance()));
		
		

	}

}
