package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignaturaspordocente;
import model.Docente;

public class ControladorAsignaturapordocente {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresymaterias");

	
	public static List<Asignaturaspordocente> profesorBusqueda(Docente doc) {
		
		int idDoc = doc.getId();

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * from asignaturaspordocente where idDocente = ?", Asignaturaspordocente.class);

		q.setParameter(1, idDoc);

		List<Asignaturaspordocente> muns = (List<Asignaturaspordocente>) q.getResultList();

		em.close();

		return muns;

	}
	
	public static List<Asignaturaspordocente> profesorNoBusqueda(Docente doc) {
		
		int idDoc = doc.getId();

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * from asignaturaspordocente where not idDocente = ?", Asignaturaspordocente.class);

		q.setParameter(1, idDoc);

		List<Asignaturaspordocente> muns = (List<Asignaturaspordocente>) q.getResultList();

		em.close();

		return muns;

	}
	
	public static void insertar(Asignaturaspordocente l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void eliminar(Asignaturaspordocente l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		l = em.merge(l);
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}
	

}
