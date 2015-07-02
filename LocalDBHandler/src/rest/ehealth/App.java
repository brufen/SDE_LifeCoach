package rest.ehealth;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Marija Grozdanic
 *
 */
public class App
{
	// private static final URI BASE_URI = URI.create("http://localhost:443/localDB");	
    private static final URI BASE_URI = URI.create("http://localhost:446/localDB");	
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
    {
    	System.out.println("Starting sdelab standalone HTTP server...");
        JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");
    }

    public static ResourceConfig createApp() {
    	System.out.println("Starting sdelab REST services...");
        return new MyApplicationConfig();
    }
}