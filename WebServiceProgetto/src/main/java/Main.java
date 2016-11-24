
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dateUtil.MetodiDate;
import it.alfasoft.rossella.dao.BustaPagaDao;
import it.alfasoft.rossella.dao.FatturaDao;
import it.alfasoft.rossella.model.BustaPaga;
import it.alfasoft.rossella.model.Fattura;
import it.alfasoft.rossella.service.Servizi;


public class Main {

	public static void main(String[] args) {
		
		Servizi s = new Servizi();
		FatturaDao fDao = new FatturaDao();
		
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
//		Fattura f3 = new Fattura(d3,2700,"003");
//		s.creaFattura(f3);
//		
//		Date d4 = new Date();
//		Fattura f4 = new Fattura(d4,850,"004");
//		s.creaFattura(f4);
//		
		
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
//		Fattura f = new Fattura(d,1852,"74");
//		s.creaPdfDaRequest(f, "formato.jasper");
		//s.creaPdfDaLetturaDBconCodice("93");
		
//--------------------	   DA STRING A DATE     ------------------------------
//		MetodiDate mD = new MetodiDate();
//		Date d1=mD.ConvertiStringADate("01-03-2016 10:20:56");
//		Date d2 = mD.ConvertiStringADate("25-09-2016 10:20:56");
//		
//	List<Fattura> lista =	fDao.readFattureConData(d1, d2);
//	for(Fattura f1 : lista){
//		System.out.println(f1.getCodiceFattura()+" "+f1.getImporto()+" "+f1.getData());
//	}
		
//	---------------------ELIMINA TUTTE LE FATTURE-------------------------------	
//		List <Fattura> lista = fDao.readTutteFatture();
//		for ( Fattura f : lista){
//			s.eliminaFattura(f);
//		}
//		-------------------   BUSTA PAGA  ---------------------------------
		BustaPaga b1 = new BustaPaga("Gennaro","25/08/2016",2500);
		BustaPaga b2 = new BustaPaga("Francesca","03/11/2016",900);
		BustaPaga b3 = new BustaPaga("Cosima","14/10/2016",1400);
		
		BustaPagaDao bDao = new BustaPagaDao();
		
		bDao.createBusta(b1);
		bDao.createBusta(b2);
		bDao.createBusta(b3);
		
		}

}
