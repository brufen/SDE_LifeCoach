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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import rest.ehealth.dao.LifeCoachDao;

/**
 * The persistent class for the "Person" database table.
 * 
 */
/**
 * @author Marija Grozdanic
 *
 */
@Entity
@Table(name = "\"Person\"")
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
@XmlRootElement
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "\"name\"")
	private String name;

	@Id
	@GeneratedValue(generator = "sqlite_person")
	@TableGenerator(name = "sqlite_person", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "Person")
	@Column(name = "\"personId\"", nullable = false)
	private int personId;

	@Column(name = "\"surname\"")
	private String surname;

	// bi-directional many-to-one association to Goal
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Goal> goals;

	// bi-directional many-to-one association to Measure
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Measure> measures;

	public Person() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Goal> getGoals() {
		return this.goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public Goal addGoal(Goal goal) {
		getGoals().add(goal);
		goal.setPerson(this);

		return goal;
	}

	public Goal removeGoal(Goal goal) {
		getGoals().remove(goal);
		goal.setPerson(null);

		return goal;
	}

	public List<Measure> getMeasures() {
		return this.measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

	public Measure addMeasure(Measure measure) {
		getMeasures().add(measure);
		measure.setPerson(this);

		return measure;
	}

	public Measure removeMeasure(Measure measure) {
		getMeasures().remove(measure);
		measure.setPerson(null);

		return measure;
	}

	public static Person getPersonById(int personId) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		Person p = em.find(Person.class, personId);
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static List<Person> getAll() {

		System.out.println("--> Initializing Entity manager...");
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		System.out.println("--> Querying the database for all the people...");
		List<Person> list = em.createNamedQuery("Person.findAll", Person.class)
				.getResultList();
		System.out.println("--> Closing connections of entity manager...");
		LifeCoachDao.instance.closeConnections(em);
		return list;
	}

	public static Person savePerson(Person p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static Person updatePerson(Person p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return p;
	}

	public static void removePerson(Person p) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p = em.merge(p);
		em.remove(p);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
	}

}