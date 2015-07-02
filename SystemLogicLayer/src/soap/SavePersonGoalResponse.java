package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for savePersonGoalResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="savePersonGoalResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="savePersonMeasurment" type="{http://soap/}goal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "savePersonGoalResponse", propOrder = { "savePersonMeasurment" })
public class SavePersonGoalResponse {

	protected Goal savePersonMeasurment;

	/**
	 * Gets the value of the savePersonMeasurment property.
	 * 
	 * @return possible object is {@link Goal }
	 * 
	 */
	public Goal getSavePersonMeasurment() {
		return savePersonMeasurment;
	}

	/**
	 * Sets the value of the savePersonMeasurment property.
	 * 
	 * @param value
	 *            allowed object is {@link Goal }
	 * 
	 */
	public void setSavePersonMeasurment(Goal value) {
		this.savePersonMeasurment = value;
	}

}
