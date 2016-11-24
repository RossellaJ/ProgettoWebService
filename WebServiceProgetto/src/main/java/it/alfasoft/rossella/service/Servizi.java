package it.alfasoft.rossella.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dateUtil.MetodiDate;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import it.alfasoft.rossella.client.InvocazioneBustePaga;
import it.alfasoft.rossella.dao.BustaPagaDao;
import it.alfasoft.rossella.dao.FatturaDao;
import it.alfasoft.rossella.model.BustaPaga;
import it.alfasoft.rossella.model.Fattura;

public class Servizi {
	
	FatturaDao fDao = new FatturaDao();
	MetodiDate mD = new MetodiDate();
	BustaPagaDao bDao = new BustaPagaDao();
	//crea fattura in db
	
	public boolean creaFattura(Fattura f){
		return fDao.createFattura(f);	
	}

	//leggi la fattura
	
	public Fattura getFatturaConCodice(String codiceFattura){
		Fattura fattura = fDao.readFatturaConCodice(codiceFattura);
		return fattura;
	}
	
	//leggi la fattura con id
	public Fattura getFatturaConId(long id) {
		return fDao.readFatturaConId(id);	
	}
	

	//leggi tutte le fatture
	
	public List<Fattura> getTutteFatture(){
		List<Fattura> listaFatture = fDao.readTutteFatture();
		return listaFatture;
	}
	

	//leggi fatture in un INTERVALLO DI DATE
	//Metodo per convertire le String della request in http in Date con cui richiamare il Dao
	
	public List<Fattura> getFattereConDate(String dataInizio, String dataFine){
		
		//converto String in Date
		Date dataInizio1 = mD.ConvertiStringADate(dataInizio);
		Date dataFine1 = mD.ConvertiStringADate(dataFine);
		
		//eseguo la query nel DB		
		List<Fattura> lista = fDao.readFattureConData(dataInizio1, dataFine1);
		
		for(Fattura f : lista){
			System.out.println(f.getCodiceFattura()+" "+f.getImporto()+" "+f.getData());
		}
			
		return lista;

	}
	
	
	//modifica la fattura
	public boolean modificaFattura(Fattura f){
		
		Fattura f1 = this.getFatturaConId(f.getId());
		
		Date dat = f.getData();
		double impor = f.getImporto();
		String codFat = f.getCodiceFattura();
		
		f1.setData(dat);
		f1.setImporto(impor);
		f1.setCodiceFattura(codFat);
		
		boolean b = fDao.updateFattura(f1);
		
		System.out.println(f1.getData()+" "+f1.getImporto()+" "+f1.getCodiceFattura());
		return b;
		
	}
	
	//elimina la fattura dal database
	
	public String eliminaFattura(Fattura f){
		this.getFatturaConId(f.getId());
		fDao.deleteFattura(f);
		return "La fattura è stata eliminata!";
		
	}
	
	
	//-------JASPER REPORT--->               CREARE PDF da Fattura            <---------------------
	
	
	
	public void creaPdfDaRequest(Fattura f,String pathJasper, String pathJasperImm) {
		
		
		String codiceFattura1 = f.getCodiceFattura();
		Date data1 = f.getData();
		double importo1 = f.getImporto();
		
		String nomeFile = "FatturaAzienda " + codiceFattura1 + ".pdf";
		
		String percorso = "C:\\Users\\corso\\Desktop\\Jasper\\";

		String fileFinale = percorso + nomeFile;

		try {

			// una mappa per mandare i parametri a Jasper
			Map<String, Object> parameters = new HashMap<String, Object>();

			
			parameters.put("importo",importo1 );
		    parameters.put("data",data1 );
		    parameters.put("codiceFattura",codiceFattura1);
		    parameters.put("logo", pathJasperImm);
		    
			// file compilato di jasper (.jasper) di Jasper Report per creare
			// PDF
			JasperPrint jasperPrint = JasperFillManager.fillReport(pathJasper,
					 parameters, new JREmptyDataSource());

			// outputStream per creare PDF
			OutputStream outputStream = new FileOutputStream(new File(
					fileFinale));

			// scrivo in un file PDF
			JasperExportManager.exportReportToPdfStream(jasperPrint,
					outputStream);
			System.out.println("il File.pdf e' stato creato");

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//-------------------------------Buste paga Tabelle ------------------------------------
	
	public void creaPdfTabella(List<BustaPaga> buste,String pathJasper, String pathJasperImm){
		
	String nomeFile="TabellaBustePaga.pdf";
	//metti concatenazione nel nome con parametro per non sovrascrivere
	String percorso  = "C:\\Users\\corso\\Desktop\\Jasper\\";
	 
	String fileFinale=percorso+nomeFile;
	
	
	try {
		
	//la mia lista che mantiene i dati
    //List<BustaPaga> buste =bDao.readTutteBustePaga() ;

  // Converto la  lista to JRBeanCollectionDataSource 
  JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(buste,false);
	
		
  //  una mappa per mandare i parametri a Jasper 
  Map<String, Object> parameters = new HashMap<String, Object>();

  parameters.put("BustaDataSource", itemsJRBean);
  parameters.put("logo", pathJasperImm);

 
  //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
  JasperPrint jasperPrint = JasperFillManager.fillReport(pathJasper, parameters, new JREmptyDataSource());

  //outputStream per creare PDF 
  OutputStream outputStream = new FileOutputStream(new File(fileFinale));
 
  
  // scrivo in un  file PDF  
	JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	System.out.println("il File.pdf e' stato creato");
	
	
	
} catch (JRException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	}

	public boolean creaBustaPaga(BustaPaga bp) {
		
		return bDao.createBusta(bp) ;
	}
//	String pathJasper=request.getServletContext().getRealPath("/jasper/Tab.jasper");	
//	System.out.println(pathJasper);
//	String pathJasperImm=request.getServletContext().getRealPath("/jasper/logo.jpg");	
//	System.out.println(pathJasperImm);
//	
//	boolean b = s.creaBustaPaga(bp);
//	
//	if(b==true){
//	s.creaPdfTabella(bp, pathJasper, pathJasperImm);
//	}
//	//for(Bust)
//	System.out.println(bp.getNome());
//	return Response.status(Status.CREATED)
//			.entity(f)
//			.build();
//}
	public void leggiTutteBuste(List<BustaPaga> buste,String pathJasper, String pathJasperImm){
		
	this.creaPdfTabella(buste, pathJasper, pathJasperImm);
		
	}

	public void invocaBustePaga(String pathJasper, String pathJasperImm) {
		InvocazioneBustePaga invocazione = new InvocazioneBustePaga();
		
		Response response= invocazione.getTutteBustePaga()
				.invoke();
	
	                     
		List<BustaPaga> listaBuste = response
						.readEntity(new GenericType<List<BustaPaga>>(){});
		
		this.creaPdfTabella(listaBuste, pathJasper, pathJasperImm);
		
		
	}
}
