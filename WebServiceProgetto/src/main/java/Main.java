
import java.util.Date;
import java.util.List;

import it.alfasoft.rossella.model.Fattura;
import it.alfasoft.rossella.service.Servizi;


public class Main {

	public static void main(String[] args) {
		
		Servizi s = new Servizi();
		
		//s.getFattureConMeseEAnno("10", "2016");
//		Date d = new Date();
//		Fattura f1 = new Fattura(d,1500,"001");
//		s.creaFattura(f1);
//		
//		Date d2 = new Date();
//		Fattura f2 = new Fattura(d2,2100,"002");
//		s.creaFattura(f2);
//		
//		Date d3 = new Date();
//		Fattura f3 = new Fattura(d3,2100,"002");
//		s.creaFattura(f3);
		
		
//		FatturaDao f = new FatturaDao();
//		
		
		//System.out.println("la lista è:"+s.getFattureConMeseEAnno("10", "2016"));
		
//		List<Fattura> tuttoDB = s.getTutteFatture();
//		List<Fattura> listaConAnno = null;
//		
//		for( Fattura fatTemp : tuttoDB){
//			
//			Calendar cal = Calendar.getInstance();
//			
//			cal.setTime(fatTemp.getData());
//			System.out.println(cal.getInstance().get(Calendar.MONTH));		
//		}
		
//		List<Fattura> lista = s.getFattureConMeseEAnno("10", "2016");
//		for(Fattura f:lista){
//			System.out.println(f.getCodiceFattura()+" "+f.getData()+" "+f.getImporto());
//		}
//		Date d = new Date();
//		Fattura f = new Fattura(d,1423,"065");
		s.creaPdfDaLetturaDBconCodice();
		}

}
