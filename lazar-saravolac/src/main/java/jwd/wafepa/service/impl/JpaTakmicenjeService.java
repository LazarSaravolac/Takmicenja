package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Takmicenje;
import jwd.wafepa.repository.TakmicenjeRepository;
import jwd.wafepa.service.TakmicenjeService;

@Service
public class JpaTakmicenjeService implements TakmicenjeService{

	@Autowired
	TakmicenjeRepository takmicenjeRepository;
	
	
	@Override
	public List<Takmicenje> findAll() {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		takmicenjeRepository.delete(id);
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje findOne(Long id) {
		// TODO Auto-generated method stub
		return takmicenjeRepository.findOne(id);
	}

}
