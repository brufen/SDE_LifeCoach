package soap.processcentricservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getProgressInfoResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getProgressInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getProgressInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProgressInfoResponse", propOrder = { "getProgressInfo" })
public class GetProgressInfoResponse {

	protected String getProgressInfo;

	/**
	 * Gets the value of the getProgressInfo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetProgressInfo() {
		return getProgressInfo;
	}

	/**
	 * Sets the value of the getProgressInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetProgressInfo(String value) {
		this.getProgressInfo = value;
	}

}
