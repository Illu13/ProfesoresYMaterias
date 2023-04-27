package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;


public class ControladorAsignatura {
	
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresymaterias");

	public static List<Asignatura> findAll() {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM asignatura order by id;", Asignatura.class);

		List<Asignatura> locs = (List<Asignatura>) q.getResultList();

		em.close();

		return locs;

	}
	
	public static Asignatura findById(int idM) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM asignatura where id = ?;", Asignatura.class);
		
		q.setParameter(1, idM);

		Asignatura locs =  (Asignatura) q.getSingleResult();

		em.close();

		return locs;

	}

}
