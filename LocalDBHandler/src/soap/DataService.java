package soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import rest.ehealth.model.Goal;
import rest.ehealth.model.Measure;
import rest.ehealth.model.MeasureType;
import rest.ehealth.model.Person;

/**
 * @author Marija Grozdanic
 *
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
// optional
public interface DataService {
	@WebMethod(operationName = "readPersonList")
	@WebResult(name = "people")
	public List<Person> readPersonList();

	@WebMethod(operationName = "readMeasureTypeList")
	@WebResult(name = "MeasureTypes")
	public List<MeasureType> readMeasureTypeList();

	@WebMethod(operationName = "readPerson")
	@WebResult(name = "person")
	public Person readPerson(@WebParam(name = "personId") int id);

	@WebMethod(operationName = "readPersonMeasures")
	@WebResult(name = "measures")
	public List<Measure> readPersonsMeasureList(
			@WebParam(name = "personId") int id);

	@WebMethod(operationName = "readPersonMeasuresByType")
	@WebResult(name = "measures")
	public List<Measure> readPersonsMeasuresByType(
			@WebParam(name = "personId") int id,
			@WebParam(name = "measureType") String measureType);

	@WebMethod(operationName = "readPersonGoals")
	@WebResult(name = "measures")
	public List<Goal> readPersonsGoalList(@WebParam(name = "personId") int id);

	@WebMethod(operationName = "readPersonGoalsByType")
	@WebResult(name = "measures")
	public List<Goal> readPersonsGoalsByType(
			@WebParam(name = "personId") int id,
			@WebParam(name = "measureType") String measureType);

	@WebMethod(operationName = "readPersonMeasuresByDate")
	@WebResult(name = "measuresByDate")
	public List<Measure> readPersonsMeasuresByDate(
			@WebParam(name = "personId") int id,
			@WebParam(name = "before") String before,
			@WebParam(name = "after") String after);

	@WebMethod(operationName = "readPersonMeasuresByTypeAndDate")
	@WebResult(name = "measuresByTypeAndDate")
	public List<Measure> readPersonsMeasuresByTypeAndDate(
			@WebParam(name = "personId") int id,
			@WebParam(name = "measureType") String measureType,
			@WebParam(name = "before") String before,
			@WebParam(name = "after") String after);

	@WebMethod(operationName = "readPersonGoalsByDate")
	@WebResult(name = "measuresByDate")
	public List<Goal> readPersonsGoalListByDate(
			@WebParam(name = "personId") int id,
			@WebParam(name = "before") String before,
			@WebParam(name = "after") String after);

	@WebMethod(operationName = "readPersonGoalsByTypeAndDate")
	@WebResult(name = "measuresByTypeAndDate")
	public List<Goal> readPersonsGoalsByTypeAndDate(
			@WebParam(name = "personId") int id,
			@WebParam(name = "measureType") String measureType,
			@WebParam(name = "before") String before,
			@WebParam(name = "after") String after);

	@WebMethod(operationName = "savePersonMeasurement")
	@WebResult(name = "savePersonMeasurment")
	public Measure savePersonMeasurement(@WebParam(name = "personId") int id,
			@WebParam(name = "measure") Measure newStatus);

	@WebMethod(operationName = "savePersonGoal")
	@WebResult(name = "savePersonMeasurment")
	public Goal savePersonGoal(@WebParam(name = "personId") int id,
			@WebParam(name = "goal") Goal newStatus);

	@WebMethod(operationName = "createPerson")
	@WebResult(name = "person")
	public Person createPerson(@WebParam(name = "person") Person person);

	@WebMethod(operationName = "createMeasureType")
	@WebResult(name = "createMeasureType")
	public MeasureType createMeasureType(
			@WebParam(name = "createMeasureType") MeasureType mt);

	@WebMethod(operationName = "getRandomQuote")
	@WebResult(name = "getRandomQuote")
	public String getRandomQuote();
}
