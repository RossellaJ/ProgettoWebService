package it.alfasoft.rossella.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import it.alfasoft.rossella.dao.FatturaDao;
import it.alfasoft.rossella.model.Fattura;

public class Servizi {
	
	FatturaDao fDao = new FatturaDao();
	
	//crea fattura
	
	public boolean creaFattura(Fattura f){
		return fDao.createFattura(f);	
	}

	//leggi la fattura
	
	public Fattura getFatturaConCodice(String CodiceAziendale){
		Fattura fattura = fDao.readFatturaConCodice(CodiceAziendale);
		return fattura;
	}
	
	//leggi tutte le fatture
	
	public List<Fattura> getTutteFatture(){
		List<Fattura> listaFatture = fDao.readTutteFatture();
		return listaFatture;
	}
	
	//leggi le fatture con mese e anno
	public List<Fattura> getFattureConMeseEAnno(int mese, int anno){
		
		// se passavo Calendar dataC al metodo
//		int mese = dataC.get(Calendar.MONTH);
//		int anno = dataC.get(Calendar.YEAR);
		
		
		
		
		
		
		
		
		
		
		
		return null;
		
	}
	
	
	
	//aggiorna
	
//	public boolean aggiornaFattura(Fattura f){
//		boolean res= false;
//		
//		
//		
//		return res;
//		
//		
//	}
	
	//elimina
	
	
	
	
	
}
