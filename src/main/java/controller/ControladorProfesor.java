package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Docente;


public class ControladorProfesor {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresymaterias");

	
	public static List<Docente> profesorBusqueda(String nombre) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM docente where nombrecompleto like ? order by nombrecompleto", Docente.class);

		q.setParameter(1, "%" + nombre + "%");

		List<Docente> muns = (List<Docente>) q.getResultList();

		em.close();

		return muns;

	}
	

}
