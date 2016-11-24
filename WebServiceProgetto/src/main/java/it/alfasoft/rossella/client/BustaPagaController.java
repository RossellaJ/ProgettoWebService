package it.alfasoft.rossella.client;

import it.alfasoft.rossella.model.BustaPaga;
import it.alfasoft.rossella.service.Servizi;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;



@ManagedBean(name="bustaPagaController",eager=true)
@SessionScoped
public class BustaPagaController {
	
	private InvocazioneBustePaga invocazione;
	Servizi s = new Servizi();

	public BustaPagaController() {
		
		invocazione = new InvocazioneBustePaga();
	}
	
	public void ottieniTutteBustePaga(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		String pathJasper=request.getServletContext().getRealPath("/jasper/Tab.jasper");	
		System.out.println(pathJasper);
		String pathJasperImm=request.getServletContext().getRealPath("/jasper/logo.jpg");	
		System.out.println(pathJasperImm);
		
		s.invocaBustePaga(pathJasper,pathJasperImm);
	
		
	}

		
	

}
