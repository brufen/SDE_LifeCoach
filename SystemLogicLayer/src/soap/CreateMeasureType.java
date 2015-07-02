package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for createMeasureType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="createMeasureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createMeasureType" type="{http://soap/}measureType" minOccurs="0"/>
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
@XmlType(name = "createMeasureType", propOrder = { "createMeasureType" })
public class CreateMeasureType {

	protected MeasureType createMeasureType;

	/**
	 * Gets the value of the createMeasureType property.
	 * 
	 * @return possible object is {@link MeasureType }
	 * 
	 */
	public MeasureType getCreateMeasureType() {
		return createMeasureType;
	}

	/**
	 * Sets the value of the createMeasureType property.
	 * 
	 * @param value
	 *            allowed object is {@link MeasureType }
	 * 
	 */
	public void setCreateMeasureType(MeasureType value) {
		this.createMeasureType = value;
	}

}
