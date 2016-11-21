package it.alfasoft.rossella.service;

import java.util.ArrayList;
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
	
	public Fattura getFatturaConCodice(String codiceFattura){
		Fattura fattura = fDao.readFatturaConCodice(codiceFattura);
		return fattura;
	}
	
	//leggi tutte le fatture
	
	public List<Fattura> getTutteFatture(){
		List<Fattura> listaFatture = fDao.readTutteFatture();
		return listaFatture;
	}
	
	//leggi le fatture con mese e anno
	public List<Fattura> getFattureConMeseEAnno(String mese, String anno){
		System.out.println();
		List<Fattura> tuttoDB = this.getTutteFatture();
		List<Fattura> listaConMeseAnno = new ArrayList<Fattura>();
		
		for( Fattura fatTemp : tuttoDB){
			
			//converto data in calendar
			Calendar cal = Calendar.getInstance();
			Date data1= fatTemp.getData();
			cal.setTime(data1);
			
			//converto string che passa da request in int
			int meseInt = Integer.parseInt(mese);
			int annoInt = Integer.parseInt(anno);
			
			//estraggo mese e anno da calendar(proprio per questo l'ho convertiti-->Date ha metodi deprecati)
			int m = Calendar.getInstance().get(Calendar.MONTH);
			int a = Calendar.getInstance().get(Calendar.YEAR);
			
			//condizione su interi
			if( m == meseInt && a == annoInt){
				listaConMeseAnno.add(fatTemp);
			}
			
		}
		return listaConMeseAnno;
		
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
