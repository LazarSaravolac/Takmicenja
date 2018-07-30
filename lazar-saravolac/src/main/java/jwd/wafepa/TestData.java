package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.model.Ucesnik;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.service.UcesnikService;

@Component
public class TestData {

	
	@Autowired
	private TakmicenjeService takmicenjeService;
	@Autowired
	private UcesnikService ucesnikService;
	
	@PostConstruct
	public void init() {
		Takmicenje t1=new Takmicenje();
		t1.setNaziv("Super liga");
		takmicenjeService.save(t1);
		
		Takmicenje t2=new Takmicenje();
		t2.setNaziv("Lav kup");
		takmicenjeService.save(t2);
		
		
		Ucesnik u1=new Ucesnik("Vosa","Novi Sad","vosa@gmail.com",3,4,t1);
		ucesnikService.save(u1);
		Ucesnik u2=new Ucesnik("Partizan", "Beograd", "Partizan@gmail.com", 3, 5,t2);
		ucesnikService.save(u2);
		Ucesnik u3=new Ucesnik("Radnicki","Nis","radnicki@gmail.com",3,2,t2);
		ucesnikService.save(u3);
		Ucesnik u4=new Ucesnik("Rad", "Beograd", "rad@gmail.com", 3, 1,t2);
		ucesnikService.save(u4);
		
		
		
		
		
		
	}
}
