package soap.processcentricservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getMeasuresResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getMeasuresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getMeasures" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMeasuresResponse", propOrder = { "getMeasures" })
public class GetMeasuresResponse {

	protected String getMeasures;

	/**
	 * Gets the value of the getMeasures property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetMeasures() {
		return getMeasures;
	}

	/**
	 * Sets the value of the getMeasures property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetMeasures(String value) {
		this.getMeasures = value;
	}

}
