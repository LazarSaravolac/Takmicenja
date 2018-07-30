package jwd.wafepa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Ucesnik;
import jwd.wafepa.repository.UcesnikRepository;
import jwd.wafepa.service.UcesnikService;

@Service
public class JpaUcesnikService implements UcesnikService{

	@Autowired
	private UcesnikRepository ucesnikRepository;
	
	
	@Override
	public Ucesnik save(Ucesnik ucesnik) {
		// TODO Auto-generated method stub
		return ucesnikRepository.save(ucesnik);
	}

	@Override
	public Page<Ucesnik> findAll(int page) {
		// TODO Auto-generated method stub
		return ucesnikRepository.findAll(new PageRequest(page, 5));
	}

	@Override
	public Ucesnik findOne(Long id) {
		// TODO Auto-generated method stub
		return ucesnikRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ucesnikRepository.delete(id);
	}

	@Override
	public Page<Ucesnik> findByTakmicenjeId(int pageNum, Long takmicenjeId) {
		// TODO Auto-generated method stub
		return ucesnikRepository.findByTakmicenjeId(takmicenjeId, new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Ucesnik> pretraga(String naziv, Long idTakmicenje, int page) {
		// TODO Auto-generated method stub
		if(naziv!=null) {
			naziv="%" + naziv + "%";
		}
		return ucesnikRepository.pretraga(naziv, idTakmicenje, new PageRequest(page, 5));
	}

	@Override
	public void odigrajMec(Long ucesnik1, Long ucesnik2, Long ishod) {
		// TODO Auto-generated method stub
		System.out.println( "dadadad         " +  ishod + " dadad" + ucesnik1);
		Ucesnik ucesnik1Mec=ucesnikRepository.findOne(ucesnik1);
		ucesnik1Mec.setOdigranoSusreta(ucesnik1Mec.getOdigranoSusreta()+1);

		ucesnikRepository.save(ucesnik1Mec);
		
		Ucesnik ucesnik2Mec=ucesnikRepository.findOne(ucesnik2);
		ucesnik2Mec.setOdigranoSusreta(ucesnik2Mec.getOdigranoSusreta()+1);
		ucesnikRepository.save(ucesnik2Mec);
		
		if(ishod==1) {
			ucesnik1Mec.setBrojBodova(ucesnik1Mec.getBrojBodova() + 3);
			ucesnikRepository.save(ucesnik1Mec);
		}
		if(ishod==2){
			ucesnik2Mec.setBrojBodova(ucesnik2Mec.getBrojBodova() + 3);
			ucesnikRepository.save(ucesnik2Mec);
		}
		if(ishod==3) {
			ucesnik1Mec.setBrojBodova(ucesnik1Mec.getBrojBodova() + 1);
			ucesnikRepository.save(ucesnik1Mec);
			ucesnik2Mec.setBrojBodova(ucesnik1Mec.getBrojBodova() + 1);
			ucesnikRepository.save(ucesnik2Mec);
		}
	}



	

}
