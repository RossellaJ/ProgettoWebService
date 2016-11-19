package it.alfasoft.rossella.resorces;



import java.util.ArrayList;
import java.util.List;


import it.alfasoft.rossella.model.Fattura;
import it.alfasoft.rossella.service.Servizi;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("fatture")
public class RisorsaFattura {
	
	Servizi s = new Servizi();
	
	
	@Path("/{codiceAziendale}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Fattura prendiFatturaConCodice(@PathParam("codiceAziendale") String codiceAziendale ){
		
		return s.getFatturaConCodice(codiceAziendale);
		
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
		System.out.println(f.getId()+" "+f.getImporto()+" "+f.getCodiceAziendale());
	}
	
	
	
}
