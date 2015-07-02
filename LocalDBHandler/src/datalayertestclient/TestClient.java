package datalayertestclient; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import rest.ehealth.model.Person;
import soap.DataService;
import soap.collectionmodel.People;

/**
 * @author Maja
 *
 */
public class TestClient {
	static PrintWriter writer = null;

	public static void println(String s) throws FileNotFoundException,
			UnsupportedEncodingException {
		// if( writer==null)
		// writer = new PrintWriter("log.txt", "UTF-8");
		// println(s);
		System.out.println(s);
	}

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:444/ws/dataservice?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://soap/", "DataService");
		Service service = Service.create(url, qname);

		DataService dataservice = service.getPort(DataService.class);

		// #1
		// List<Person> pList =
		method1(dataservice);
		method2(dataservice);

	}

	private static void method2(DataService dataservice) {
		System.out.println("proba");
		String res = dataservice.getRandomQuote();
		System.out.println(res);

	}

	private static void method1(DataService dataservice) throws JAXBException,
			PropertyException, FileNotFoundException,
			UnsupportedEncodingException {

		println("");
		println("=========Method #1=========");
		println("Get all people ");
		println("");

		List<Person> pList = dataservice.readPersonList();
		People pl = new People();
		pl.setPeople(pList);
		JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshal the employees list in console
		println("");
		println("People:");
		println("");

		jaxbMarshaller.marshal(pl, System.out);
		// return pList;

	}

	// private static void method2(DataService dataservice) throws
	// JAXBException,
	// PropertyException, FileNotFoundException, UnsupportedEncodingException {
	//
	// println("");
	// println("=========Method #1=========");
	// println("Get all people ");
	// println("");
	//
	// List<Person> pList = dataservice.readPersonList();
	// People pl = new People();
	// pl.setPeople(pList);
	// JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
	// Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	// jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	// //Marshal the employees list in console
	// println("");
	// println("People:");
	// println("");
	//
	// jaxbMarshaller.marshal(pl, System.out);
	// //return pList;
	//
	//
	// }

}