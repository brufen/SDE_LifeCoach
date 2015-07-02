package rest.ehealth.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import rest.ehealth.dao.LifeCoachDao;

/**
 * The persistent class for the "measureType" database table.
 * 
 */
/**
 * @author Marija Grozdanic
 *
 */
@Entity
@Table(name = "\"measureType\"")
@NamedQuery(name = "MeasureType.findAll", query = "SELECT m FROM MeasureType m")
@XmlRootElement
public class MeasureType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "\"description\"")
	private String description;

	@Id
	@GeneratedValue(generator = "sqlite_measuretype")
	@TableGenerator(name = "sqlite_measuretype", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "measureType")
	@Column(name = "\"measureTypeId\"", nullable = false)
	private int measureTypeId;

	@Column(name = "\"unit\"")
	private String unit;

	// bi-directional many-to-one association to Goal
	@XmlTransient
	@OneToMany(mappedBy = "measureType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Goal> goals;

	// bi-directional many-to-one association to Measure
	@XmlTransient
	@OneToMany(mappedBy = "measureType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Measure> measures;

	// bi-directional many-to-one association to CountingMethod
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "countingMethodId")
	private CountingMethod countingMethod;

	public MeasureType() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMeasureTypeId() {
		return this.measureTypeId;
	}

	public void setMeasureTypeId(int measureTypeId) {
		this.measureTypeId = measureTypeId;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@XmlTransient
	public List<Goal> getGoals() {
		return this.goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public Goal addGoal(Goal goal) {
		getGoals().add(goal);
		goal.setMeasureType(this);

		return goal;
	}

	public Goal removeGoal(Goal goal) {
		getGoals().remove(goal);
		goal.setMeasureType(null);

		return goal;
	}

	@XmlTransient
	public List<Measure> getMeasures() {
		return this.measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

	public Measure addMeasure(Measure measure) {
		getMeasures().add(measure);
		measure.setMeasureType(this);

		return measure;
	}

	public Measure removeMeasure(Measure measure) {
		getMeasures().remove(measure);
		measure.setMeasureType(null);

		return measure;
	}

	public CountingMethod getCountingMethod() {
		return this.countingMethod;
	}

	public void setCountingMethod(CountingMethod countingMethod) {
		this.countingMethod = countingMethod;
	}

	public static MeasureType getMeasureTypeById(int personId) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		MeasureType p = em.find(MeasureType.class, personId);
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static List<MeasureType> getAll() {

		System.out.println("--> Initializing Entity manager...");
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the people...");
		List<MeasureType> list = em.createNamedQuery("MeasureType.findAll",
				MeasureType.class).getResultList();
		System.out.println("--> Closing connections of entity manager...");
		LifeCoachDao.instance.closeConnections(em);
		return list;
	}

	public static MeasureType saveMeasureType(MeasureType p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static MeasureType updateMeasureType(MeasureType p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static void removeMeasureType(MeasureType p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		em.remove(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
	}

}