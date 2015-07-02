package soap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for person complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goals" type="{http://soap/}goal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="measures" type="{http://soap/}measure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = { "goals", "measures", "name",
		"personId", "surname" })
public class Person {

	@XmlElement(nillable = true)
	protected List<Goal> goals;
	@XmlElement(nillable = true)
	protected List<Measure> measures;
	protected String name;
	protected int personId;
	protected String surname;

	/**
	 * Gets the value of the goals property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the goals property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getGoals().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Goal }
	 * 
	 * 
	 */
	public List<Goal> getGoals() {
		if (goals == null) {
			goals = new ArrayList<Goal>();
		}
		return this.goals;
	}

	/**
	 * Gets the value of the measures property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the measures property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMeasures().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Measure }
	 * 
	 * 
	 */
	public List<Measure> getMeasures() {
		if (measures == null) {
			measures = new ArrayList<Measure>();
		}
		return this.measures;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

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
	 * Gets the value of the surname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the value of the surname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSurname(String value) {
		this.surname = value;
	}

}
