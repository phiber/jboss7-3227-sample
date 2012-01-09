import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClientExecutor;
import org.junit.*;

import ch.dvbern.samples.rest.UserPrincipalRESTService;


import static org.junit.Assert.*;

/**
 * Integration-Test
 */
public class UserPrincipalRESTServiceIT {

	private UserPrincipalRESTService service;

	@Before
	public void before() {
		final HttpClient httpClient = new HttpClient();
		httpClient.getState().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("joe", "secret"));
		httpClient.getParams().setAuthenticationPreemptive(true);
		final ApacheHttpClientExecutor executor = new ApacheHttpClientExecutor(httpClient);
		service = ProxyFactory.create(UserPrincipalRESTService.class,  "http://localhost:8080/app/resources", executor);
	}

	@Test
	public void doTest() {
		int count = 0;
		while (true) {
			assertEquals("Hello joe!", service.helloUser());
			System.out.println(new Date() + " successfull calls: " + ++count + "\r");
		}
	}

}
