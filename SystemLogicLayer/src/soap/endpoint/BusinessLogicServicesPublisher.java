package soap.endpoint;

import javax.xml.ws.Endpoint;

import soap.businesslogicservices.BusinessLogicServicesImplementation;

/**
 * @author Marija Grozdanic
 *
 */
public class BusinessLogicServicesPublisher {
	public static String SERVER_URL = "http://localhost";
	public static String PORT = "450";
	public static String BASE_URL = "/ws/businesslogicservice";

	public static String getEndpointURL() {
		return SERVER_URL + ":" + PORT + BASE_URL;
	}

	public static void main(String[] args) {
		String endpointUrl = getEndpointURL();
		System.out.println("Business Logic Service...");
		System.out.println("--> Published at = " + endpointUrl);
		Endpoint.publish(endpointUrl, new BusinessLogicServicesImplementation());
	}
}
