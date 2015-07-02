package soap.businesslogicservices;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;

import soap.CountingMethod;
import soap.DataService;
import soap.Goal;
import soap.Measure;
import soap.MeasureType;
import soap.Person;

/**
 * @author Marija Grozdanic
 *
 */
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService(endpointInterface = "soap.businesslogicservices.BusinessLogicServices", serviceName = "BusinessLogicService")
public class BusinessLogicServicesImplementation implements
		BusinessLogicServices {
	DataService dataservice;

	private void initConnection() throws MalformedURLException {
		URL url = new URL("http://localhost:444/ws/dataservice?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://soap/", "DataService");
		Service service = Service.create(url, qname);

		dataservice = service.getPort(DataService.class);

	}

	@Override
	public int registerUser(String userdata) throws MalformedURLException {
		initConnection();
		Person p = new Person();
		String[] sl = userdata.split(" ");
		p.setName(sl[2]);
		p.setSurname(sl[3]);
		Holder<Person> h = new Holder<Person>(p);
		dataservice.createPerson(h);
		return h.value.getPersonId();
	}

	@Override
	public int loginUser(String userdata) throws MalformedURLException {
		initConnection();
		String[] sl = userdata.split(" ");
		String name = sl[1];
		String surname = sl[2];
		List<Person> pl = dataservice.readPersonList();
		for (Person p : pl)
			if (p.getName().equals(name) && p.getSurname().equals(surname))
				return p.getPersonId();
		return -1;
	}

	@Override
	public String getMeasures(int userdata) throws MalformedURLException {
		initConnection();
		String result = "";
		List<Measure> ml = dataservice.readPersonMeasures(userdata);
		for (Measure m : ml)
			result += m.getDate() + " " + m.getMeasureType().getDescription()
					+ " " + m.getValue() + " " + m.getMeasureType().getUnit()
					+ "#";
		return result;
	}

	@Override
	public String getGoals(int userdata) throws MalformedURLException {
		initConnection();
		String result = "";
		List<Goal> ml = dataservice.readPersonGoals(userdata);
		for (Goal m : ml) {
			String moreOrLess = (m.getMoreOrLess() > 0 ? "more than"
					: "less than");
			String endOfTerm = "";
			if (m.getTermIsSolid() > 0)
				endOfTerm = " until " + m.getEnddate();
			result += m.getDate() + " " + m.getMeasureType().getDescription()
					+ " " + moreOrLess + " " + m.getValue() + " "
					+ m.getMeasureType().getUnit() + " per " + m.getTerm()
					+ " days" + endOfTerm + "#";
		}
		return result;
	}

	@Override
	public String registerMeasurment(int userdata, String measurmentData)
			throws MalformedURLException {
		// Register measurment : measurment <type> <value> <unit> (optional :
		// <yyyy-mm-dd>)
		String[] sl = measurmentData.split(" ");
		initConnection();
		Measure m = new Measure();
		List<MeasureType> mtl = dataservice.readMeasureTypeList();
		for (MeasureType mt : mtl)
			if (mt.getDescription().equals(sl[1]))
				m.setMeasureType(mt);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		m.setValue(Double.parseDouble(sl[2]));
		m.setDate(sl.length == 5 ? sl[4] : (dateFormat.format(cal.getTime())));
		System.out.println(m.getDate());
		dataservice.savePersonMeasurement(userdata, m);
		return null;
	}

	@Override
	public String registerGoal(int userdata, String goalData)
			throws MalformedURLException {
		// goal <type> more/less than <value> <unit> <interval: \"per X days\")>
		// (optional: <until yyyy-mm-dd>)
		String[] sl = goalData.split(" ");
		initConnection();
		Goal g = new Goal();
		List<MeasureType> mtl = dataservice.readMeasureTypeList();
		for (MeasureType mt : mtl)
			if (mt.getDescription().equals(sl[1]))
				g.setMeasureType(mt);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		g.setDate(dateFormat.format(cal.getTime()));
		g.setMoreOrLess(sl[2].equals("more") ? 1 : -1);
		g.setValue(Double.parseDouble(sl[4]));
		g.setTerm(Integer.parseInt(sl[7]));
		if (sl.length == 10) {
			g.setTermIsSolid(1);
			g.setEnddate(sl[10]);
		}
		dataservice.savePersonGoal(userdata, g);
		return null;
	}

	// Date d = new SimpleDateFormat("yyyy-MM-dd").parse(m.getDate());
	// System.out.println(d);
	// if(d.compareTo(from)>=0&&d.compareTo(to)<=0)
	// result.add(m);

	public static long getDateDiffInDays(Date date1, Date date2,
			TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.DAYS);
	}

	@Override
	public String getProgressInfo(int userdata) throws MalformedURLException {
		initConnection();
		String answer = "", fulfilledGoals = "Goals you have reached:", failedGoals = "Goals you haven't reached:", onGoodWayGoals = "Goals,which you are on good way to reach:", moreEffortGoals = "Goals,which need more efforts to reach:", NotEoughInfo = "There is no information enough to count progress:";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Measure> ml = dataservice.readPersonMeasures(userdata);
		List<Goal> gl = dataservice.readPersonGoals(userdata);
		for (Goal g : gl) {

			if (g.getMeasureType().getCountingMethod().getDescription()
					.equals("value")) {
				// git
				try {
					Measure firstInTerm = null, lastInTerm = null;
					Date firstMeasureDate = null, lastMeasureDate = null;
					Date startdate = sdf.parse(g.getDate());
					Calendar cal = Calendar.getInstance();
					cal.setTime(startdate);
					cal.add(Calendar.DATE, g.getTerm()); //
					Date endDate = cal.getTime();
					System.out.println("Value - Interval: " + g.getDate()
							+ " + " + g.getTerm() + " -> " + endDate);
					Calendar calact = Calendar.getInstance();
					Date actDate = calact.getTime();
					for (Measure m : ml) {
						Date measureDate = sdf.parse(m.getDate());
						if (m.getMeasureType().getDescription()
								.equals(g.getMeasureType().getDescription())
								&& measureDate.compareTo(startdate) >= 0
								&& measureDate.compareTo(endDate) <= 0) {
							if (firstInTerm == null
									|| measureDate.compareTo(firstMeasureDate) < 0) {
								firstInTerm = m;
								firstMeasureDate = measureDate;
							}
							if (lastInTerm == null
									|| measureDate.compareTo(lastMeasureDate) > 0) {
								lastInTerm = m;
								lastMeasureDate = measureDate;
							}
						}
					}
					double diffPerDay = (lastInTerm.getValue() - firstInTerm
							.getValue())
							/ getDateDiffInDays(firstMeasureDate,
									lastMeasureDate, TimeUnit.MINUTES);// lastMeasureDate.compareTo(firstMeasureDate);
					double predictedValue = firstInTerm.getValue()
							+ diffPerDay
							* getDateDiffInDays(firstMeasureDate, endDate,
									TimeUnit.MINUTES);
					if ((g.getMoreOrLess() > 0 && predictedValue > g.getValue())
							|| (g.getMoreOrLess() < 0 && predictedValue < g
									.getValue())) {// OK
						if (endDate.compareTo(actDate) > 0) {
							String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
									: "less than");
							String endOfTerm = "";
							if (g.getTermIsSolid() > 0)
								endOfTerm = " until " + g.getEnddate();
							fulfilledGoals += "#" + g.getDate() + " "
									+ g.getMeasureType().getDescription() + " "
									+ moreOrLess + " " + g.getValue() + " "
									+ g.getMeasureType().getUnit() + " per "
									+ g.getTerm() + " days" + endOfTerm
									+ " ==> last measurement in term: "
									+ lastInTerm.getValue() + " "
									+ lastInTerm.getMeasureType().getUnit()
									+ " ( " + lastInTerm.getDate() + " )";
						} else {
							String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
									: "less than");
							String endOfTerm = "";
							if (g.getTermIsSolid() > 0)
								endOfTerm = " until " + g.getEnddate();
							onGoodWayGoals += "#" + g.getDate() + " "
									+ g.getMeasureType().getDescription() + " "
									+ moreOrLess + " " + g.getValue() + " "
									+ g.getMeasureType().getUnit() + " per "
									+ g.getTerm() + " days" + endOfTerm
									+ " ==> last measurement in term: "
									+ lastInTerm.getValue() + " "
									+ lastInTerm.getMeasureType().getUnit()
									+ " ( " + lastInTerm.getDate() + " )";
						}

					} else if (lastMeasureDate.equals(firstMeasureDate)) {
						String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
								: "less than");
						String endOfTerm = "";
						if (g.getTermIsSolid() > 0)
							endOfTerm = " until " + g.getEnddate();
						NotEoughInfo += "#" + g.getDate() + " "
								+ g.getMeasureType().getDescription() + " "
								+ moreOrLess + " " + g.getValue() + " "
								+ g.getMeasureType().getUnit() + " per "
								+ g.getTerm() + " days" + endOfTerm
								+ " ==> First Measurement in term"
								+ firstInTerm.getValue() + " "
								+ lastInTerm.getMeasureType().getUnit() + " ( "
								+ firstInTerm.getDate() + " )"
								+ " last measurement in term: "
								+ lastInTerm.getValue() + " "
								+ lastInTerm.getMeasureType().getUnit() + " ( "
								+ lastInTerm.getDate() + " )";
					} else {// fail
						if (endDate.compareTo(actDate) > 0) {
							String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
									: "less than");
							String endOfTerm = "";
							if (g.getTermIsSolid() > 0)
								endOfTerm = " until " + g.getEnddate();
							failedGoals += "#" + g.getDate() + " "
									+ g.getMeasureType().getDescription() + " "
									+ moreOrLess + " " + g.getValue() + " "
									+ g.getMeasureType().getUnit() + " per "
									+ g.getTerm() + " days" + endOfTerm
									+ " ==> last measurement in term: "
									+ lastInTerm.getValue() + " "
									+ lastInTerm.getMeasureType().getUnit()
									+ " ( " + lastInTerm.getDate() + " )";

						} else {
							// finished
							String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
									: "less than");
							String endOfTerm = "";
							if (g.getTermIsSolid() > 0)
								endOfTerm = " until " + g.getEnddate();
							moreEffortGoals += "#" + g.getDate() + " "
									+ g.getMeasureType().getDescription() + " "
									+ moreOrLess + " " + g.getValue() + " "
									+ g.getMeasureType().getUnit() + " per "
									+ g.getTerm() + " days" + endOfTerm
									+ " ==> last measurement in term: "
									+ lastInTerm.getValue() + " "
									+ lastInTerm.getMeasureType().getUnit()
									+ " ( " + lastInTerm.getDate() + " )";

						}
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (g.getMeasureType().getCountingMethod().getDescription()
					.equals("sum")) {
				try {

					Date startdate;
					Calendar calact = Calendar.getInstance();
					Date actDate = calact.getTime();
					// startdate = sdf.parse(g.getDate());
					Calendar cal = Calendar.getInstance();
					Boolean ended = false;
					if (g.getEnddate() != null
							&& sdf.parse(g.getEnddate()).compareTo(actDate) > 0) {
						cal.setTime(sdf.parse(g.getEnddate()));
						ended = true;
					}

					Date endDate = cal.getTime();
					cal.add(Calendar.DATE, -g.getTerm()); //
					startdate = cal.getTime();
					System.out.println(g.getMeasureType().getDescription()
							+ "SUM - Interval: " + " " + startdate + " + "
							+ g.getTerm() + " -> " + endDate);

					double sum = 0;
					for (Measure m : ml) {
						Date measureDate = sdf.parse(m.getDate());

						if (m.getMeasureType().getDescription()
								.equals(g.getMeasureType().getDescription())) {
							System.out.println(m.getMeasureType()
									.getDescription()
									+ " "
									+ measureDate
									+ " "
									+ m.getValue());
							if (measureDate.compareTo(startdate) >= 0
									&& measureDate.compareTo(endDate) <= 0) {
								sum += m.getValue();
								System.out.println(m.getMeasureType()
										.getDescription() + " " + m.getValue());
							}
						}
					}
					if ((sum > g.getValue() && g.getMoreOrLess() > 0)
							|| (sum < g.getValue() && g.getMoreOrLess() < 0)) {
						if (ended) {
							String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
									: "less than");
							String endOfTerm = "";
							if (g.getTermIsSolid() > 0)
								endOfTerm = " until " + g.getEnddate();
							fulfilledGoals += "#" + g.getDate() + " "
									+ g.getMeasureType().getDescription() + " "
									+ moreOrLess + " " + g.getValue() + " "
									+ g.getMeasureType().getUnit() + " per "
									+ g.getTerm() + " days" + endOfTerm
									+ " ==> " + g.getMeasureType().getUnit()
									+ " in the last measured " + g.getTerm()
									+ "days: " + sum;

						} else {
							String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
									: "less than");
							String endOfTerm = "";
							if (g.getTermIsSolid() > 0)
								endOfTerm = " until " + g.getEnddate();
							onGoodWayGoals += "#" + g.getDate() + " "
									+ g.getMeasureType().getDescription() + " "
									+ moreOrLess + " " + g.getValue() + " "
									+ g.getMeasureType().getUnit() + " per "
									+ g.getTerm() + " days" + endOfTerm
									+ " ==> " + g.getMeasureType().getUnit()
									+ " in the last measured" + g.getTerm()
									+ "days: " + sum;

						}
					} else {
						if (ended) {
							String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
									: "less than");
							String endOfTerm = "";
							if (g.getTermIsSolid() > 0)
								endOfTerm = " until " + g.getEnddate();
							failedGoals += "#" + g.getDate() + " "
									+ g.getMeasureType().getDescription() + " "
									+ moreOrLess + " " + g.getValue() + " "
									+ g.getMeasureType().getUnit() + " per "
									+ g.getTerm() + " days" + endOfTerm
									+ " ==> " + g.getMeasureType().getUnit()
									+ " in the last measured" + g.getTerm()
									+ "days: " + sum;

						} else {
							String moreOrLess = (g.getMoreOrLess() > 0 ? "more than"
									: "less than");
							String endOfTerm = "";
							if (g.getTermIsSolid() > 0)
								endOfTerm = " until " + g.getEnddate();
							moreEffortGoals += "#" + g.getDate() + " "
									+ g.getMeasureType().getDescription() + " "
									+ moreOrLess + " " + g.getValue() + " "
									+ g.getMeasureType().getUnit() + " per "
									+ g.getTerm() + " days" + endOfTerm
									+ " ==> " + g.getMeasureType().getUnit()
									+ " in the last measured" + g.getTerm()
									+ "days: " + sum;

						}
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		return fulfilledGoals + "#" + failedGoals + "#" + onGoodWayGoals + "#"
				+ moreEffortGoals + "#" + NotEoughInfo;
	}

	public int addNewMeasurmentType(String measurmentDescription) {
		System.out.println("-----------MeasurmentDescription : "
				+ measurmentDescription);
		String[] sl = measurmentDescription.split(" ");
		CountingMethod cm = new CountingMethod();
		cm.setDescription(sl[2]);
		MeasureType mt = new MeasureType();
		mt.setCountingMethod(cm);
		mt.setDescription(sl[0]);
		mt.setUnit(sl[1]);
		Holder<MeasureType> h = new Holder<MeasureType>(mt);
		dataservice.createMeasureType(h);
		return 0;
	}

	@Override
	public String getMeasurmentTypes() {
		String answer = "";
		List<MeasureType> mtl = dataservice.readMeasureTypeList();
		for (MeasureType mt : mtl)
			answer += mt.getDescription() + " ";
		return answer;
	}

}
