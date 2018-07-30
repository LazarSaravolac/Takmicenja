package jwd.wafepa.support;


import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Ucesnik;
import jwd.wafepa.web.dto.UcesnikDTO;

@Component
public class UcesnikToUcesnikDTO implements Converter<Ucesnik,UcesnikDTO> {

	
	
	
	@Override
	public UcesnikDTO convert(Ucesnik ucesnik) {
		
		UcesnikDTO dto=new UcesnikDTO();
		
		dto.setBrojBodova(ucesnik.getBrojBodova());
		dto.setId(ucesnik.getId());
		dto.setKontakt(ucesnik.getKontakt());
		dto.setMesto(ucesnik.getMesto());
		dto.setNaziv(ucesnik.getNaziv());
		dto.setOdigranoSusreta(ucesnik.getOdigranoSusreta());
		dto.setTakmicenjeId(ucesnik.getTakmicenje().getId());
		dto.setTakmicenjeNaziv(ucesnik.getTakmicenje().getNaziv());
		return dto;
	}
	
	public List<UcesnikDTO>convert(List<Ucesnik>u){
		List<UcesnikDTO>dto=new ArrayList<>();
		for(Ucesnik a:u) {
			dto.add(convert(a));
		}
		return dto;
	}

}
