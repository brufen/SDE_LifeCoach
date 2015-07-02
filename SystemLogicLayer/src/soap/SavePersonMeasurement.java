package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for savePersonMeasurement complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="savePersonMeasurement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="measure" type="{http://soap/}measure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "savePersonMeasurement", propOrder = { "personId", "measure" })
public class SavePersonMeasurement {

	protected int personId;
	protected Measure measure;

	/**
	 * Gets the value of the personId property.
	 * 
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * Sets the value of the personId property.
	 * 
	 */
	public void setPersonId(int value) {
		this.personId = value;
	}

	/**
	 * Gets the value of the measure property.
	 * 
	 * @return possible object is {@link Measure }
	 * 
	 */
	public Measure getMeasure() {
		return measure;
	}

	/**
	 * Sets the value of the measure property.
	 * 
	 * @param value
	 *            allowed object is {@link Measure }
	 * 
	 */
	public void setMeasure(Measure value) {
		this.measure = value;
	}

}
