package soap.processcentricservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import soap.DataService;
import soap.businesslogicservices.BusinessLogicServices;

/**
 * @author Marija Grozdanic
 *
 */
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService(endpointInterface = "soap.processcentricservices.ProcessCentricServices", serviceName = "ProcessCentricServices")
public class ProcessCentricServicesImplementation implements
		ProcessCentricServices {

	BusinessLogicServices businessLogicService;

	private void initConnection() throws MalformedURLException {
		URL url = new URL("http://localhost:450/ws/businesslogicservice?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://businesslogicservices.soap/",
				"BusinessLogicService");
		Service service = Service.create(url, qname);

		businessLogicService = service.getPort(BusinessLogicServices.class);

	}

	@Override
	public int registerUser(String userdata) {
		// TODO Auto-generated method stub
		try {
			initConnection();
			return businessLogicService.registerUser(userdata);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int loginUser(String userdata) {

		try {
			initConnection();
			return businessLogicService.loginUser(userdata);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String getMeasures(int userdata) {
		// TODO Auto-generated method stub
		try {
			initConnection();
			return businessLogicService.getMeasures(userdata);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getGoals(int userdata) {
		// TODO Auto-generated method stub
		try {
			initConnection();
			return businessLogicService.getGoals(userdata);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String registerMeasurment(int userdata, String measurmentData) {
		// TODO Auto-generated method stub
		try {
			initConnection();
			return businessLogicService.registerMeasurment(userdata,
					measurmentData);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String registerGoal(int userdata, String goalData) {
		// TODO Auto-generated method stub
		try {
			initConnection();
			return businessLogicService.registerGoal(userdata, goalData);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getQuote() {
		URL url;
		try {
			url = new URL("http://localhost:444/ws/dataservice?wsdl");
			// 2nd argument is service name, refer to wsdl document above
			QName qname = new QName("http://soap/", "DataService");
			Service service = Service.create(url, qname);

			DataService ds = service.getPort(DataService.class);
			return ds.getRandomQuote();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1st argument service URI, refer to wsdl document above

		return null;
	}

	@Override
	public String getProgressInfo(int userdata) {
		// TODO Auto-generated method stub
		try {
			initConnection();
			return businessLogicService.getProgressInfo(userdata);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int addNewMeasurmentType(
			@WebParam(name = "measurmentDescription") String measurmentDescription) {
		try {
			initConnection();
			return businessLogicService
					.addNewMeasurmentType(measurmentDescription);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public String getMeasurmentTypes() {
		try {
			initConnection();
			return businessLogicService.getMeasurmentTypes();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
