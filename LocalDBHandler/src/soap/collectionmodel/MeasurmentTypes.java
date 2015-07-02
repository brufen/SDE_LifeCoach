package soap.collectionmodel;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import rest.ehealth.model.MeasureType;

/**
 * @author Marija Grozdanic
 *
 */
@XmlRootElement(name = "measurmentTypes")
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasurmentTypes {
	@XmlElement(name = "measurmentType")
	private List<MeasureType> measurmentTypes = null;

	public List<MeasureType> getMeasurmentTypes() {
		return measurmentTypes;
	}

	public void setMeasurmentTypes(List<MeasureType> measurmentTypes) {
		this.measurmentTypes = measurmentTypes;
	}

}
