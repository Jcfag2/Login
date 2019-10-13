package fr.gtm.login.dao;

import java.util.Arrays;
import java.util.List;

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
	
	public List<String> getRoleByNom(String nom) {
		EntityManager em = emf.createEntityManager();
		String roles2 = em.createNamedQuery("Role.all",String.class).setParameter("nom", nom).getSingleResult();
		String[] roles3 = roles2.split(",");
		List<String> roles = Arrays.asList(roles3);
		em.close();
		return roles;
	}

	
	public Utilisateur testConnexion(String nom,String motDePass) {
		EntityManager em = emf.createEntityManager();
		Utilisateur u = em.createNamedQuery("Utilisateur.testConnexion", Utilisateur.class).setParameter("nom", nom).setParameter("motDePass", motDePass).getSingleResult();

		return u;
		
	}

}
