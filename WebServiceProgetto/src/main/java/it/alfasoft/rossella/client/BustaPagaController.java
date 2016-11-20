package it.alfasoft.rossella.client;

import it.alfasoft.rossella.model.BustaPaga;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;



@ManagedBean(name="bustaPagaController",eager=true)
@SessionScoped
public class BustaPagaController {
	
	private InvocazioneBustePaga invocazione;

	public BustaPagaController() {
		
		invocazione = new InvocazioneBustePaga();
	}
	
	public List<BustaPaga> ottieniTutteBustePaga(){
		
		Response response= invocazione
							.getTutteBustePaga()
							.invoke();
				
				                     
		List<BustaPaga> listaBuste = response
									.readEntity(new GenericType<List<BustaPaga>>(){});
				
		return listaBuste;
	}
	

}
