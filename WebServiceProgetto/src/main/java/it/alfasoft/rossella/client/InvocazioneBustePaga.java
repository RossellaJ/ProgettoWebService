package it.alfasoft.rossella.client;

import java.util.List;

import it.alfasoft.rossella.model.BustaPaga;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;

public class InvocazioneBustePaga extends Invocazione{

	@Override
	public	Invocation getTutteBustePaga() {
		
		return targetBustePaga.request().buildGet();
	}





}
