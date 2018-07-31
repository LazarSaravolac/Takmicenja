package jwd.wafepa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Format;
import jwd.wafepa.repository.FormatRepository;
import jwd.wafepa.service.FormatService;

@Service
public class JpaFormatService implements FormatService {

	@Autowired
	FormatRepository formatRepository;
	
	
	@Override
	public Format save(Format format) {
		// TODO Auto-generated method stub
		return formatRepository.save(format);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		formatRepository.delete(id);
	}

}
