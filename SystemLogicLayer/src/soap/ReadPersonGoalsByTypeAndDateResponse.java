package soap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for readPersonGoalsByTypeAndDateResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonGoalsByTypeAndDateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measuresByTypeAndDate" type="{http://soap/}goal" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonGoalsByTypeAndDateResponse", propOrder = { "measuresByTypeAndDate" })
public class ReadPersonGoalsByTypeAndDateResponse {

	protected List<Goal> measuresByTypeAndDate;

	/**
	 * Gets the value of the measuresByTypeAndDate property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the measuresByTypeAndDate property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMeasuresByTypeAndDate().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Goal }
	 * 
	 * 
	 */
	public List<Goal> getMeasuresByTypeAndDate() {
		if (measuresByTypeAndDate == null) {
			measuresByTypeAndDate = new ArrayList<Goal>();
		}
		return this.measuresByTypeAndDate;
	}

}
