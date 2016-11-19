package it.alfasoft.rossella.service;

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
