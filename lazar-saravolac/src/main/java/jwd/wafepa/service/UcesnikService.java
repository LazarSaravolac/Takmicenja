package jwd.wafepa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.wafepa.model.Ucesnik;

public interface UcesnikService {
	Ucesnik save(Ucesnik ucesnik);
	Page<Ucesnik>findAll(int page);
	void odigrajMec(Long ucesnik1,Long ucesnik2,Long ishod);
	Ucesnik findOne(Long id);
	void delete(Long id);
	Page<Ucesnik> findByTakmicenjeId(int pageNum, Long takmicenjeId);
	Page<Ucesnik> pretraga(
			@Param("naziv") String naziv, 
			@Param("idTakmicenje") Long idTakmicenje, 
			int page);
}
