package rest.quote;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Marija Grozdanic
 *
 */
@ApplicationPath("QuoteAdapter")
public class MyApplicationConfig extends ResourceConfig {
	public MyApplicationConfig() {
		packages("rest.quote");
	}
}