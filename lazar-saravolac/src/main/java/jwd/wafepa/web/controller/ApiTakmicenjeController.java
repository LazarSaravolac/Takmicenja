package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Ucesnik;
import jwd.wafepa.service.TakmicenjeService;
import jwd.wafepa.service.UcesnikService;
import jwd.wafepa.support.TakmicenjeToTakmicenjeDTO;
import jwd.wafepa.support.UcesnikToUcesnikDTO;
import jwd.wafepa.web.dto.TakmicenjeDTO;
import jwd.wafepa.web.dto.UcesnikDTO;

@RestController
@RequestMapping(value="/api/takmicenja")
public class ApiTakmicenjeController {

	
	@Autowired
	private TakmicenjeService takmicenjeService;
	@Autowired
	private UcesnikService ucesnikService;
	
	@Autowired
	private TakmicenjeToTakmicenjeDTO toDTO;
	
	
	@Autowired
	private UcesnikToUcesnikDTO toUcesnikDTO;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TakmicenjeDTO>> get(){
		return new ResponseEntity<>(
				toDTO.convert(takmicenjeService.findAll()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{komoanijaId}/automobili")
	public ResponseEntity<List<UcesnikDTO>> knjigeIzdavac(
			@PathVariable Long takmicenjeId,
			@RequestParam(defaultValue="0") int page){
		
		Page<Ucesnik>ucesnici=ucesnikService.findByTakmicenjeId(page, takmicenjeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(ucesnici.getTotalPages()) );
		return  new ResponseEntity<>(
				toUcesnikDTO.convert(ucesnici.getContent()),
				headers,
				HttpStatus.OK);
		
	}
	
}
