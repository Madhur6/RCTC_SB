package com.example.RCTC_SB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RCTC_SB.dto.TrainRequestDTO;
import com.example.RCTC_SB.modal.Train;

@Service
public interface TrainService {
	public Train addTrain(TrainRequestDTO trainRequestDTO);
	public List<Train> viewAllTrains();
	public Train findTrain(int trainNumber);
	public Train UpdateTrain(TrainRequestDTO trainRequestDTO,int trainNumber);
	public String DeleteTrain(int trainNumber);
}
