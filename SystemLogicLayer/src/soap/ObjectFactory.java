package soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the soap package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _CreatePersonResponse_QNAME = new QName(
			"http://soap/", "createPersonResponse");
	private final static QName _ReadMeasureTypeList_QNAME = new QName(
			"http://soap/", "readMeasureTypeList");
	private final static QName _CreatePerson_QNAME = new QName("http://soap/",
			"createPerson");
	private final static QName _CreateMeasureType_QNAME = new QName(
			"http://soap/", "createMeasureType");
	private final static QName _ReadPersonMeasures_QNAME = new QName(
			"http://soap/", "readPersonMeasures");
	private final static QName _ReadPersonMeasuresResponse_QNAME = new QName(
			"http://soap/", "readPersonMeasuresResponse");
	private final static QName _ReadPerson_QNAME = new QName("http://soap/",
			"readPerson");
	private final static QName _SavePersonGoalResponse_QNAME = new QName(
			"http://soap/", "savePersonGoalResponse");
	private final static QName _ReadPersonMeasuresByTypeAndDateResponse_QNAME = new QName(
			"http://soap/", "readPersonMeasuresByTypeAndDateResponse");
	private final static QName _GetRandomQuote_QNAME = new QName(
			"http://soap/", "getRandomQuote");
	private final static QName _ReadPersonMeasuresByDate_QNAME = new QName(
			"http://soap/", "readPersonMeasuresByDate");
	private final static QName _ReadPersonGoalsResponse_QNAME = new QName(
			"http://soap/", "readPersonGoalsResponse");
	private final static QName _SavePersonGoal_QNAME = new QName(
			"http://soap/", "savePersonGoal");
	private final static QName _ReadPersonList_QNAME = new QName(
			"http://soap/", "readPersonList");
	private final static QName _ReadPersonGoalsByType_QNAME = new QName(
			"http://soap/", "readPersonGoalsByType");
	private final static QName _ReadPersonMeasuresByType_QNAME = new QName(
			"http://soap/", "readPersonMeasuresByType");
	private final static QName _ReadPersonGoalsByDateResponse_QNAME = new QName(
			"http://soap/", "readPersonGoalsByDateResponse");
	private final static QName _SavePersonMeasurement_QNAME = new QName(
			"http://soap/", "savePersonMeasurement");
	private final static QName _ReadPersonMeasuresByTypeAndDate_QNAME = new QName(
			"http://soap/", "readPersonMeasuresByTypeAndDate");
	private final static QName _ReadPersonGoalsByTypeResponse_QNAME = new QName(
			"http://soap/", "readPersonGoalsByTypeResponse");
	private final static QName _ReadPersonListResponse_QNAME = new QName(
			"http://soap/", "readPersonListResponse");
	private final static QName _ReadMeasureTypeListResponse_QNAME = new QName(
			"http://soap/", "readMeasureTypeListResponse");
	private final static QName _ReadPersonMeasuresByDateResponse_QNAME = new QName(
			"http://soap/", "readPersonMeasuresByDateResponse");
	private final static QName _SavePersonMeasurementResponse_QNAME = new QName(
			"http://soap/", "savePersonMeasurementResponse");
	private final static QName _ReadPersonGoalsByTypeAndDate_QNAME = new QName(
			"http://soap/", "readPersonGoalsByTypeAndDate");
	private final static QName _ReadPersonGoalsByDate_QNAME = new QName(
			"http://soap/", "readPersonGoalsByDate");
	private final static QName _CreateMeasureTypeResponse_QNAME = new QName(
			"http://soap/", "createMeasureTypeResponse");
	private final static QName _ReadPersonGoals_QNAME = new QName(
			"http://soap/", "readPersonGoals");
	private final static QName _GetRandomQuoteResponse_QNAME = new QName(
			"http://soap/", "getRandomQuoteResponse");
	private final static QName _ReadPersonGoalsByTypeAndDateResponse_QNAME = new QName(
			"http://soap/", "readPersonGoalsByTypeAndDateResponse");
	private final static QName _ReadPersonMeasuresByTypeResponse_QNAME = new QName(
			"http://soap/", "readPersonMeasuresByTypeResponse");
	private final static QName _ReadPersonResponse_QNAME = new QName(
			"http://soap/", "readPersonResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: soap
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link ReadPersonGoalsByType }
	 * 
	 */
	public ReadPersonGoalsByType createReadPersonGoalsByType() {
		return new ReadPersonGoalsByType();
	}

	/**
	 * Create an instance of {@link ReadPersonGoalsByTypeResponse }
	 * 
	 */
	public ReadPersonGoalsByTypeResponse createReadPersonGoalsByTypeResponse() {
		return new ReadPersonGoalsByTypeResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonMeasuresByTypeAndDate }
	 * 
	 */
	public ReadPersonMeasuresByTypeAndDate createReadPersonMeasuresByTypeAndDate() {
		return new ReadPersonMeasuresByTypeAndDate();
	}

	/**
	 * Create an instance of {@link SavePersonMeasurement }
	 * 
	 */
	public SavePersonMeasurement createSavePersonMeasurement() {
		return new SavePersonMeasurement();
	}

	/**
	 * Create an instance of {@link ReadPersonGoalsByDateResponse }
	 * 
	 */
	public ReadPersonGoalsByDateResponse createReadPersonGoalsByDateResponse() {
		return new ReadPersonGoalsByDateResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonMeasuresByType }
	 * 
	 */
	public ReadPersonMeasuresByType createReadPersonMeasuresByType() {
		return new ReadPersonMeasuresByType();
	}

	/**
	 * Create an instance of {@link ReadPersonMeasuresByDate }
	 * 
	 */
	public ReadPersonMeasuresByDate createReadPersonMeasuresByDate() {
		return new ReadPersonMeasuresByDate();
	}

	/**
	 * Create an instance of {@link GetRandomQuote }
	 * 
	 */
	public GetRandomQuote createGetRandomQuote() {
		return new GetRandomQuote();
	}

	/**
	 * Create an instance of {@link SavePersonGoal }
	 * 
	 */
	public SavePersonGoal createSavePersonGoal() {
		return new SavePersonGoal();
	}

	/**
	 * Create an instance of {@link ReadPersonGoalsResponse }
	 * 
	 */
	public ReadPersonGoalsResponse createReadPersonGoalsResponse() {
		return new ReadPersonGoalsResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonList }
	 * 
	 */
	public ReadPersonList createReadPersonList() {
		return new ReadPersonList();
	}

	/**
	 * Create an instance of {@link ReadPerson }
	 * 
	 */
	public ReadPerson createReadPerson() {
		return new ReadPerson();
	}

	/**
	 * Create an instance of {@link SavePersonGoalResponse }
	 * 
	 */
	public SavePersonGoalResponse createSavePersonGoalResponse() {
		return new SavePersonGoalResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonMeasuresByTypeAndDateResponse }
	 * 
	 */
	public ReadPersonMeasuresByTypeAndDateResponse createReadPersonMeasuresByTypeAndDateResponse() {
		return new ReadPersonMeasuresByTypeAndDateResponse();
	}

	/**
	 * Create an instance of {@link ReadMeasureTypeList }
	 * 
	 */
	public ReadMeasureTypeList createReadMeasureTypeList() {
		return new ReadMeasureTypeList();
	}

	/**
	 * Create an instance of {@link CreatePerson }
	 * 
	 */
	public CreatePerson createCreatePerson() {
		return new CreatePerson();
	}

	/**
	 * Create an instance of {@link CreatePersonResponse }
	 * 
	 */
	public CreatePersonResponse createCreatePersonResponse() {
		return new CreatePersonResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonMeasures }
	 * 
	 */
	public ReadPersonMeasures createReadPersonMeasures() {
		return new ReadPersonMeasures();
	}

	/**
	 * Create an instance of {@link CreateMeasureType }
	 * 
	 */
	public CreateMeasureType createCreateMeasureType() {
		return new CreateMeasureType();
	}

	/**
	 * Create an instance of {@link ReadPersonMeasuresResponse }
	 * 
	 */
	public ReadPersonMeasuresResponse createReadPersonMeasuresResponse() {
		return new ReadPersonMeasuresResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonMeasuresByTypeResponse }
	 * 
	 */
	public ReadPersonMeasuresByTypeResponse createReadPersonMeasuresByTypeResponse() {
		return new ReadPersonMeasuresByTypeResponse();
	}

	/**
	 * Create an instance of {@link GetRandomQuoteResponse }
	 * 
	 */
	public GetRandomQuoteResponse createGetRandomQuoteResponse() {
		return new GetRandomQuoteResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonGoalsByTypeAndDateResponse }
	 * 
	 */
	public ReadPersonGoalsByTypeAndDateResponse createReadPersonGoalsByTypeAndDateResponse() {
		return new ReadPersonGoalsByTypeAndDateResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonResponse }
	 * 
	 */
	public ReadPersonResponse createReadPersonResponse() {
		return new ReadPersonResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonGoalsByDate }
	 * 
	 */
	public ReadPersonGoalsByDate createReadPersonGoalsByDate() {
		return new ReadPersonGoalsByDate();
	}

	/**
	 * Create an instance of {@link ReadPersonGoals }
	 * 
	 */
	public ReadPersonGoals createReadPersonGoals() {
		return new ReadPersonGoals();
	}

	/**
	 * Create an instance of {@link CreateMeasureTypeResponse }
	 * 
	 */
	public CreateMeasureTypeResponse createCreateMeasureTypeResponse() {
		return new CreateMeasureTypeResponse();
	}

	/**
	 * Create an instance of {@link SavePersonMeasurementResponse }
	 * 
	 */
	public SavePersonMeasurementResponse createSavePersonMeasurementResponse() {
		return new SavePersonMeasurementResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonGoalsByTypeAndDate }
	 * 
	 */
	public ReadPersonGoalsByTypeAndDate createReadPersonGoalsByTypeAndDate() {
		return new ReadPersonGoalsByTypeAndDate();
	}

	/**
	 * Create an instance of {@link ReadPersonListResponse }
	 * 
	 */
	public ReadPersonListResponse createReadPersonListResponse() {
		return new ReadPersonListResponse();
	}

	/**
	 * Create an instance of {@link ReadMeasureTypeListResponse }
	 * 
	 */
	public ReadMeasureTypeListResponse createReadMeasureTypeListResponse() {
		return new ReadMeasureTypeListResponse();
	}

	/**
	 * Create an instance of {@link ReadPersonMeasuresByDateResponse }
	 * 
	 */
	public ReadPersonMeasuresByDateResponse createReadPersonMeasuresByDateResponse() {
		return new ReadPersonMeasuresByDateResponse();
	}

	/**
	 * Create an instance of {@link Person }
	 * 
	 */
	public Person createPerson() {
		return new Person();
	}

	/**
	 * Create an instance of {@link Measure }
	 * 
	 */
	public Measure createMeasure() {
		return new Measure();
	}

	/**
	 * Create an instance of {@link MeasureType }
	 * 
	 */
	public MeasureType createMeasureType() {
		return new MeasureType();
	}

	/**
	 * Create an instance of {@link CountingMethod }
	 * 
	 */
	public CountingMethod createCountingMethod() {
		return new CountingMethod();
	}

	/**
	 * Create an instance of {@link Goal }
	 * 
	 */
	public Goal createGoal() {
		return new Goal();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreatePersonResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "createPersonResponse")
	public JAXBElement<CreatePersonResponse> createCreatePersonResponse(
			CreatePersonResponse value) {
		return new JAXBElement<CreatePersonResponse>(
				_CreatePersonResponse_QNAME, CreatePersonResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadMeasureTypeList }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readMeasureTypeList")
	public JAXBElement<ReadMeasureTypeList> createReadMeasureTypeList(
			ReadMeasureTypeList value) {
		return new JAXBElement<ReadMeasureTypeList>(_ReadMeasureTypeList_QNAME,
				ReadMeasureTypeList.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerson }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "createPerson")
	public JAXBElement<CreatePerson> createCreatePerson(CreatePerson value) {
		return new JAXBElement<CreatePerson>(_CreatePerson_QNAME,
				CreatePerson.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateMeasureType }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "createMeasureType")
	public JAXBElement<CreateMeasureType> createCreateMeasureType(
			CreateMeasureType value) {
		return new JAXBElement<CreateMeasureType>(_CreateMeasureType_QNAME,
				CreateMeasureType.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonMeasures }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonMeasures")
	public JAXBElement<ReadPersonMeasures> createReadPersonMeasures(
			ReadPersonMeasures value) {
		return new JAXBElement<ReadPersonMeasures>(_ReadPersonMeasures_QNAME,
				ReadPersonMeasures.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonMeasuresResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonMeasuresResponse")
	public JAXBElement<ReadPersonMeasuresResponse> createReadPersonMeasuresResponse(
			ReadPersonMeasuresResponse value) {
		return new JAXBElement<ReadPersonMeasuresResponse>(
				_ReadPersonMeasuresResponse_QNAME,
				ReadPersonMeasuresResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ReadPerson }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPerson")
	public JAXBElement<ReadPerson> createReadPerson(ReadPerson value) {
		return new JAXBElement<ReadPerson>(_ReadPerson_QNAME, ReadPerson.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SavePersonGoalResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "savePersonGoalResponse")
	public JAXBElement<SavePersonGoalResponse> createSavePersonGoalResponse(
			SavePersonGoalResponse value) {
		return new JAXBElement<SavePersonGoalResponse>(
				_SavePersonGoalResponse_QNAME, SavePersonGoalResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonMeasuresByTypeAndDateResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonMeasuresByTypeAndDateResponse")
	public JAXBElement<ReadPersonMeasuresByTypeAndDateResponse> createReadPersonMeasuresByTypeAndDateResponse(
			ReadPersonMeasuresByTypeAndDateResponse value) {
		return new JAXBElement<ReadPersonMeasuresByTypeAndDateResponse>(
				_ReadPersonMeasuresByTypeAndDateResponse_QNAME,
				ReadPersonMeasuresByTypeAndDateResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetRandomQuote }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "getRandomQuote")
	public JAXBElement<GetRandomQuote> createGetRandomQuote(GetRandomQuote value) {
		return new JAXBElement<GetRandomQuote>(_GetRandomQuote_QNAME,
				GetRandomQuote.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonMeasuresByDate }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonMeasuresByDate")
	public JAXBElement<ReadPersonMeasuresByDate> createReadPersonMeasuresByDate(
			ReadPersonMeasuresByDate value) {
		return new JAXBElement<ReadPersonMeasuresByDate>(
				_ReadPersonMeasuresByDate_QNAME,
				ReadPersonMeasuresByDate.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonGoalsResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonGoalsResponse")
	public JAXBElement<ReadPersonGoalsResponse> createReadPersonGoalsResponse(
			ReadPersonGoalsResponse value) {
		return new JAXBElement<ReadPersonGoalsResponse>(
				_ReadPersonGoalsResponse_QNAME, ReadPersonGoalsResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonGoal }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "savePersonGoal")
	public JAXBElement<SavePersonGoal> createSavePersonGoal(SavePersonGoal value) {
		return new JAXBElement<SavePersonGoal>(_SavePersonGoal_QNAME,
				SavePersonGoal.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonList }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonList")
	public JAXBElement<ReadPersonList> createReadPersonList(ReadPersonList value) {
		return new JAXBElement<ReadPersonList>(_ReadPersonList_QNAME,
				ReadPersonList.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonGoalsByType }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonGoalsByType")
	public JAXBElement<ReadPersonGoalsByType> createReadPersonGoalsByType(
			ReadPersonGoalsByType value) {
		return new JAXBElement<ReadPersonGoalsByType>(
				_ReadPersonGoalsByType_QNAME, ReadPersonGoalsByType.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonMeasuresByType }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonMeasuresByType")
	public JAXBElement<ReadPersonMeasuresByType> createReadPersonMeasuresByType(
			ReadPersonMeasuresByType value) {
		return new JAXBElement<ReadPersonMeasuresByType>(
				_ReadPersonMeasuresByType_QNAME,
				ReadPersonMeasuresByType.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonGoalsByDateResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonGoalsByDateResponse")
	public JAXBElement<ReadPersonGoalsByDateResponse> createReadPersonGoalsByDateResponse(
			ReadPersonGoalsByDateResponse value) {
		return new JAXBElement<ReadPersonGoalsByDateResponse>(
				_ReadPersonGoalsByDateResponse_QNAME,
				ReadPersonGoalsByDateResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SavePersonMeasurement }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "savePersonMeasurement")
	public JAXBElement<SavePersonMeasurement> createSavePersonMeasurement(
			SavePersonMeasurement value) {
		return new JAXBElement<SavePersonMeasurement>(
				_SavePersonMeasurement_QNAME, SavePersonMeasurement.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonMeasuresByTypeAndDate }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonMeasuresByTypeAndDate")
	public JAXBElement<ReadPersonMeasuresByTypeAndDate> createReadPersonMeasuresByTypeAndDate(
			ReadPersonMeasuresByTypeAndDate value) {
		return new JAXBElement<ReadPersonMeasuresByTypeAndDate>(
				_ReadPersonMeasuresByTypeAndDate_QNAME,
				ReadPersonMeasuresByTypeAndDate.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonGoalsByTypeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonGoalsByTypeResponse")
	public JAXBElement<ReadPersonGoalsByTypeResponse> createReadPersonGoalsByTypeResponse(
			ReadPersonGoalsByTypeResponse value) {
		return new JAXBElement<ReadPersonGoalsByTypeResponse>(
				_ReadPersonGoalsByTypeResponse_QNAME,
				ReadPersonGoalsByTypeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonListResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonListResponse")
	public JAXBElement<ReadPersonListResponse> createReadPersonListResponse(
			ReadPersonListResponse value) {
		return new JAXBElement<ReadPersonListResponse>(
				_ReadPersonListResponse_QNAME, ReadPersonListResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadMeasureTypeListResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readMeasureTypeListResponse")
	public JAXBElement<ReadMeasureTypeListResponse> createReadMeasureTypeListResponse(
			ReadMeasureTypeListResponse value) {
		return new JAXBElement<ReadMeasureTypeListResponse>(
				_ReadMeasureTypeListResponse_QNAME,
				ReadMeasureTypeListResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonMeasuresByDateResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonMeasuresByDateResponse")
	public JAXBElement<ReadPersonMeasuresByDateResponse> createReadPersonMeasuresByDateResponse(
			ReadPersonMeasuresByDateResponse value) {
		return new JAXBElement<ReadPersonMeasuresByDateResponse>(
				_ReadPersonMeasuresByDateResponse_QNAME,
				ReadPersonMeasuresByDateResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SavePersonMeasurementResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "savePersonMeasurementResponse")
	public JAXBElement<SavePersonMeasurementResponse> createSavePersonMeasurementResponse(
			SavePersonMeasurementResponse value) {
		return new JAXBElement<SavePersonMeasurementResponse>(
				_SavePersonMeasurementResponse_QNAME,
				SavePersonMeasurementResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonGoalsByTypeAndDate }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonGoalsByTypeAndDate")
	public JAXBElement<ReadPersonGoalsByTypeAndDate> createReadPersonGoalsByTypeAndDate(
			ReadPersonGoalsByTypeAndDate value) {
		return new JAXBElement<ReadPersonGoalsByTypeAndDate>(
				_ReadPersonGoalsByTypeAndDate_QNAME,
				ReadPersonGoalsByTypeAndDate.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonGoalsByDate }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonGoalsByDate")
	public JAXBElement<ReadPersonGoalsByDate> createReadPersonGoalsByDate(
			ReadPersonGoalsByDate value) {
		return new JAXBElement<ReadPersonGoalsByDate>(
				_ReadPersonGoalsByDate_QNAME, ReadPersonGoalsByDate.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateMeasureTypeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "createMeasureTypeResponse")
	public JAXBElement<CreateMeasureTypeResponse> createCreateMeasureTypeResponse(
			CreateMeasureTypeResponse value) {
		return new JAXBElement<CreateMeasureTypeResponse>(
				_CreateMeasureTypeResponse_QNAME,
				CreateMeasureTypeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonGoals }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonGoals")
	public JAXBElement<ReadPersonGoals> createReadPersonGoals(
			ReadPersonGoals value) {
		return new JAXBElement<ReadPersonGoals>(_ReadPersonGoals_QNAME,
				ReadPersonGoals.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetRandomQuoteResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "getRandomQuoteResponse")
	public JAXBElement<GetRandomQuoteResponse> createGetRandomQuoteResponse(
			GetRandomQuoteResponse value) {
		return new JAXBElement<GetRandomQuoteResponse>(
				_GetRandomQuoteResponse_QNAME, GetRandomQuoteResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonGoalsByTypeAndDateResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonGoalsByTypeAndDateResponse")
	public JAXBElement<ReadPersonGoalsByTypeAndDateResponse> createReadPersonGoalsByTypeAndDateResponse(
			ReadPersonGoalsByTypeAndDateResponse value) {
		return new JAXBElement<ReadPersonGoalsByTypeAndDateResponse>(
				_ReadPersonGoalsByTypeAndDateResponse_QNAME,
				ReadPersonGoalsByTypeAndDateResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonMeasuresByTypeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonMeasuresByTypeResponse")
	public JAXBElement<ReadPersonMeasuresByTypeResponse> createReadPersonMeasuresByTypeResponse(
			ReadPersonMeasuresByTypeResponse value) {
		return new JAXBElement<ReadPersonMeasuresByTypeResponse>(
				_ReadPersonMeasuresByTypeResponse_QNAME,
				ReadPersonMeasuresByTypeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ReadPersonResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://soap/", name = "readPersonResponse")
	public JAXBElement<ReadPersonResponse> createReadPersonResponse(
			ReadPersonResponse value) {
		return new JAXBElement<ReadPersonResponse>(_ReadPersonResponse_QNAME,
				ReadPersonResponse.class, null, value);
	}

}
