package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for measureType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="measureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countingMethod" type="{http://soap/}countingMethod" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="measureTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measureType", propOrder = { "countingMethod", "description",
		"measureTypeId", "unit" })
public class MeasureType {

	protected CountingMethod countingMethod;
	protected String description;
	protected int measureTypeId;
	protected String unit;

	/**
	 * Gets the value of the countingMethod property.
	 * 
	 * @return possible object is {@link CountingMethod }
	 * 
	 */
	public CountingMethod getCountingMethod() {
		return countingMethod;
	}

	/**
	 * Sets the value of the countingMethod property.
	 * 
	 * @param value
	 *            allowed object is {@link CountingMethod }
	 * 
	 */
	public void setCountingMethod(CountingMethod value) {
		this.countingMethod = value;
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

	/**
	 * Gets the value of the measureTypeId property.
	 * 
	 */
	public int getMeasureTypeId() {
		return measureTypeId;
	}

	/**
	 * Sets the value of the measureTypeId property.
	 * 
	 */
	public void setMeasureTypeId(int value) {
		this.measureTypeId = value;
	}

	/**
	 * Gets the value of the unit property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Sets the value of the unit property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUnit(String value) {
		this.unit = value;
	}

}
