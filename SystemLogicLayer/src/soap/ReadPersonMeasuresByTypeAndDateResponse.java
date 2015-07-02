package soap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for readPersonMeasuresByTypeAndDateResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonMeasuresByTypeAndDateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measuresByTypeAndDate" type="{http://soap/}measure" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonMeasuresByTypeAndDateResponse", propOrder = { "measuresByTypeAndDate" })
public class ReadPersonMeasuresByTypeAndDateResponse {

	protected List<Measure> measuresByTypeAndDate;

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
	 * Objects of the following type(s) are allowed in the list {@link Measure }
	 * 
	 * 
	 */
	public List<Measure> getMeasuresByTypeAndDate() {
		if (measuresByTypeAndDate == null) {
			measuresByTypeAndDate = new ArrayList<Measure>();
		}
		return this.measuresByTypeAndDate;
	}

}
