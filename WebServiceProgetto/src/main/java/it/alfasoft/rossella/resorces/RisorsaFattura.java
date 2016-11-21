package it.alfasoft.rossella.resorces;



import java.util.ArrayList;
import java.util.List;




import it.alfasoft.rossella.bean.FiltroFattura;
import it.alfasoft.rossella.model.Fattura;
import it.alfasoft.rossella.service.Servizi;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("fatture")
public class RisorsaFattura {
	
	Servizi s = new Servizi();
	
	
	@Path("/{codiceFattura}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Fattura prendiFatturaConCodice(@PathParam("codiceFattura") String codiceFattura ){
		s.creaPdfDaLetturaDBconCodice();
		return s.getFatturaConCodice(codiceFattura);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fattura> prendiTutteFatture(){
		
		return new ArrayList<Fattura>(s.getTutteFatture());
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void aggiungiFattura(Fattura f){
		
		s.creaFattura(f);
		s.creaPdfDaPostFattura(f);
		
		System.out.println(f.getId()+" "+f.getImporto()+" "+f.getCodiceFattura());
	}
	
	@Path("/fattura")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fattura> prendiFattureConMeseEAnno(@BeanParam FiltroFattura f){
		
		System.out.println("Fatture corrispondenti al mese: "+ f.getMese()+"e all' anno: "+f.getAnno());
		return new ArrayList<Fattura>();
		
		
	}
	
	
	
}
