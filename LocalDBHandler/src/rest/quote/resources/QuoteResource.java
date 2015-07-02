package rest.quote.resources;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.client.ClientConfig;

/**
 * @author Marija Grozdanic
 *
 */
@Stateless
@LocalBean
@Path("/randomquote")
public class QuoteResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	public String getPersonsBrowser(@Context UriInfo info) {
		System.out.println("XXXXXX");
		String result = "";
		String uriString;
		uriString = "http://iheartquotes.com/api/v1/random";

		WebTarget service;
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		service = client.target(UriBuilder.fromUri(uriString).build());
		Response response = service.request().accept(MediaType.TEXT_PLAIN)
				.get();
		result = (String) response.readEntity(String.class);
		System.out.println(result);

		return result;
	}

}
