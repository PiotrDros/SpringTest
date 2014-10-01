package pl.com.till.client;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.com.till.domain.Person;
import pl.com.till.domain.PersonDao;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring/app-context.xml");

		PersonDao dao = context.getBean(PersonDao.class);
		
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			Person person = new Person();
			int nextInt = rand.nextInt();
			person.setFirstName("Jan" + nextInt);
			person.setLastName("Kowalski" + nextInt);
			dao.persist(person);
			
		}

		
		
		List<Person> all = dao.getAll();
		
		System.out.println(all);
		

	}

}
