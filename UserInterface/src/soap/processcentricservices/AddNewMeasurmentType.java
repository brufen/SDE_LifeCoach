package soap.processcentricservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for addNewMeasurmentType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="addNewMeasurmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measurmentDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNewMeasurmentType", propOrder = { "measurmentDescription" })
public class AddNewMeasurmentType {

	protected String measurmentDescription;

	/**
	 * Gets the value of the measurmentDescription property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMeasurmentDescription() {
		return measurmentDescription;
	}

	/**
	 * Sets the value of the measurmentDescription property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMeasurmentDescription(String value) {
		this.measurmentDescription = value;
	}

}
