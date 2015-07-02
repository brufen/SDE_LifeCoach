package soap.processcentricservices;

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
public interface ProcessCentricServices {
	@WebMethod(operationName = "register")
	@WebResult(name = "register")
	public int registerUser(@WebParam(name = "userdata") String userdata);

	@WebMethod(operationName = "login")
	@WebResult(name = "login")
	public int loginUser(@WebParam(name = "userdata") String userdata);

	@WebMethod(operationName = "getMeasures")
	@WebResult(name = "getMeasures")
	public String getMeasures(@WebParam(name = "id") int userdata);

	@WebMethod(operationName = "getGoals")
	@WebResult(name = "goals")
	public String getGoals(@WebParam(name = "id") int userdata);

	@WebMethod(operationName = "registerMeasurment")
	@WebResult(name = "registerMeasurment")
	public String registerMeasurment(@WebParam(name = "id") int userdata,
			String measurmentData);

	@WebMethod(operationName = "registerGoal")
	@WebResult(name = "registerGoal")
	public String registerGoal(@WebParam(name = "id") int userdata,
			String goalData);

	@WebMethod(operationName = "getQuote")
	@WebResult(name = "getQuote")
	public String getQuote();

	@WebMethod(operationName = "getProgressInfo")
	@WebResult(name = "getProgressInfo")
	public String getProgressInfo(@WebParam(name = "id") int userdata);

	@WebMethod(operationName = "addNewMeasurmentType")
	@WebResult(name = "addNewMeasurmentType")
	public int addNewMeasurmentType(
			@WebParam(name = "measurmentDescription") String measurmentDescription);

	@WebMethod(operationName = "getMeasurmentTypes")
	@WebResult(name = "getMeasurmentTypes")
	public String getMeasurmentTypes();

}
