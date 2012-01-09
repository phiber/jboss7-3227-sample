package ch.dvbern.samples.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public interface UserPrincipalRESTService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	String helloUser();
}
