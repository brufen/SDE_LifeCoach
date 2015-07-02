package soap.businesslogicservices;

import java.net.MalformedURLException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 * @author Marija Grozdanic
 *
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
// optional
public interface BusinessLogicServices {

	@WebMethod(operationName = "register")
	@WebResult(name = "register")
	public int registerUser(@WebParam(name = "userdata") String userdata)
			throws MalformedURLException;

	@WebMethod(operationName = "login")
	@WebResult(name = "login")
	public int loginUser(@WebParam(name = "userdata") String userdata)
			throws MalformedURLException;

	@WebMethod(operationName = "getMeasures")
	@WebResult(name = "getMeasures")
	public String getMeasures(@WebParam(name = "id") int userdata)
			throws MalformedURLException;

	@WebMethod(operationName = "getGoals")
	@WebResult(name = "goals")
	public String getGoals(@WebParam(name = "id") int userdata)
			throws MalformedURLException;

	@WebMethod(operationName = "registerMeasurment")
	@WebResult(name = "registerMeasurment")
	public String registerMeasurment(@WebParam(name = "id") int userdata,
			String measurmentData) throws MalformedURLException;

	@WebMethod(operationName = "registerGoal")
	@WebResult(name = "registerGoal")
	public String registerGoal(@WebParam(name = "id") int userdata,
			String goalData) throws MalformedURLException;

	@WebMethod(operationName = "getProgressInfo")
	@WebResult(name = "getProgressInfo")
	public String getProgressInfo(@WebParam(name = "id") int userdata)
			throws MalformedURLException;

	@WebMethod(operationName = "addNewMeasurmentType")
	@WebResult(name = "addNewMeasurmentType")
	public int addNewMeasurmentType(
			@WebParam(name = "measurmentDescription") String measurmentDescription);

	@WebMethod(operationName = "getMeasurmentTypes")
	@WebResult(name = "getMeasurmentTypes")
	public String getMeasurmentTypes();
}
