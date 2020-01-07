package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		// Persist�ncia

//		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
//		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
//
//		try {
//			em.getTransaction().begin();
//			em.persist(p1);
//			em.persist(p2);
//			em.persist(p3);
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			System.out.println(e.getMessage());
//		} finally {
//			em.close();
//			emf.close();
//		}
//
//		System.out.println("Transa��o conclu�da.");

		// Consulta

//		Pessoa p = em.find(Pessoa.class, 1);
//		System.out.println(p);
//		em.close();
//		emf.close();

		// Dele��o

		try {
			Pessoa p = em.find(Pessoa.class, 1);
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
			emf.close();
		}

	}

}
