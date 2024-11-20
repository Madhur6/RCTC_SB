package com.example.passenger_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.passenger_service.model.Passenger;
import com.example.passenger_service.repo.PassengerRepo;
import com.example.passenger_service.service.PassengerService;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/passenger")
public class PassengerController {
	
	@Autowired
	private PassengerService pService;
	
	@GetMapping("")
	public List<Passenger> findAll(){
		return this.pService.getAll();
	}
	
// METHOD 1
//    @GetMapping("{id}")
//    public Passenger findById(@PathVariable("id") int id) {
//    	return this.pService.getById(id).get(0);
//    }
	

// METHOD 2
//	@GetMapping("{id}")
//	public ResponseEntity<Optional<Passenger>> findById(@PathVariable("id") int id){
//		Optional <Passenger> pOpt = pService.getById(id);
//		if (pOpt.isPresent()) {
//			return ResponseEntity.ok(pOpt);
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
//	}
	
	
// METHOD 3
//	@GetMapping("{id}")
//	public Passenger findById(@PathVariable("id") int id) {
//		return this.pService.getById(id);
//	}
	
	
// METHOD 4
//	@GetMapping("{id}")
//	public ResponseEntity<Passenger> findById(@PathVariable("id") int id) {
//		try {
//			Passenger foundObj = this.pService.getById(id);
//			return ResponseEntity.ok(foundObj);
//		} catch (EntityNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
//	}
	
// METHOD 5
	@GetMapping("{id}")
	public Passenger findById(@PathVariable("id") int id) {
		return this.pService.getById(id);
	}
	
	
	@PostMapping("")
	public Passenger save(@RequestBody Passenger passenger) {
		this.pService.save(passenger);
		return passenger;
	}
	
	@PutMapping("{id}/update")
	public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger, @PathVariable("id") int id) {
	    try {
	        Passenger updatedPassenger = pService.updatePassenger(id, passenger);
	        return ResponseEntity.ok(updatedPassenger);
	    } catch (EntityNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
	
	@DeleteMapping("{id}/delete")
	public HashMap<String, String> delete(@PathVariable("id") int id){
		this.pService.delete(id);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("data", "Data deleted succesfully!");
		
		return map;
	}
}