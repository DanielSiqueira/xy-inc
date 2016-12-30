package br.com.provazup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.provazup.model.Poi;
import br.com.provazup.repository.IPoiRepository;

@RestController
@RequestMapping(value = "/poi", consumes = "application/json", produces = "application/json")
public class PoiService {

	@Autowired
	private IPoiRepository poiRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Poi> findAll() {
		return poiRepository.findAll();
	}

	@RequestMapping(value = "/proximos", method = RequestMethod.GET)
	public List<Poi> findPoisPorProximidade(@RequestParam("d") Long d, @RequestParam("x") Long x,
			@RequestParam("y") Long y) {

		List<Poi> pois = poiRepository.findAll();
		List<Poi> listaPois = new ArrayList<Poi>();

		for (Poi poi : pois) {
			if (Math.sqrt(Math.pow(x - poi.getCoordenadaX(), 2) + Math.pow(y - poi.getCoordenadaY(), 2)) <= d) {
				listaPois.add(poi);
			}
		}

		return listaPois;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insertPoi(@Validated @RequestBody Poi poi, BindingResult errors) {
		if (errors.hasErrors()) {
			List<String> listaErros = new ArrayList<>();
			for (Object object : errors.getAllErrors()) {
				FieldError fieldError = (FieldError) object;
				listaErros.add(fieldError.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(listaErros);
		}

		Poi poiAux = poiRepository.save(poi);

		return ResponseEntity.ok(poiAux);
	}

}
