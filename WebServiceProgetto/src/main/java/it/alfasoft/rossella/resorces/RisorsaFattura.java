package it.alfasoft.rossella.resorces;



import java.util.ArrayList;
import java.util.List;













import it.alfasoft.rossella.bean.FiltroFattura;
import it.alfasoft.rossella.model.Fattura;
import it.alfasoft.rossella.service.Servizi;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("fatture")
public class RisorsaFattura {
	
	Servizi s = new Servizi();
	
	
	@Path("/{codiceFattura}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Fattura prendiFatturaConCodice(@PathParam("codiceFattura") String codiceFattura ){
		
		return s.getFatturaConCodice(codiceFattura);
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Fattura> prendiTutteFatture(){
		
		return new ArrayList<Fattura>(s.getTutteFatture());
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aggiungiFattura(Fattura f, @Context HttpServletRequest request){
		
		String pathJasper=request.getServletContext().getRealPath("/jasper/formato.jasper");	
		System.out.println(pathJasper);
		String pathJasperImm=request.getServletContext().getRealPath("/jasper/logo.jpg");	
		System.out.println(pathJasperImm);
		
		boolean b = s.creaFattura(f);
		
		if(b==true){
		s.creaPdfDaRequest(f,pathJasper,pathJasperImm);
		}
		
		System.out.println(f.getId()+" "+f.getImporto()+" "+f.getCodiceFattura());
		return Response.status(Status.CREATED)
				.entity(f)
				.build();
	}
	
	
//	@PUT
//	//@Consumes(MediaType.APPLICATION_JSON)
//	public void modificaFattura(Fattura f,@Context HttpServletRequest request){
//		
//		String pathJasper=request.getServletContext().getRealPath("/jasper/formato.jasper");	
//		System.out.println(pathJasper);
//		
//		boolean b = s.modificaFattura(f);
//		if(b==true){
//			s.creaPdfDaRequest(f, pathJasper);
//		}
//		System.out.println(f.getId()+" "+f.getImporto()+" "+f.getCodiceFattura());
//	}
	
	@DELETE
	public void eliminaFattura(Fattura f){
		s.eliminaFattura(f);
	}
	
	@Path("/fattura")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fattura> prendiFattureConMeseEAnno(@BeanParam FiltroFattura f){
		
		String dataInizio = f.getDataInizio();
		String dataFine = f.getDataFine();
			
		System.out.println("Fatture a partire da: "+ f.getDataInizio()+"fino a: "+f.getDataFine());
		return new ArrayList<Fattura>(s.getFattereConDate(dataInizio, dataFine));
		
		
	}
	
	
	
}
