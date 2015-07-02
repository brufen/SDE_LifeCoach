package soap.processcentricservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for registerMeasurmentResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="registerMeasurmentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registerMeasurment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerMeasurmentResponse", propOrder = { "registerMeasurment" })
public class RegisterMeasurmentResponse {

	protected String registerMeasurment;

	/**
	 * Gets the value of the registerMeasurment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRegisterMeasurment() {
		return registerMeasurment;
	}

	/**
	 * Sets the value of the registerMeasurment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRegisterMeasurment(String value) {
		this.registerMeasurment = value;
	}

}
