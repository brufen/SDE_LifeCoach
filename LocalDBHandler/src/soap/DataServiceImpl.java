package soap;

import java.net.URI;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import rest.ehealth.model.Goal;
import rest.ehealth.model.Measure;
import rest.ehealth.model.MeasureType;
import rest.ehealth.model.Person;
import soap.collectionmodel.Goals;
import soap.collectionmodel.MeasurmentTypes;
import soap.collectionmodel.Measurments;
import soap.collectionmodel.People;

//Service Implementation
/**
 * @author Marija Grozdanic
 *
 */
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService(endpointInterface = "soap.DataService", serviceName = "DataService")
public class DataServiceImpl implements DataService {
	WebTarget service;

	@Override
	public List<Person> readPersonList() {
		System.out.println("DataService - readPersonList");
		InitConnection();
		WebTarget service1 = service.path("/person");
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		List<Person> list = ((People) response.readEntity(People.class))
				.getPeople();
		System.out.println("");
		System.out.println("STATUS");
		System.out.println(response.getStatus());

		return list;
	}

	@Override
	public List<MeasureType> readMeasureTypeList() {
		System.out.println("DataService - readMeasureTypeList");
		InitConnection();
		WebTarget service1 = service.path("/measureType");
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		List<MeasureType> list = ((MeasurmentTypes) response
				.readEntity(MeasurmentTypes.class)).getMeasurmentTypes();
		System.out.println("");
		System.out.println("STATUS");
		System.out.println(response.getStatus());
		return list;
	}

	@Override
	public Person readPerson(int id) {
		System.out.println("DataService - readPerson pID = " + id);
		InitConnection();
		WebTarget service1 = service.path("/person/" + Integer.toString(id));
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		Person p = response.readEntity(Person.class);

		System.out.println("STATUS");
		System.out.println(response.getStatus());
		System.out.println("");
		return p;
		// JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
		// Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		//
		// We had written this file in marshalling example
		// People people = (People) jaxbUnmarshaller.unmarshal( );

	}

	@Override
	public List<Measure> readPersonsMeasureList(int id) {
		System.out.println("DataService - readPersonsMeasureList pID = " + id);
		InitConnection();
		WebTarget service1 = service.path("/person/" + Integer.toString(id)
				+ "/measurements/all");
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		List<Measure> list = ((Measurments) response
				.readEntity(Measurments.class)).getMeasurments();
		System.out.println("");
		System.out.println("STATUS");
		System.out.println(response.getStatus());
		return list;
	}

	@Override
	public List<Measure> readPersonsMeasuresByType(int id, String measureType) {
		System.out.println("DataService - readPersonsMeasuresByType pID = "
				+ id + " measureType = " + measureType);
		InitConnection();
		WebTarget service1 = service.path("/person/" + Integer.toString(id)
				+ "/measurements/" + measureType);
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		List<Measure> list = ((Measurments) response
				.readEntity(Measurments.class)).getMeasurments();

		System.out.println("STATUS");
		System.out.println(response.getStatus());
		System.out.println("");
		return list;
	}

	@Override
	public List<Goal> readPersonsGoalList(int id) {
		System.out.println("DataService - readPersonsGoalList pID = " + id);
		InitConnection();
		WebTarget service1 = service.path("/person/" + Integer.toString(id)
				+ "/goals/all");
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		System.out.println(response.toString());
		List<Goal> list = ((Goals) response.readEntity(Goals.class)).getGoals();

		System.out.println("STATUS");
		System.out.println(response.getStatus());
		System.out.println("");
		return list;
	}

	@Override
	public List<Goal> readPersonsGoalsByType(int id, String measureType) {
		System.out.println("DataService - readPersonsGoalsByType pID = " + id
				+ " measureType = " + measureType);
		InitConnection();
		WebTarget service1 = service.path("/person/" + Integer.toString(id)
				+ "/goals/" + measureType);
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();

		List<Goal> list = ((Goals) response.readEntity(Goals.class)).getGoals();
		System.out.println("");
		System.out.println("STATUS");
		System.out.println(response.getStatus());
		return list;
	}

	@Override
	public List<Measure> readPersonsMeasuresByDate(int id, String before,
			String after) {
		System.out.println("DataService - readPersonsMeasuresByDate pID = "
				+ id + " before = " + before + " after = " + after);
		InitConnection();
		WebTarget service1 = service
				.path("/person/" + Integer.toString(id) + "/measurements/all")
				.queryParam("before", before).queryParam("after", after);
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		List<Measure> list = ((Measurments) response
				.readEntity(Measurments.class)).getMeasurments();
		System.out.println("");
		System.out.println("STATUS");
		System.out.println(response.getStatus());
		return list;
	}

