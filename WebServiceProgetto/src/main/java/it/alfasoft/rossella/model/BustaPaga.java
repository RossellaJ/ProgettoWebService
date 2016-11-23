package it.alfasoft.rossella.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;



@ManagedBean(name="bp", eager=true)
@SessionScoped
@XmlRootElement
public class BustaPaga implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long id_busta;
	
	//private Dipendente dipendente;
	private String nome;
	

	private String dataEmissione;
	private double importo;
	
	public BustaPaga(){
		
	}

//	public BustaPaga(long id_busta, Dipendente dipendente, String dataEmissione, double importo) {
//		
//		this.dipendente = dipendente;
//		this.dataEmissione = dataEmissione;
//		this.importo = importo;
//	}

	public long getId_busta() {
		return id_busta;
	}

	public void setId_busta(long id_busta) {
		this.id_busta = id_busta;
	}

//	public Dipendente getDipendente() {
//		return dipendente;
//	}
//
//	public void setDipendente(Dipendente dipendente) {
//		this.dipendente = dipendente;
//	}

	public String getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(String dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
//	public boolean isValid() {
//
//		boolean res=false;
//		if(dipendente!=null && 
//				!dataEmissione.isEmpty() && dataEmissione!=null &&
//				importo!=0) {
//			
//			res=true;
//		}
//		
//		return res;
//}


	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
