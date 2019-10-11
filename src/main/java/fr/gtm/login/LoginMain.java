package fr.gtm.login;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.gtm.login.dao.LoginDAO;


public class LoginMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("login");
		LoginDAO dao = new LoginDAO(emf);
	
		System.out.println(dao.testConnexion("batman", "batmanpw"));

		emf.close();
	}

} 
