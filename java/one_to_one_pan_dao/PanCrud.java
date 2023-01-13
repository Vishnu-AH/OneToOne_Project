package one_to_one_pan_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_pan_dto.PanCard;
import one_to_one_pan_dto.Person;

public class PanCrud {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void insertPan(PanCard panCard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(panCard);
		entityTransaction.commit();
		System.out.println("Insertion successfull...!!");
	}
	public void updatePancard(int id , String name , String address ) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = entityManager.find(PanCard.class, id);
		if(panCard!=null){
			panCard.setPanName(name);
			panCard.setPanAddress(address);
			entityTransaction.begin();
			entityManager.merge(panCard);
			entityTransaction.commit();
			System.out.println("Updation successfull...!!");
		}else {
			System.out.println("Cannot update...!!");
			System.out.println("Enter valid data...!!");
		}
	}
	public void deletePancard(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = entityManager.find(PanCard.class, id);
		if(panCard!=null) {
			entityTransaction.begin();
			entityManager.remove(panCard);
			entityTransaction.commit();
			System.out.println("Deletion successfull...!!");
		}
		else {
			System.out.println("No Pancard available for given id");
		}
	}
	public void fetchPan(int id) {
		EntityManager entityManager = getEntityManager();
		PanCard panCard = entityManager.find(PanCard.class, id);
		System.out.println(panCard);
	}
	public void fetchAllPan() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from PanCard p");
		List<PanCard> list = query.getResultList();
		System.out.println(list);
	}
}