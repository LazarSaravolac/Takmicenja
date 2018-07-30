package jwd.wafepa.web.dto;

public class FormatDTO {
	private Long id;
	private String naziv;
	private Integer brojUcesnika;
	private Integer vrednostPobeda;
	private Integer vrednostNereseno;
	private Integer vrednostGubitak;
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
