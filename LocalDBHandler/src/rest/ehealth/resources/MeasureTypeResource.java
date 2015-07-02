package rest.ehealth.resources;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

import rest.ehealth.model.CountingMethod;
import rest.ehealth.model.MeasureType;
import soap.collectionmodel.MeasurmentTypes;

/**
 * @author Marija Grozdanic
 *
 */
@Stateless
@LocalBean
@Path("/measureType")
public class MeasureTypeResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	EntityManager entityManager;

	// int id;

	// public MeasureTypeResource(UriInfo uriInfo, Request request,int id,
	// EntityManager em) {
	// this.uriInfo = uriInfo;
	// this.request = request;
	// this.id = id;
	// this.entityManager = em;
	// }
	//
	// public MeasureTypeResource(UriInfo uriInfo, Request request,int id) {
	// this.uriInfo = uriInfo;
	// this.request = request;
	// this.id = id;
	// }
	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	public MeasurmentTypes getMeasureTypeBrowser(@Context UriInfo info) {
		MeasurmentTypes result = new MeasurmentTypes();
		System.out.println("Getting list of people...");
		List<MeasureType> measures = MeasureType.getAll();
		result.setMeasurmentTypes(measures);
		return result;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{personId}")
	public MeasureType getPerson(@PathParam("personId") int id) {
		MeasureType measureType = MeasureType.getMeasureTypeById(id);
		if (measureType == null)
			/* throw new RuntimeException */System.out
					.println("Get: Person with " + id + " not found");
		return measureType;
	}

	// Application integration

	@POST
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// @Path("{personId}/{measureType}")
	public void addNewType(MeasureType type, @PathParam("personId") int id,
			@PathParam("measureType") String measureType) {
		System.out.println("CoountingMethod : "
				+ type.getCountingMethod().getCountingMethodId() + " "
				+ type.getCountingMethod().getDescription());
		for (CountingMethod cm : CountingMethod.getAll()) {
			System.out.println("CoountingMethod : " + cm.getCountingMethodId()
					+ " " + cm.getDescription());
			if (cm.getDescription().equals(
					type.getCountingMethod().getDescription()))
				type.setCountingMethod(cm);
		}
		System.out.println("CoountingMethod : "
				+ type.getCountingMethod().getCountingMethodId() + " "
				+ type.getCountingMethod().getDescription());
		MeasureType.saveMeasureType(type);

	}

}
