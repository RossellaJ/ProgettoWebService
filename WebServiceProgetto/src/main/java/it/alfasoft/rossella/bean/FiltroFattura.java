package it.alfasoft.rossella.bean;

import javax.ws.rs.QueryParam;

public class FiltroFattura {
	
	private @QueryParam("mese")String mese;
	private @QueryParam("anno") int anno;
//	private @QueryParam("offset") int offset; 
//	private @QueryParam("limit") int limit;
	
	
	public String getMese() {
		return mese;
	}
	public void setMese(String mese) {
		this.mese = mese;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
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
