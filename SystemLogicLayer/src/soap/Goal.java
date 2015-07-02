package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for goal complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="goal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enddate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goalId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="measureType" type="{http://soap/}measureType" minOccurs="0"/>
 *         &lt;element name="moreOrLess" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="term" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="termIsSolid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "goal", propOrder = { "date", "enddate", "goalId",
		"measureType", "moreOrLess", "term", "termIsSolid", "value" })
public class Goal {

	protected String date;
	protected String enddate;
	protected int goalId;
	protected MeasureType measureType;
	protected int moreOrLess;
	protected int term;
	protected int termIsSolid;
	protected double value;

	/**
	 * Gets the value of the date property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the value of the date property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDate(String value) {
		this.date = value;
	}

	/**
	 * Gets the value of the enddate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * Sets the value of the enddate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEnddate(String value) {
		this.enddate = value;
	}

	/**
	 * Gets the value of the goalId property.
	 * 
	 */
	public int getGoalId() {
		return goalId;
	}

	/**
	 * Sets the value of the goalId property.
	 * 
	 */
	public void setGoalId(int value) {
		this.goalId = value;
	}

	/**
	 * Gets the value of the measureType property.
	 * 
	 * @return possible object is {@link MeasureType }
	 * 
	 */
	public MeasureType getMeasureType() {
		return measureType;
	}

	/**
	 * Sets the value of the measureType property.
	 * 
	 * @param value
	 *            allowed object is {@link MeasureType }
	 * 
	 */
	public void setMeasureType(MeasureType value) {
		this.measureType = value;
	}

	/**
	 * Gets the value of the moreOrLess property.
	 * 
	 */
	public int getMoreOrLess() {
		return moreOrLess;
	}

	/**
	 * Sets the value of the moreOrLess property.
	 * 
	 */
	public void setMoreOrLess(int value) {
		this.moreOrLess = value;
	}

	/**
	 * Gets the value of the term property.
	 * 
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * Sets the value of the term property.
	 * 
	 */
	public void setTerm(int value) {
		this.term = value;
	}

	/**
	 * Gets the value of the termIsSolid property.
	 * 
	 */
	public int getTermIsSolid() {
		return termIsSolid;
	}

	/**
	 * Sets the value of the termIsSolid property.
	 * 
	 */
	public void setTermIsSolid(int value) {
		this.termIsSolid = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 */
	public void setValue(double value) {
		this.value = value;
	}

}
