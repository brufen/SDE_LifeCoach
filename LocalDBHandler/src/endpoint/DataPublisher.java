package endpoint; 
import javax.xml.ws.Endpoint;

import soap.DataServiceImpl;

/**
 * @author Marija Grozdanic
 *
 */
public class DataPublisher {
	public static String SERVER_URL = "http://localhost";
	public static String PORT = "444";
	public static String BASE_URL = "/ws/dataservice";

	public static String getEndpointURL() {
		return SERVER_URL + ":" + PORT + BASE_URL;
	}

	public static void main(String[] args) {
		String endpointUrl = getEndpointURL();
		System.out.println("Starting Data Service...");
		System.out.println("--> Published at = " + endpointUrl);
		Endpoint.publish(endpointUrl, new DataServiceImpl());
	}
}