	@Override
	public List<Measure> readPersonsMeasuresByTypeAndDate(int id,
			String measureType, String before, String after) {
		System.out
				.println("DataService - readPersonsMeasuresByTypeAndDate pID = "
						+ id
						+ " measureType = "
						+ measureType
						+ " before = "
						+ before + " after = " + after);
		InitConnection();
		WebTarget service1 = service
				.path("/person/" + Integer.toString(id) + "/measurements/"
						+ measureType).queryParam("before", before)
				.queryParam("after", after);
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		List<Measure> list = ((Measurments) response
				.readEntity(Measurments.class)).getMeasurments();
		System.out.println("");
		System.out.println("STATUS");
		System.out.println(response.getStatus());
		return list;
	}

	@Override
	public List<Goal> readPersonsGoalListByDate(int id, String before,
			String after) {
		System.out.println("DataService - readPersonsGoalListByDate pID = "
				+ id + " before = " + before + " after = " + after);
		InitConnection();
		WebTarget service1 = service
				.path("/person/" + Integer.toString(id) + "/goals/all")
				.queryParam("before", before).queryParam("after", after);
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		List<Goal> list = ((Goals) response.readEntity(Goals.class)).getGoals();
		System.out.println("");
		System.out.println("STATUS");
		System.out.println(response.getStatus());
		return list;
	}

	@Override
	public List<Goal> readPersonsGoalsByTypeAndDate(int id, String measureType,
			String before, String after) {
		System.out.println("DataService - readPersonsGoalsByTypeAndDate pID = "
				+ id + " measureType = " + measureType + " before = " + before
				+ " after = " + after);
		InitConnection();
		WebTarget service1 = service
				.path("/person/" + Integer.toString(id) + "/goals/"
						+ measureType).queryParam("before", before)
				.queryParam("after", after);
		;
		System.out.println("REQUEST: GET " + service1.getUri().toString());
		Response response = service1.request()
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.get();
		List<Goal> list = ((Goals) response.readEntity(Goals.class)).getGoals();

		System.out.println("STATUS");
		System.out.println(response.getStatus());
		System.out.println("");
		return list;
	}

	@Override
	public Measure savePersonMeasurement(int id, Measure newStatus) {
		System.out.println("DataService - savePersonMeasurement pID = " + id);
		InitConnection();
		WebTarget personPath = service.path("/person/" + Integer.toString(id)
				+ "/measurements");
		System.out.println("REQUEST: POST " + personPath.getUri().toString());

		Builder req = personPath.request().accept(MediaType.APPLICATION_XML);

		Response response = req.post(Entity.xml(newStatus));

		System.out.println("STATUS");
		System.out.println(response.getStatus());
		System.out.println("");
		return newStatus;
	}

	@Override
	public Goal savePersonGoal(int id, Goal newStatus) {
		System.out.println("DataService - savePersonGoal pID = " + id);
		InitConnection();
		WebTarget personPath = service.path("/person/" + Integer.toString(id)
				+ "/goals");
		System.out.println("REQUEST: POST " + personPath.getUri().toString());

		Builder req = personPath.request().accept(MediaType.APPLICATION_XML);

		Response response = req.post(Entity.xml(newStatus));

		System.out.println("STATUS");
		System.out.println(response.getStatus());
		System.out.println("");
		return newStatus;
	}

	@Override
	public Person createPerson(Person person) {
		System.out.println("DataService - createPerson");
		InitConnection();
		WebTarget personPath = service.path("/person");
		System.out.println("");

		Builder req = personPath.request().accept(MediaType.APPLICATION_XML);
		System.out.println("REQUEST: POST " + personPath.getUri().toString());
		Response response = req.post(Entity.xml(person));

		System.out.println("STATUS");
		System.out.println(response.getStatus());
		System.out.println("");
		return person;
	}

	@Override
	public MeasureType createMeasureType(MeasureType mt) {
		System.out.println("DataService - createMeasureType");
		InitConnection();
		WebTarget personPath = service.path("/measureType");
		System.out.println("REQUEST: POST " + personPath.getUri().toString());

		Builder req = personPath.request().accept(MediaType.APPLICATION_XML);

		Response response = req.post(Entity.xml(mt));

		System.out.println("STATUS");
		System.out.println(response.getStatus());
		System.out.println("");
		return mt;
	}

	@Override
	public String getRandomQuote() {
		System.out.println("DataService - getRandomQuote");
		String result = "";
		String uriString;
		uriString = "http://localhost:446/QuoteAdapter/randomquote";

		WebTarget service;
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		service = client.target(UriBuilder.fromUri(uriString).build());
		Response response = service.request().accept(MediaType.TEXT_XML).get();
		System.out.println("STATUS");
		System.out.println("Code: " + response.getStatus());
		result = (String) response.readEntity(String.class);
		System.out.println("");

		return result;
	}

	private void InitConnection() {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		service = client.target(getBaseURI());
	}

	private static URI getBaseURI() {
		String uriString;
		uriString = "http://localhost:447/localDB";

		return UriBuilder.fromUri(uriString).build();
	}

}
