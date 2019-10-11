package fr.gtm.login.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.gtm.login.entities.Utilisateur;

public class LoginDAO {
	private EntityManagerFactory emf;

	public LoginDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	
	public void create(Utilisateur utilisateur) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(utilisateur);

		em.getTransaction().commit();
		em.close();
	}
	
	public Utilisateur getUtilisateurByNom(String nom) {
		EntityManager em = emf.createEntityManager();
		Utilisateur utilisateur = em.find(Utilisateur.class, nom);
		em.close();
		return utilisateur;
	}

	
	public Utilisateur testConnexion(String nom,String motDePass) {
		EntityManager em = emf.createEntityManager();
		Utilisateur u = em.createNamedQuery("Utilisateur.testConnexion", Utilisateur.class).setParameter("nom", nom).setParameter("motDePass", motDePass).getSingleResult();

		return u;
		
	}

}
