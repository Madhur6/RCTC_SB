package com.example.passenger_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.passenger_service.exception.NotFoundException;
import com.example.passenger_service.model.Passenger;
import com.example.passenger_service.repo.PassengerRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PassengerService {
	@Autowired
	private PassengerRepo prepo;
	
	public List<Passenger> getAll(){
		return this.prepo.findAll();
	}
	
	
//	public List<Passenger> getById(int id) {
//		return this.prepo.findById(id);
////				.orElseThrow(() -> new EntityNotFoundException("Please check the id"));
//	}
	
//	public Optional<Passenger> getById(Integer id){
//		return prepo.findById(id);
//	}
	
	public Passenger getById(Integer id) {
//		return prepo.findById(id).get();
		return prepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Please check the passenger id."));
//				.orElseThrow(() -> new EntityNotFoundException("Please check the passenger id!"));
				
	}
	
	public List<Passenger> get(){
		return this.prepo.findAll();
	}
	
	public String save(Passenger passenger) {
		this.prepo.save(passenger);
		return "Passenger saved successfully!";
	}
	
	
	public Passenger updatePassenger(Integer id, Passenger passenger) {

	    Passenger existingPassenger = prepo.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Passenger with id " + id + " not found"));

	    existingPassenger.setName(passenger.getName());
	    existingPassenger.setAge(passenger.getAge());
	    existingPassenger.setBookings(passenger.getBookings());

	    return prepo.save(existingPassenger);
	}
	
	
	public String delete(int id) {
		this.prepo.delete(getById(id));
		return "Passenger deleted successfully!";
	}
	
	
}