package ch.dvbern.samples.rest;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Stateless
@Local
public class UserPrincipalRESTServiceImpl implements UserPrincipalRESTService {

	@Context
	private SecurityContext securityContext;

    public String helloUser() {
		final String userName = securityContext.getUserPrincipal().getName();
		return "Hello " + userName+"!";
	}
}
