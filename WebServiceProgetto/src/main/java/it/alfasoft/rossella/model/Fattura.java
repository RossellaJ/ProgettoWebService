package it.alfasoft.rossella.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

@Entity
public class Fattura {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Data data;
	private double importo;
	private String codiceAziendale;
	
	
	
	public Fattura() {
		
	}



	public Fattura(Data data, double importo, String codiceAziendale) {
		this.data = data;
		this.importo = importo;
		this.codiceAziendale = codiceAziendale;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Data getData() {
		return data;
	}



	public void setData(Data data) {
		this.data = data;
	}



	public double getImporto() {
		return importo;
	}



	public void setImporto(double importo) {
		this.importo = importo;
	}



	public String getCodiceAziendale() {
		return codiceAziendale;
	}



	public void setCodiceAziendale(String codiceAziendale) {
		this.codiceAziendale = codiceAziendale;
	}
	
	
	

}
