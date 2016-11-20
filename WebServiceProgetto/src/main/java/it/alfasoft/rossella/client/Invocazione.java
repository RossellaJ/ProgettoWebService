package it.alfasoft.rossella.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public abstract class Invocazione {
	
	protected Client cliente = ClientBuilder.newClient();
	protected  WebTarget basedTarget = cliente.target("http://localhost:8085/***/alfasoft");
	protected WebTarget targetBustePaga = basedTarget.path("/***");

	
	
	abstract Invocation getTutteBustePaga();
	
	
}
