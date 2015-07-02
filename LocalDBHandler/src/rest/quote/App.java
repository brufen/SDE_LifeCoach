package rest.quote;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;



/**
 * @author Marija Grozdanic
 *
 */
public class App {

	
	private static final URI BASE_URI = URI.create("http://localhost:448/QuoteAdapter");

	//private static final URI BASE_URI = URI.create("http://localhost:446/QuoteAdapter");	
	 public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
	    {
	    	System.out.println("Starting QuoteAdapter standalone HTTP server...");
	        JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
	        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");
	    }

	    public static ResourceConfig createApp() {
	    	System.out.println("Starting QuoteAdapter REST services...");
	        return new MyApplicationConfig();
	    }
}
