package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuaris", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }) )
public class Usuari {

	private Long id;
	private String username;
	private String nom;
	private String mail;
	private Set<Reserva> reserves = new HashSet<Reserva>();

	public Usuari(String username, String nom, String mail) {
		super();
		this.username = username;
		this.nom = nom;
		this.mail = mail;
	}

	public Usuari() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
	@SequenceGenerator(name = "user_seq_gen", sequenceName = "usuaris_id_sec")
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

	@ManyToMany(mappedBy = "usuaris", targetEntity = Reserva.class)
	public Set<Reserva> getReserves() {
		return reserves;
	}

	public void setReserves(Set<Reserva> reserves) {
		this.reserves = reserves;
	}

	@Transient
	public Object[] getUniqueConstraint() {
		return new Object[] { this.getUsername() };
	}
}
