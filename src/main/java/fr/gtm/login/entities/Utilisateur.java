package fr.gtm.login.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name = "Utilisateur.testConnexion", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom AND u.motDePass = :motDePass")
})
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "user")
	private String nom;
	@Column(name = "password")
	private String motDePass;
	@Column(name = "role")
	private String role;

	public Utilisateur() {
		
	}

	public Utilisateur(String nom, String motDePass) {
		super();
		this.nom = nom;
		this.motDePass = motDePass;
	}

	
	
	public Utilisateur(String id, String nom, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", role=" + role + "]";
	}

	public Utilisateur(String id, String nom, String motDePass, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.motDePass = motDePass;
		this.role = role;
	}

	
	
}
