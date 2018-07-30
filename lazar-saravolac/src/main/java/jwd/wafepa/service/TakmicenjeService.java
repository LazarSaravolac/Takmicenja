package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Takmicenje;

public interface TakmicenjeService {

	List<Takmicenje>findAll();
	void delete(Long id);
	Takmicenje save(Takmicenje takmicenje);
	Takmicenje findOne(Long id);
	
}
