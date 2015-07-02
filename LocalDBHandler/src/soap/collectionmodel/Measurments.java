package soap.collectionmodel;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import rest.ehealth.model.Measure;

/**
 * @author Marija Grozdanic
 *
 */
@XmlRootElement(name = "measurments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Measurments {
	@XmlElement(name = "measurment")
	private List<Measure> measurments = null;

	public List<Measure> getMeasurments() {
		return measurments;
	}

	public void setMeasurments(List<Measure> measurments) {
		this.measurments = measurments;
	}

}
