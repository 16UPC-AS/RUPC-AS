package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuaris", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class Usuari{

	private Long id;
	private String username;
	private String nom;
	private String mail;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "user_seq_gen")
	@SequenceGenerator (name = "user_seq_gen", sequenceName = "usuaris_id_sec")
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "nom", nullable = false, length = 20)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "mail", nullable = false, length = 40)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Transient
	public Object[] getUniqueConstraint()
	{
		return new Object[]{this.getUsername()};
	}
}
