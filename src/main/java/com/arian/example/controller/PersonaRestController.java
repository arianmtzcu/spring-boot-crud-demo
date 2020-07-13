package com.arian.example.controller;

import java.util.List;

import com.arian.example.model.Persona;
import com.arian.example.service.api.PersonaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/persona/")
public class PersonaRestController {

	@Autowired
	private PersonaServiceAPI personaServiceAPI;

	@GetMapping(value = "/all")
	public List<Persona> getAll() {
		return personaServiceAPI.getAll();
	}

	@GetMapping(value = "/find/{id}")
	public Persona find(@PathVariable Long id) {
		return personaServiceAPI.get(id);
	}

	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping(value = "/save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona obj = personaServiceAPI.save(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	//@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Persona> delete(@PathVariable Long id) {
		Persona persona = personaServiceAPI.get(id);
		if (persona != null) {
			personaServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

	/*@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public HttpStatus updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}*/
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona p) {
		Persona persona = personaServiceAPI.get(id);
		if (persona != null) {
			System.out.println(p.toString());
			//personaServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
}
