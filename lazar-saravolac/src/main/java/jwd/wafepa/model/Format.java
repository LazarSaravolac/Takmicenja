package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Format {

	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	private Integer brojUcesnika;
	private Integer vrednostPobeda;
	private Integer vrednostNereseno;
	private Integer vrednostGubitak;
	
	@OneToMany(mappedBy="format",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	List<Takmicenje>takmicenje=new ArrayList<>();
	

	public List<Takmicenje> getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(List<Takmicenje> takmicenje) {
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

	public Integer getBrojUcesnika() {
		return brojUcesnika;
	}

	public void setBrojUcesnika(Integer brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}

	public Integer getVrednostPobeda() {
		return vrednostPobeda;
	}

	public void setVrednostPobeda(Integer vrednostPobeda) {
		this.vrednostPobeda = vrednostPobeda;
	}

	public Integer getVrednostNereseno() {
		return vrednostNereseno;
	}

	public void setVrednostNereseno(Integer vrednostNereseno) {
		this.vrednostNereseno = vrednostNereseno;
	}

	public Integer getVrednostGubitak() {
		return vrednostGubitak;
	}

	public void setVrednostGubitak(Integer vrednostGubitak) {
		this.vrednostGubitak = vrednostGubitak;
	}

	

	
	
	
}
