package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for savePersonGoal complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="savePersonGoal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="goal" type="{http://soap/}goal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "savePersonGoal", propOrder = { "personId", "goal" })
public class SavePersonGoal {

	protected int personId;
	protected Goal goal;

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
	 * Gets the value of the goal property.
	 * 
	 * @return possible object is {@link Goal }
	 * 
	 */
	public Goal getGoal() {
		return goal;
	}

	/**
	 * Sets the value of the goal property.
	 * 
	 * @param value
	 *            allowed object is {@link Goal }
	 * 
	 */
	public void setGoal(Goal value) {
		this.goal = value;
	}

}
