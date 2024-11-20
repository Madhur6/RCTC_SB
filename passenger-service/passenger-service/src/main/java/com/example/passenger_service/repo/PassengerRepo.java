package com.example.passenger_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.passenger_service.model.Passenger;

@Repository   // CREATES `PASSENGER` TABLE FOR ME IN THE DATABASE USING `SQL` QUERIES;
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {
	public List<Passenger> findById(int id);
}