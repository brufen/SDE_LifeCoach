package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for readPersonMeasuresByDate complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonMeasuresByDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="before" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="after" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonMeasuresByDate", propOrder = { "personId", "before",
		"after" })
public class ReadPersonMeasuresByDate {

	protected int personId;
	protected String before;
	protected String after;

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
	 * Gets the value of the before property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBefore() {
		return before;
	}

	/**
	 * Sets the value of the before property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBefore(String value) {
		this.before = value;
	}

	/**
	 * Gets the value of the after property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAfter() {
		return after;
	}

	/**
	 * Sets the value of the after property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAfter(String value) {
		this.after = value;
	}

}
