package soap.endpoint;

import javax.xml.ws.Endpoint;

import soap.processcentricservices.ProcessCentricServicesImplementation;

/**
 * @author Marija Grozdanic
 *
 */
public class ProcessCentricServicesPublisher {
	public static String SERVER_URL = "http://localhost";
	public static String PORT = "451";
	public static String BASE_URL = "/ws/processcentricservice";

	public static String getEndpointURL() {
		return SERVER_URL + ":" + PORT + BASE_URL;
	}

	public static void main(String[] args) {
		String endpointUrl = getEndpointURL();
		System.out.println("Process Centric Service...");
		System.out.println("--> Published at = " + endpointUrl);
		Endpoint.publish(endpointUrl,
				new ProcessCentricServicesImplementation());
	}
}
