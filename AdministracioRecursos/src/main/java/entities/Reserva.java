package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "reserves", uniqueConstraints = @UniqueConstraint(columnNames = { "recurs", "data", "horainici" }))
public class Reserva implements Serializable {

	private Long id;
	private Recurs recurs;
	private Usuari usuari;
	private Date data;
	private Integer horaInici;
	private Integer horaFi;
	private String comentari;
	private Boolean esAmbNotificacio;
	private Set<Usuari> usuaris = new HashSet<Usuari>();

	public Reserva(Recurs recurs, Usuari usuari, Date data, Integer horaInici, Integer horaFi, String comentari,
			Boolean esAmbNotificacio) {
		super();
		this.recurs = recurs;
		this.usuari = usuari;
		this.data = data;
		this.horaInici = horaInici;
		this.horaFi = horaFi;
		this.comentari = comentari;
		this.esAmbNotificacio = esAmbNotificacio;
		if (this.esAmbNotificacio)
			usuaris.add(usuari);
	}

	public Reserva() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
	@SequenceGenerator(name = "user_seq_gen", sequenceName = "reserves_id_sec")
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "recurs", referencedColumnName = "nom", nullable = false)
	public Recurs getRecurs() {
		return recurs;
	}

	public void setRecurs(Recurs recurs) {
		this.recurs = recurs;
	}

	@ManyToOne
	@JoinColumn(name = "usuari", referencedColumnName = "username", nullable = false)
	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "horainici", nullable = false)
	public Integer getHoraInici() {
		return horaInici;
	}

	public void setHoraInici(Integer horaInici) {
		this.horaInici = horaInici;
	}

	@Column(name = "horafi", nullable = false)
	public Integer getHoraFi() {
		return horaFi;
	}

	public void setHoraFi(Integer horaFi) {
		this.horaFi = horaFi;
	}

	@Column(name = "comentari", nullable = true, length = 100)
	public String getComentari() {
		return comentari;
	}

	public void setComentari(String comentari) {
		this.comentari = comentari;
	}

	@Column(name = "esambnotificacio", length = 1)
	public Boolean getEsAmbNotificacio() {
		return esAmbNotificacio;
	}

	public void setEsAmbNotificacio(Boolean esAmbNotificacio) {
		this.esAmbNotificacio = esAmbNotificacio;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "esnotifica", joinColumns = {
			@JoinColumn(name = "reserva", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "usuari", nullable = false, updatable = false) })
	public Set<Usuari> getUsuaris() {
		return usuaris;
	}

	public void setUsuaris(Set<Usuari> usuaris) {
		this.usuaris = usuaris;
	}

	@Transient
	public Object[] getUniqueConstraint() {
		return new Object[] { getRecurs(), getData(), getHoraInici() };
	}

	@Transient
	public boolean esDisponible(Date d, Integer hi, Integer hf) {
		return (!data.equals(d)) || (hi >= horaFi || hf <= horaInici);
	}

	@Transient
	public ArrayList<String> getInfoPerServei() {
		// TODO Auto-generated method stub
		ArrayList<String> i = new ArrayList<String>();
		ArrayList<String> mails = new ArrayList<String>();
		for (Usuari u : usuaris)
			mails.add(u.getMail());
		String nr = getRecurs().getNom();
		String nu = getUsuari().getUsername();
		i.add(nr);
		i.add(getData().toString());
		i.add(getHoraInici().toString());
		i.add(getHoraFi().toString());
		i.add(nu);
		i.add(getComentari());
		i.addAll(mails);
		return i;
	}

	public boolean recursEtsSala() {
		return getRecurs().etsSala();
	}

	public String getNomRecurs() {
		return getRecurs().getNom();
	}

}
