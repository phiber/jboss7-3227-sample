package ch.dvbern.samples.rest;

import java.security.Principal;
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
		Principal userPrincipal = securityContext.getUserPrincipal();
		if (userPrincipal == null) {
			throw new IllegalArgumentException("userPrincipal is null");
		}
		return "Hello " + userPrincipal.getName()+"!";
	}
}
