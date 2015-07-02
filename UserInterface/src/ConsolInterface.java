import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import soap.processcentricservices.ProcessCentricServices;

public class ConsolInterface {

	private static int id = -1;

	// ProcessCentricServices processCentricService;
	private static ProcessCentricServices initConnection()
			throws MalformedURLException {
		URL url = new URL("http://localhost:451/ws/processcentricservice?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://processcentricservices.soap/",
				"ProcessCentricServices");
		Service service = Service.create(url, qname);

		return service.getPort(ProcessCentricServices.class);

	}

	public static void main(String[] args) {
		boolean exit = false;

		System.out.println("Welcome to LifeCoach!");
		System.out.println("======================================");
		System.out.println("");
		printMenu();

		Scanner terminalInput = new Scanner(System.in);
		while (!exit) {

			System.out.println("Command?");
			String command = terminalInput.nextLine();
			String[] parts = command.split(" ");
			if (parts.length == 4 && parts[0].equals("register")
					&& parts[1].equals("user"))
				registerUser(command);
			else if (parts.length == 3 && parts[0].equals("login"))
				loginUser(command);
			else if (parts.length == 1 && parts[0].equals("quote"))
				getQuote();
			else if (parts.length == 1 && parts[0].equals("exit"))
				exit = true;
			else if (parts.length == 1 && parts[0].equals("menu"))
				printMenu();
			else if (parts.length == 1 && parts[0].equals("measurementtypes"))
				getMeasurementTypes();
			else if (id > 0) {
				if (parts.length == 1 && parts[0].equals("logout"))
					logOut();
				else if ((parts.length == 5 || parts.length == 4)
						&& parts[0].equals("measurement"))
					newMeasurment(command);
				else if (parts.length == 1 && parts[0].equals("measurements"))
					getMeasurments();
				else if (parts.length == 1 && parts[0].equals("goals"))
					getGoals();
				else if ((parts.length == 11 || parts.length == 9)
						&& parts[0].equals("goal"))
					newGoal(command);
				else if ((parts.length == 1) && parts[0].equals("progress"))
					getProgressInfo(command);
				else
					System.out
							.println("Sorry, bad command.. for syntax see \"menu\"!");

			} else
				System.out.println("Sorry you must first log in.");

		}
		System.out.println("Have a nice day champion!! :)");
	}

	private static void getProgressInfo(String command) {
		ProcessCentricServices processCentricService;

		try {
			processCentricService = initConnection();
			String info = processCentricService.getProgressInfo(id);
			List<String> sl = new ArrayList<String>(Arrays.asList(info
					.split("#")));
			for (String s : sl)
				System.out.println(s);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void getMeasurementTypes() {
		ProcessCentricServices processCentricService;
		try {
			processCentricService = initConnection();
			List<String> sl = new ArrayList<String>(
					Arrays.asList(processCentricService.getMeasurmentTypes()
							.split(" ")));
			System.out.println("Registered measurement-types:  ");
			for (String s : sl)
				System.out.println("  " + s);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void printMenu() {
		System.out
				.println("User registration	: register user <forename> <lastname>");
		System.out.println("Login				: login <forename> <lastname>");
		System.out.println("Logout				: logout");
		System.out.println("Get my measurments 	: measurments");
		System.out
				.println("Register measurment : measurment <type> <value> <unit> (optional : <yyyy-mm-dd>)");
		System.out.println("Get my goals 		: goals");
		System.out
				.println("Register goal 		: goal <type> more/less than <value> <unit> <interval: \"per X days\")> (optional: <until yyyy-mm-dd>)");
		System.out.println("Get some positive	: quote");
		System.out.println("Get measurment types: types");
		System.out.println("Menu				: menu");
		System.out.println("Exit				: exit");
	}

	private static void getGoals() {

		try {
			ProcessCentricServices processCentricService = initConnection();
			String answer = processCentricService.getGoals(id);
			String sl[] = answer.split("#");
			for (int i = 0; i < sl.length; ++i)
				System.out.println(sl[i]);
		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

	}

	private static void getMeasurments() {
		try {
			ProcessCentricServices processCentricService = initConnection();
			String answer = processCentricService.getMeasures(id);
			String sl[] = answer.split("#");
			for (int i = 0; i < sl.length; ++i)
				System.out.println(sl[i]);
		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

	}

	private static void getQuote() {
		try {
			ProcessCentricServices processCentricService = initConnection();
			System.out.println(processCentricService.getQuote());

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

	}

	private static void newGoal(String string) {
		try {
			String goalDescription = string.split(" ")[1];
			ProcessCentricServices processCentricService = initConnection();
			List<String> sl = new ArrayList<String>(
					Arrays.asList(processCentricService.getMeasurmentTypes()
							.split(" ")));
			if (!sl.contains(goalDescription)) {
				String measurmentDescription = goalDescription;
				measurmentDescription += " " + string.split(" ")[5] + " ";
				System.out
						.println("The type \""
								+ goalDescription
								+ "\" is not in database. Please specify how to count the progress!");
				System.out.println("1: sum measurments");
				System.out.println("2: only the value counts");
				Scanner terminalInput = new Scanner(System.in);
				int answer = terminalInput.nextInt();
				if (answer == 1)
					measurmentDescription += "sum";
				else
					measurmentDescription += "value";
				processCentricService
						.addNewMeasurmentType(measurmentDescription);

			}
			String answer = processCentricService.registerGoal(id, string);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

	}

	private static void newMeasurment(String string) {
		try {
			String goalDescription = string.split(" ")[1];
			ProcessCentricServices processCentricService = initConnection();

			String answer = processCentricService
					.registerMeasurment(id, string);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

	}

	private static void logOut() {
		id = -1;

	}

	private static void loginUser(String string) {
		try {
			ProcessCentricServices processCentricService = initConnection();
			id = processCentricService.login(string);
			System.out.println("Succesful login, ID = " + id);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void registerUser(String string) {
		try {
			ProcessCentricServices processCentricService = initConnection();
			id = processCentricService.register(string);
			System.out.println("User created, ID = " + id);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
