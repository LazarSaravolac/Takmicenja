package jwd.wafepa.web.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class UcesnikDTO {
	private Long id;
	@NotBlank
	@NotEmpty
	@Length(max=40)
	private String naziv;
	private String mesto;
	@Email
	private String kontakt;
	private Integer odigranoSusreta;
	private Integer brojBodova;
	
	
	private Long takmicenjeId;
	private String takmicenjeNaziv;
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
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	public Long getTakmicenjeId() {
		return takmicenjeId;
	}
	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}
	public String getTakmicenjeNaziv() {
		return takmicenjeNaziv;
	}
	public void setTakmicenjeNaziv(String takmicenjeNaziv) {
		this.takmicenjeNaziv = takmicenjeNaziv;
	}
	
}
