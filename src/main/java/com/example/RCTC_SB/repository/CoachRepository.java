package com.example.RCTC_SB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RCTC_SB.modal.Coach;


public interface CoachRepository extends JpaRepository<Coach,Long>{
	List<Coach> findAllByTrain_TrainNumber(int trainNumber);
	
	void deleteAllByTrain_TrainNumber(int trainNumber);
}
