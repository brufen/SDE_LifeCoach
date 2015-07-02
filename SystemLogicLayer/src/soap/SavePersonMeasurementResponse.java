package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for savePersonMeasurementResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="savePersonMeasurementResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="savePersonMeasurment" type="{http://soap/}measure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "savePersonMeasurementResponse", propOrder = { "savePersonMeasurment" })
public class SavePersonMeasurementResponse {

	protected Measure savePersonMeasurment;

	/**
	 * Gets the value of the savePersonMeasurment property.
	 * 
	 * @return possible object is {@link Measure }
	 * 
	 */
	public Measure getSavePersonMeasurment() {
		return savePersonMeasurment;
	}

	/**
	 * Sets the value of the savePersonMeasurment property.
	 * 
	 * @param value
	 *            allowed object is {@link Measure }
	 * 
	 */
	public void setSavePersonMeasurment(Measure value) {
		this.savePersonMeasurment = value;
	}

}
