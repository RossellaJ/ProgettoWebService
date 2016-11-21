package it.alfasoft.rossella.bean;

import javax.ws.rs.QueryParam;

public class FiltroFattura {
	
	private @QueryParam("dataInizio")String dataInizio;
	private @QueryParam("dataFine") String dataFine;
//	private @QueryParam("offset") int offset; 
//	private @QueryParam("limit") int limit;
	
	
	
	
	
	
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public String getDataFine() {
		return dataFine;
	}
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	
	
	
	
	
	
	
	
//	public int getOffset() {
//		return offset;
//	}
//	public void setOffset(int offset) {
//		this.offset = offset;
//	}
//	public int getLimit() {
//		return limit;
//	}
//	public void setLimit(int limit) {
//		this.limit = limit;
//	}
	
	

}
