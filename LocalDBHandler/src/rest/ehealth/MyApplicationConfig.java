package rest.ehealth;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Marija Grozdanic
 *
 */
@ApplicationPath("localDB")
public class MyApplicationConfig extends ResourceConfig {
	public MyApplicationConfig() {
		packages("rest.ehealth");
	}
}
