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

import dateUtil.MetodiDate;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import it.alfasoft.rossella.dao.FatturaDao;
import it.alfasoft.rossella.model.Fattura;

public class Servizi {
	
	FatturaDao fDao = new FatturaDao();
	MetodiDate mD = new MetodiDate();
	
	//crea fattura in db
	
	public boolean creaFattura(Fattura f){
		return fDao.createFattura(f);	
	}

	//leggi la fattura
	
	public Fattura getFatturaConCodice(String codiceFattura){
		Fattura fattura = fDao.readFatturaConCodice(codiceFattura);
		return fattura;
	}
	
	//leggi tutte le fatture
	
	public List<Fattura> getTutteFatture(){
		List<Fattura> listaFatture = fDao.readTutteFatture();
		return listaFatture;
	}
	

	
	//Metodo per convertire le String della request in http in Date con cui richiamare il Dao
	public List<Fattura> getFattereConDate(String dataInizio, String dataFine){
		
		//converto String in Date
		Date dataInizio1 = mD.ConvertiStringADate(dataInizio);
		Date dataFine1 = mD.ConvertiStringADate(dataFine);
		
		//eseguo la query nel DB		
		return fDao.readFattureConData(dataInizio1, dataFine1);
		
	
	
	}
	
	
	
	//-------JASPER REPORT---> CREARE PDF da Fattura passata nel POST<---------------------
	
	public void creaPdfDaLetturaDBconCodice() {
		
		Fattura f = fDao.readFatturaConCodice("078");
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
		    parameters.put("codiceFattura", codiceFattura1);

			// file compilato di jasper (.jasper) di Jasper Report per creare
			// PDF
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					"formato.jasper", parameters, new JREmptyDataSource());

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
	
	public void creaPdfDaPostFattura(Fattura f) {
		
		
		String codiceFattura1 = f.getCodiceFattura();
		Date data1 = f.getData();
		double importo1 = f.getImporto();
		
		String nomeFile = "FatturaAzienda " + codiceFattura1 + ".pdf";
		//String nomeFile = "FatturaAzienda3.pdf";
		
		String percorso = "C:\\Users\\corso\\Desktop\\Jasper\\";

		String fileFinale = percorso + nomeFile;

		try {

			// una mappa per mandare i parametri a Jasper
			Map<String, Object> parameters = new HashMap<String, Object>();

			
			parameters.put("importo",importo1 );
		    parameters.put("data",data1 );
		    parameters.put("codiceFattura",codiceFattura1);

			// file compilato di jasper (.jasper) di Jasper Report per creare
			// PDF
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					"formato.jasper", parameters, new JREmptyDataSource());

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


}
