package soap.processcentricservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getMeasurmentTypesResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getMeasurmentTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getMeasurmentTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMeasurmentTypesResponse", propOrder = { "getMeasurmentTypes" })
public class GetMeasurmentTypesResponse {

	protected String getMeasurmentTypes;

	/**
	 * Gets the value of the getMeasurmentTypes property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetMeasurmentTypes() {
		return getMeasurmentTypes;
	}

	/**
	 * Sets the value of the getMeasurmentTypes property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetMeasurmentTypes(String value) {
		this.getMeasurmentTypes = value;
	}

}
