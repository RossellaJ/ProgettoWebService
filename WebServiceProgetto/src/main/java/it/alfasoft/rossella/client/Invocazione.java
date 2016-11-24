package it.alfasoft.rossella.client;

import java.util.List;

import it.alfasoft.rossella.model.BustaPaga;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public abstract class Invocazione {
	
	protected Client cliente = ClientBuilder.newClient();
	protected  WebTarget basedTarget = cliente.target("http://localhost:8086/AziendaJSF/alfasoft");
	protected WebTarget targetBustePaga = basedTarget.path("/bustePaga");

	
	
	abstract Invocation getTutteBustePaga();
	//abstract List<BustaPaga> getAllBuste();
	
}
