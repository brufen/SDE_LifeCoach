package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for measure complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="measure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="measureId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="measureType" type="{http://soap/}measureType" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measure", propOrder = { "date", "measureId", "measureType",
		"value" })
public class Measure {

	protected String date;
	protected int measureId;
	protected MeasureType measureType;
	protected double value;

	/**
	 * Gets the value of the date property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the value of the date property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDate(String value) {
		this.date = value;
	}

	/**
	 * Gets the value of the measureId property.
	 * 
	 */
	public int getMeasureId() {
		return measureId;
	}

	/**
	 * Sets the value of the measureId property.
	 * 
	 */
	public void setMeasureId(int value) {
		this.measureId = value;
	}

	/**
	 * Gets the value of the measureType property.
	 * 
	 * @return possible object is {@link MeasureType }
	 * 
	 */
	public MeasureType getMeasureType() {
		return measureType;
	}

	/**
	 * Sets the value of the measureType property.
	 * 
	 * @param value
	 *            allowed object is {@link MeasureType }
	 * 
	 */
	public void setMeasureType(MeasureType value) {
		this.measureType = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 */
	public void setValue(double value) {
		this.value = value;
	}

}
