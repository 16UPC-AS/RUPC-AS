package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "recursos", uniqueConstraints = @UniqueConstraint(columnNames = { "nom" }))
public class Recurs {

	private Integer id;
	private String nom;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "user_seq_gen")
	@SequenceGenerator (name = "user_seq_gen", sequenceName = "recursos_id_sec")
	@Column(name = "id", unique = true, nullable = false)	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nom", nullable = false, length = 15)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
