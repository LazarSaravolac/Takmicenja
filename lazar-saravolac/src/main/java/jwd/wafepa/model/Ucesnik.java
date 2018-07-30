package jwd.wafepa.model;

import javax.persistence.*;


@Entity
@Table
public class Ucesnik {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, unique=true)
	private String naziv;
	private String mesto;
	@Column(nullable=false)
	private String kontakt;
	private Integer odigranoSusreta;
	private Integer brojBodova;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Takmicenje takmicenje;

	
	
	public Ucesnik() {
		super();
	}

	public Ucesnik(String naziv, String mesto, String kontakt, Integer odigranoSusreta, Integer brojBodova) {
		super();
		this.naziv = naziv;
		this.mesto = mesto;
		this.kontakt = kontakt;
		this.odigranoSusreta = odigranoSusreta;
		this.brojBodova = brojBodova;
	}

	public Ucesnik(String naziv, String mesto, String kontakt, Integer odigranoSusreta, Integer brojBodova,
			Takmicenje takmicenje) {
		super();
		this.naziv = naziv;
		this.mesto = mesto;
		this.kontakt = kontakt;
		this.odigranoSusreta = odigranoSusreta;
		this.brojBodova = brojBodova;
		this.takmicenje = takmicenje;
	}

	public Ucesnik(Long id, String naziv, String mesto, String kontakt, Integer odigranoSusreta, Integer brojBodova,
			Takmicenje takmicenje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.mesto = mesto;
		this.kontakt = kontakt;
		this.odigranoSusreta = odigranoSusreta;
		this.brojBodova = brojBodova;
		this.takmicenje = takmicenje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public Integer getOdigranoSusreta() {
		return odigranoSusreta;
	}

	public void setOdigranoSusreta(Integer odigranoSusreta) {
		this.odigranoSusreta = odigranoSusreta;
	}

	public Integer getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(Integer brojBodova) {
		this.brojBodova = brojBodova;
	}

	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
		if(takmicenje!=null && !takmicenje.getUcesnici().contains(this)){
			takmicenje.getUcesnici().add(this);
		}
	}
	
	
	
}
