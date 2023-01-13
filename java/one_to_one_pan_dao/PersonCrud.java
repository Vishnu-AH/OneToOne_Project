package one_to_one_pan_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_pan_dto.PanCard;
import one_to_one_pan_dto.Person;

public class PersonCrud {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void insertPerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = person.getPanCard();
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(panCard);
		entityTransaction.commit();
		System.out.println("Insertion successfull...!!");
	}
	public void updatePerson(String name , int id ) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		if(person!=null){
			person.setName(name);
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
			System.out.println("Updation successfull...!!");
		}else {
			System.out.println("Cannot update...!!");
			System.out.println("Enter valid data...!!");
		}
	}
	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		PanCard panCard = person.getPanCard();
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityManager.remove(panCard);
			entityTransaction.commit();
			System.out.println("Deletion successfull...!!");
		}
		else {
			System.out.println("No person available for given id");
		}
	}
	public void fetchPerson(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		System.out.println(person);
	}
	public void fetchAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Person p");
		List<Person> list = query.getResultList();
		System.out.println(list);
	}
}