package rest.ehealth.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import rest.ehealth.dao.LifeCoachDao;

/**
 * The persistent class for the "Goal" database table.
 * 
 */
/**
 * @author Marija Grozdanic
 *
 */
@Entity
@Table(name = "\"Goal\"")
@NamedQuery(name = "Goal.findAll", query = "SELECT g FROM Goal g")
@XmlRootElement
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "\"date\"")
	private String date;
	@Id
	@GeneratedValue(generator = "sqlite_goal")
	@TableGenerator(name = "sqlite_goal", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "Goal")
	@Column(name = "\"goalId\"", nullable = false)
	private int goalId;

	@Column(name = "\"moreOrLess\"")
	private int moreOrLess;

	@Column(name = "\"term\"")
	private int term;

	@Column(name = "\"value\"")
	private double value;

	@Column(name = "\"termIsSolid\"")
	private int termIsSolid;

	@Column(name = "\"enddate\"")
	private String enddate;

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getTermIsSolid() {
		return termIsSolid;
	}

	public void setTermIsSolid(int termIsSolid) {
		this.termIsSolid = termIsSolid;
	}

	// bi-directional many-to-one association to Person
	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "personId")
	private Person person;

	// bi-directional many-to-one association to MeasureType
	@ManyToOne
	@JoinColumn(name = "measureTypeId")
	private MeasureType measureType;

	public Goal() {
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getGoalId() {
		return this.goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public int getMoreOrLess() {
		return this.moreOrLess;
	}

	public void setMoreOrLess(int moreOrLess) {
		this.moreOrLess = moreOrLess;
	}

	public int getTerm() {
		return this.term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@XmlTransient
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public MeasureType getMeasureType() {
		return this.measureType;
	}

	public void setMeasureType(MeasureType measureType) {
		this.measureType = measureType;
	}

	public static Goal getGoalById(int personId) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		Goal p = em.find(Goal.class, personId);
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static List<Goal> getAll() {

		System.out.println("--> Initializing Entity manager...");
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the people...");
		List<Goal> list = em.createNamedQuery("Goal.findAll", Goal.class)
				.getResultList();
		System.out.println("--> Closing connections of entity manager...");
		LifeCoachDao.instance.closeConnections(em);
		return list;
	}

	public static Goal saveGoal(Goal p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static Goal updateGoal(Goal p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static void removeGoal(Goal p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		em.remove(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
	}

}