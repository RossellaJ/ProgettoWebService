package it.alfasoft.rossella.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Fattura {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date data;
	private double importo;
	private String codiceAziendale;
	
	
	
	public Fattura() {
		
	}



	public Fattura(Date data, double importo, String codiceAziendale) {
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



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
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
