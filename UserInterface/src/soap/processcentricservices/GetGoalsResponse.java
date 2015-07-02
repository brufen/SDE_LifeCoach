package soap.processcentricservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getGoalsResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getGoalsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goals" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGoalsResponse", propOrder = { "goals" })
public class GetGoalsResponse {

	protected String goals;

	/**
	 * Gets the value of the goals property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGoals() {
		return goals;
	}

	/**
	 * Sets the value of the goals property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGoals(String value) {
		this.goals = value;
	}

}
