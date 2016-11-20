package it.alfasoft.rossella.client;

import javax.ws.rs.client.Invocation;

public class InvocazioneBustePaga extends Invocazione{

	@Override
	Invocation getTutteBustePaga() {
		
		return targetBustePaga.request().buildGet();
	}

}
