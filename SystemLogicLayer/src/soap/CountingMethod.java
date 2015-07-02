package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for countingMethod complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="countingMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countingMethodId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/**
 * @author Marija Grozdanic
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countingMethod", propOrder = { "countingMethodId",
		"description" })
public class CountingMethod {

	protected int countingMethodId;
	protected String description;

	/**
	 * Gets the value of the countingMethodId property.
	 * 
	 */
	public int getCountingMethodId() {
		return countingMethodId;
	}

	/**
	 * Sets the value of the countingMethodId property.
	 * 
	 */
	public void setCountingMethodId(int value) {
		this.countingMethodId = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

}
