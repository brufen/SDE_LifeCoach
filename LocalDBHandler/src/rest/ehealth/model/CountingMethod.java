package rest.ehealth.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import rest.ehealth.dao.LifeCoachDao;

/**
 * The persistent class for the "CountingMethod" database table.
 * 
 */
/**
 * @author Marija Grozdanic
 *
 */
@Entity
@Table(name = "\"CountingMethod\"")
@NamedQuery(name = "CountingMethod.findAll", query = "SELECT c FROM CountingMethod c")
@XmlRootElement
public class CountingMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sqlite_countingmethod")
	@TableGenerator(name = "sqlite_countingmethod", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "CountingMethod")
	@Column(name = "\"countingMethodId\"", nullable = false)
	private int countingMethodId;

	@Column(name = "\"description\"")
	private String description;

	// bi-directional many-to-one association to MeasureType
	@XmlTransient
	@OneToMany(mappedBy = "countingMethod")
	private List<MeasureType> measureTypes;

	public CountingMethod() {
	}

	public int getCountingMethodId() {
		return this.countingMethodId;
	}

	public void setCountingMethodId(int countingMethodId) {
		this.countingMethodId = countingMethodId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public List<MeasureType> getMeasureTypes() {
		return this.measureTypes;
	}

	public void setMeasureTypes(List<MeasureType> measureTypes) {
		this.measureTypes = measureTypes;
	}

	public MeasureType addMeasureType(MeasureType measureType) {
		getMeasureTypes().add(measureType);
		measureType.setCountingMethod(this);

		return measureType;
	}

	public MeasureType removeMeasureType(MeasureType measureType) {
		getMeasureTypes().remove(measureType);
		measureType.setCountingMethod(null);

		return measureType;
	}

	public static CountingMethod getCountingMethodById(int personId) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		CountingMethod p = em.find(CountingMethod.class, personId);
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static List<CountingMethod> getAll() {

		System.out.println("--> Initializing Entity manager...");
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the people...");
		List<CountingMethod> list = em.createNamedQuery(
				"CountingMethod.findAll", CountingMethod.class).getResultList();
		System.out.println("--> Closing connections of entity manager...");
		LifeCoachDao.instance.closeConnections(em);
		return list;
	}

	public static CountingMethod saveCountingMethod(CountingMethod p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static CountingMethod updateCountingMethod(CountingMethod p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static void removeCountingMethod(CountingMethod p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		em.remove(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
	}

}