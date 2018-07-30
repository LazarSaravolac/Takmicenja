package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDTO implements Converter<Takmicenje, TakmicenjeDTO>{

	@Override
	public TakmicenjeDTO convert(Takmicenje takmicenje) {
		// TODO Auto-generated method stub
		TakmicenjeDTO dto=new TakmicenjeDTO();
		dto.setId(takmicenje.getId());
		dto.setNaziv(takmicenje.getNaziv());
		return dto;
	}

	public List<TakmicenjeDTO>convert(List<Takmicenje>t){
		List<TakmicenjeDTO>dto=new ArrayList<>();
		for(Takmicenje a:t) {
			dto.add(convert(a));
		}
		return dto;
	}
}
