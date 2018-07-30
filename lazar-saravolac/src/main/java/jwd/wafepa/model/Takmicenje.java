package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Takmicenje {
	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	
	@OneToMany(mappedBy="takmicenje",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	List<Ucesnik>ucesnici=new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	Format format;
	
	
	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
		if(format!=null && !format.getTakmicenje().contains(this)){
			format.getTakmicenje().add(this);
		}
	}

	public Takmicenje(String naziv, List<Ucesnik> ucesnici) {
		super();
		this.naziv = naziv;
		this.ucesnici = ucesnici;
	}

	public Takmicenje() {
		super();
	}

	public Takmicenje(Long id, String naziv, List<Ucesnik> ucesnici) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.ucesnici = ucesnici;
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

	public List<Ucesnik> getUcesnici() {
		return ucesnici;
	}

	public void setUcesnici(List<Ucesnik> ucesnici) {
		this.ucesnici = ucesnici;
	}
	
	public void addUcesnik(Ucesnik ucesnik){
		this.ucesnici.add(ucesnik);
		
		if(!this.equals(ucesnik.getTakmicenje())){
			ucesnik.setTakmicenje(this);
		}
	}
	
}
