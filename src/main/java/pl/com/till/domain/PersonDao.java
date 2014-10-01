package pl.com.till.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Person person) {
		em.persist(person);
	}
	
	
	public List<Person>getAll() {
		return em.createQuery("from Person").getResultList();
	 }
	
	@Transactional
	public void deleteAll() {
		 em.createQuery("delete from Person").executeUpdate();
	 }
	
	
	@Transactional
	public void merge(Person person) {
		 em.merge(person);
	 }
}
