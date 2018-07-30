package jwd.wafepa.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Format;
import jwd.wafepa.web.dto.FormatDTO;

@Component
public class FormatToFormatDTO implements Converter<Format, FormatDTO>{

	@Override
	public FormatDTO convert(Format format) {
		// TODO Auto-generated method stub
		FormatDTO dto=new FormatDTO();
		dto.setBrojUcesnika(format.getBrojUcesnika());
		dto.setId(format.getId());
		dto.setNaziv(format.getNaziv());
		dto.setVrednostGubitak(format.getVrednostGubitak());
		dto.setVrednostNereseno(format.getVrednostNereseno());
		dto.setVrednostPobeda(format.getVrednostPobeda());
		return dto;
	}

}
