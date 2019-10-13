package fr.gtm.login;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.gtm.login.dao.LoginDAO;


public class LoginMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("login");
		LoginDAO dao = new LoginDAO(emf);
	
		System.out.println(dao.testConnexion("batman", "batmanpw"));
		List<String> roles = dao.getRoleByNom("batman");
		roles.forEach(System.out::println);
		emf.close();
	}

} 
