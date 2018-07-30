package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Ucesnik;
import jwd.wafepa.repository.UcesnikRepository;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.service.UcesnikService;
import jwd.wafepa.web.dto.UcesnikDTO;

@Component
public class UcesnikDTOtoUcesnik implements Converter<UcesnikDTO, Ucesnik> {

	@Autowired
	UcesnikService ucesnikService;
	
	@Autowired
	TakmicenjeService takmicenjeService;
	
	@Override
	public Ucesnik convert(UcesnikDTO dto) {
		// TODO Auto-generated method stub
		Ucesnik ucesnik;
		if(dto.getId()==null) {
			ucesnik=new Ucesnik();
			ucesnik.setTakmicenje(takmicenjeService.findOne(dto.getTakmicenjeId()));
		}else {
			ucesnik=ucesnikService.findOne(dto.getId());
		}
		
		ucesnik.setBrojBodova(dto.getBrojBodova());
		ucesnik.setId(dto.getId());
		ucesnik.setKontakt(dto.getKontakt());
		ucesnik.setMesto(dto.getMesto());
		ucesnik.setNaziv(dto.getNaziv());
		ucesnik.setOdigranoSusreta(dto.getOdigranoSusreta());
		
		return ucesnik;
	}

	
	public List<Ucesnik>convert(List<UcesnikDTO>dto){
		List<Ucesnik>ucesnici=new ArrayList<>();
		for(UcesnikDTO a:dto) {
			ucesnici.add(convert(a));
		}
		return ucesnici;
	}
	
}
