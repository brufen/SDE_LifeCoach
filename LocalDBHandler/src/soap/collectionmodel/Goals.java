package soap.collectionmodel;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import rest.ehealth.model.Goal;

/**
 * @author Marija Grozdanic
 *
 */
@XmlRootElement(name = "goals")
@XmlAccessorType(XmlAccessType.FIELD)
public class Goals {
	@XmlElement(name = "goal")
	private List<Goal> goals = null;

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

}
