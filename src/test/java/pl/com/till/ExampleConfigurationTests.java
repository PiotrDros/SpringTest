package pl.com.till;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import pl.com.till.domain.Person;
import pl.com.till.domain.PersonDao;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
public class ExampleConfigurationTests {

	@Autowired
	private Service service;

	@Autowired
	PersonDao dao;

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testSimpleProperties() throws Exception {
		assertNotNull(service);

//		dao.deleteAll();

		Person person = new Person();
		person.setFirstName("Till");
		person.setLastName("Links");

		Assert.assertNull(person.getPersonId());

		List<Person> persons = dao.getAll();
		Assert.assertEquals(0, persons.size());

		dao.merge(person);

		// person = em.merge(person);
		// em.clear();

		// Assert.assertNotNull(person.getPersonId());

		persons = dao.getAll();
		Assert.assertEquals(1, persons.size());

		// List resultList =
		// em.createQuery("FROM Person p WHERE  p.lastName REGEXP '^Lin'").getResultList();

		// System.out.println(persons);

	}

}
