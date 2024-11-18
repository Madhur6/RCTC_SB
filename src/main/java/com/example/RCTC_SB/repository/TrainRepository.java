package com.example.RCTC_SB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RCTC_SB.modal.Train;


@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
	Train findByTrainNumber(int trainNumber);
	void deleteByTrainNumber(int trainNumber);
}
