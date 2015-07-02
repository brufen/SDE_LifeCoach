package rest.ehealth.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.ehealth.model.Goal;
import rest.ehealth.model.Measure;
import rest.ehealth.model.Person;
import soap.collectionmodel.Goals;
import soap.collectionmodel.Measurments;
import soap.collectionmodel.People;

/**
 * @author Marija Grozdanic
 *
 */
@Stateless
@LocalBean
@Path("/person")
public class PersonResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// THIS IS NOT WORKING
	// @PersistenceUnit(unitName="introsde-jpa")
	// EntityManager entityManager;
	//
	// // THIS IS NOT WORKING
	// @PersistenceContext(unitName =
	// "introsde-jpa",type=PersistenceContextType.TRANSACTION)
	// private EntityManagerFactory entityManagerFactory;
	// EntityManager entityManager;

	// int id;

	// public PersonResource(UriInfo uriInfo, Request request,int id,
	// EntityManager em) {
	// this.uriInfo = uriInfo;
	// this.request = request;
	// this.id = id;
	// this.entityManager = em;
	// }
	//
	// public PersonResource(UriInfo uriInfo, Request request,int id) {
	// this.uriInfo = uriInfo;
	// this.request = request;
	// this.id = id;
	// }
	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	public People getPersonsBrowser(@Context UriInfo info) {
		System.out.println("Getting list of people...");
		List<Person> people = Person.getAll();
		People p = new People();
		p.setPeople(people);
		return p;
	}

	// Application integration
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{personId}")
	public Person getPerson(@PathParam("personId") int id) {
		Person person = this.getPersonById(id);
		if (person == null)
			/* throw new RuntimeException */System.out
					.println("Get: Person with " + id + " not found");
		return person;
	}

	// for the browser
	// @GET
	// @Produces(MediaType.TEXT_XML)
	// public Person getPersonHTML() {
	// Person person = this.getPersonById(id);
	// if (person == null)
	// /*throw new RuntimeException*/System.out.println("Get: Person with " + id
	// + " not found");
	// System.out.println("Returning person... " + person.getPersonId());
	// return person;
	// }

	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	@Path("{personId}/measurements/{measureType}")
	public Measurments getPersonMeasures(@PathParam("personId") int id,
			@PathParam("measureType") String measureType, @Context UriInfo info) {

		// String measureType =
		// info.getQueryParameters().getFirst("measureType");
		String after = info.getQueryParameters().getFirst("after");
		String before = info.getQueryParameters().getFirst("before");

		List<Measure> result = new ArrayList<Measure>();
		List<Measure> temp = Person.getPersonById(id).getMeasures();
		// Date from;
		// if(after==null)
		// after = "0001-01-01";
		// if(before==null)
		// after = "9999-12-12";
		// try {
		//
		// from = new SimpleDateFormat("yyyy-MM-dd").parse(after);
		// System.out.println("From : "+from);
		// Date to = new SimpleDateFormat("yyyy-MM-dd").parse(before);
		// System.out.println("To : "+to);
		// for(Measure m : temp ){
		// if(m.getMeasureType().getDescription().equals(measureType)||measureType.equals("all")){
		// Date d = new SimpleDateFormat("yyyy-MM-dd").parse(m.getDate());
		// System.out.println(d);
		// if(d.compareTo(from)>=0&&d.compareTo(to)<=0)
		// result.add(m);
		// }
		// }
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// //return null;
		// }
		Measurments res = new Measurments();
		res.setMeasurments(temp);
		return res;
	}

	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	@Path("{personId}/goals/{measureType}")
	public Goals getPersonGoals(@PathParam("personId") int id,
			@PathParam("measureType") String measureType, @Context UriInfo info) {
		System.out.println("WE are here -- " + info.toString());
		System.out.println("WE are here -- " + id);
		// String measureType =
		// info.getQueryParameters().getFirst("measureType");
		String after = info.getQueryParameters().getFirst("after");
		String before = info.getQueryParameters().getFirst("before");
		if (after == null)
			after = "0001-01-01";
		if (before == null)
			after = "9999-12-12";

		List<Goal> resultList = new ArrayList<Goal>();
		List<Goal> temp = Person.getPersonById(id).getGoals();
		System.out.println("GoalCount altogether in database: " + temp.size());
		// Date from;
		// try {
		// from = new SimpleDateFormat("yyyy-MM-dd").parse(after);
		// System.out.println("From : "+from);
		// Date to = new SimpleDateFormat("yyyy-MM-dd").parse(before);
		// System.out.println("To : "+to);
		// for(Goal m : temp ){
		// if(m.getMeasureType().getDescription().equals(measureType)||measureType.equals("all")){
		// Date d = new SimpleDateFormat("yyyy-MM-dd").parse(m.getDate());
		// System.out.println(d);
		// if(d.compareTo(from)>=0&&d.compareTo(to)<=0)
		// resultList.add(m);
		// }
		// }
		// } catch (ParseException e) {
		// System.out.println("---------ERROR IN SELECTION---------");
		// e.printStackTrace();
		// //return null;
		// }
		System.out
				.println("GoalCount after select in database: " + temp.size());
		Goals result = new Goals();
		result.setGoals(temp);
		return result;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Person newPerson(Person person) throws IOException {

		System.out.println("Creating new person...");
		/*
		 * HealthProfile hp = person.getHealthProfile(); if(hp != null){
		 * //System
		 * .out.println("****** Before: Id : "+hp.getId()+"Height : "+hp.
		 * getHeight()+"Height : "+hp.getWeight()); hp =
		 * HealthProfile.saveHealthProfile(hp);
		 * //System.out.println("Id : "+hp.getId
		 * ()+"Height : "+hp.getHeight()+"Height : "+hp.getWeight());
		 * person.setHealthProfile(hp);
		 * 
		 * }
		 */
		return Person.savePerson(person);

	}

	@POST
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{personId}/measurements")
	public Measure addNewMeasure(Measure m, @PathParam("personId") int id,
			@PathParam("measureType") String measureType) {
		System.out.println("addNewMeasure");
		System.out.println("value: " + m.getValue());
		System.out.println("value: " + m.getDate());
		Person person = Person.getPersonById(id);
		System.out.println(person.getName() + " " + person.getSurname());
		if (person == null)
			throw new RuntimeException("Get: Person with " + id + " not found");

		// List<MeasureType> mtl = MeasureType.getAll();
		// MeasureType type = null;
		// for(MeasureType mt :mtl)
		// if(mt.getDescription().equals(measureType)){
		// m.setMeasureType(mt);
		// type = mt;
		// }

		// type.addMeasure(m);
		person.addMeasure(m);
		m.setPerson(person);
		// HealthProfile hp =person.getHealthProfile();
		// hp.addMeasure(m);
		// m.setHealthProfile(hp);
		Person.updatePerson(person);
		for (Measure m1 : person/* .getHealthProfile() */.getMeasures())
			if (m1.getDate().equals(m.getDate())
					&& m1.getMeasureType().getDescription()
							.equals(m.getMeasureType().getDescription())
					&& m1.getValue() == m.getValue())
				return m1;

		return m;

	}

	@POST
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{personId}/goals")
	public Goal addNewGoal(Goal goal, @PathParam("personId") int id,
			@PathParam("measureType") String measureType) {
		System.out.println("addNewMeasure");
		System.out.println("value: " + goal.getValue());
		// System.out.println("value: "+ m.getDate());
		Person person = Person.getPersonById(id);
		System.out.println(person.getName() + " " + person.getSurname());
		if (person == null)
			throw new RuntimeException("Get: Person with " + id + " not found");

		// List<MeasureType> mtl = MeasureType.getAll();
		// MeasureType type = null;
		// for(MeasureType mt :mtl)
		// if(mt.getDescription().equals(measureType)){
		// goal.setMeasureType(mt);
		// type = mt;
		// }
		// Person p = Person.getPersonById(id);
		// p.getHealthProfile().addMeasure(newStatus);
		// p.getLifeStatus().add(newStatus);
		// Person.updatePerson(p);
		// List<LifeStatus> lsl= p.getHealthProfile().getMeasures();

		// goal.getMeasureType().addGoal(goal);
		person.addGoal(goal);
		goal.setPerson(person);
		// HealthProfile hp =person.getHealthProfile();
		// hp.addMeasure(m);
		// m.setHealthProfile(hp);
		Person.updatePerson(person);
		// for(Measure m1: person/*.getHealthProfile()*/.getMeasures())
		// if(m1.getDate().equals(m.getDate())&&m1.getMeasureType().getDescription().equals(m.getMeasureType().getDescription())&&m1.getValue()==m.getValue())
		// return m1;
		//

		return goal;

	}

	// @POST
	// @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON ,
	// MediaType.APPLICATION_XML })
	// @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	// @Path("{personId}/{measureType}")
	// public void addNewType(MeasureType type,@PathParam("personId") int
	// id,@PathParam("measureType") String measureType) {
	// MeasureType.saveMeasureType(type);
	//
	// }

	// @DELETE
	// public void deletePerson() {
	// Person c = getPersonById(id);
	// if (c == null)
	// throw new RuntimeException("Delete: Person with " + id
	// + " not found");
	//
	// Person.removePerson(c);
	// }

	public Person getPersonById(int personId) {
		System.out.println("Reading person from DB with id: " + personId);
		// Person person = entityManager.find(Person.class, personId);

		Person person = Person.getPersonById(personId);
		System.out.println("Person: " + person.toString());
		return person;
	}
}
