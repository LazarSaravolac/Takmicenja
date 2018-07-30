package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Sortiraj;
import jwd.wafepa.model.Ucesnik;
import jwd.wafepa.service.UcesnikService;
import jwd.wafepa.support.UcesnikDTOtoUcesnik;
import jwd.wafepa.support.UcesnikToUcesnikDTO;
import jwd.wafepa.web.dto.FormatDTO;
import jwd.wafepa.web.dto.UcesnikDTO;

@RestController
@RequestMapping("/api/ucesnici")
public class ApiUcesnikController {

	@Autowired
	UcesnikService ucesnikService;
	
	@Autowired
	UcesnikDTOtoUcesnik toUcesnik;
	
	@Autowired
	UcesnikToUcesnikDTO toDTO;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UcesnikDTO>> get(
			@RequestParam(required=false) String naziv,
			@RequestParam(required=false) Long idTakmicenje,
			@RequestParam(defaultValue="0") int page){
		
		
		Page<Ucesnik>ucesnici;
		if(naziv!=null || idTakmicenje!=null) {
			ucesnici=ucesnikService.pretraga(naziv, idTakmicenje, page);
		}else {
			ucesnici=ucesnikService.findAll(page);
		}
		
		Integer brojBodova=ucesnici.getContent().get(0).getBrojBodova();
		
		for(Ucesnik u:ucesnici.getContent()) {
			if(brojBodova<u.getBrojBodova()) {
				brojBodova=u.getBrojBodova();
			}
		}
		
		List<Ucesnik>ucesnici1=ucesnici.getContent();
		List<Integer>ucesniciBrojBodova=new ArrayList<>();
		for(Ucesnik e:ucesnici1) {
			ucesniciBrojBodova.add(e.getBrojBodova());
		}
		
		Collections.sort(ucesniciBrojBodova);
		
		
	
		
	
		
		Ucesnik uces=null;
		for(Ucesnik s:ucesnici.getContent()) {
			if(s.getBrojBodova().equals(brojBodova)) {
				uces=s;
				break;
			}
			
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(ucesnici.getTotalPages()) );
		headers.add("ucesnikBrate",uces.getNaziv());
		headers.add("proba",Integer.toString(ucesniciBrojBodova.get(0)));
		return new ResponseEntity<>(toDTO.convert(ucesnici.getContent()),headers,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET,
			value="/{id}")
public ResponseEntity<UcesnikDTO> get(@PathVariable Long id){
		
		Ucesnik ucesnik=ucesnikService.findOne(id);
		
		if(ucesnik==null) {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDTO.convert(ucesnik),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<UcesnikDTO> add(
			@Validated @RequestBody UcesnikDTO novUcenik){
		Ucesnik ucesnik=toUcesnik.convert(novUcenik);
		ucesnikService.save(ucesnik);
		
		
		return new ResponseEntity<>(toDTO.convert(ucesnik),HttpStatus.CREATED);
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{u1}/{u2}/{ishod}")
	public ResponseEntity<UcesnikDTO> odigraj(@PathVariable Long u1,@PathVariable Long u2,@PathVariable Long ishod){
		ucesnikService.odigrajMec(u1, u2, ishod);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<UcesnikDTO> edit(
			@PathVariable Long id,
			@Validated @RequestBody UcesnikDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Ucesnik ucesnik=toUcesnik.convert(izmenjen);
		ucesnikService.save(ucesnik);
		
		return new ResponseEntity<>(toDTO.convert(ucesnik),HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<UcesnikDTO> delete(@PathVariable Long id){
		ucesnikService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
