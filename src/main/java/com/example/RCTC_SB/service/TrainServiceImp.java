package com.example.RCTC_SB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.RCTC_SB.dto.TrainRequestDTO;
import com.example.RCTC_SB.modal.Coach;
import com.example.RCTC_SB.modal.Train;
import com.example.RCTC_SB.repository.CoachRepository;
import com.example.RCTC_SB.repository.TrainRepository;

@Component
public class TrainServiceImp implements TrainService{

	@Autowired
    private TrainRepository trainRepo;
	
	@Autowired
	private CoachRepository coachRepo;
	
	@Override
	public Train addTrain(TrainRequestDTO trainRequestDTO) {
		
		Train newTrain = new Train(
	            trainRequestDTO.getTrainNumber(),
	            trainRequestDTO.getTrainName(),
	            trainRequestDTO.getSource(),
	            trainRequestDTO.getDestination(),
	            trainRequestDTO.getArrivalTime(),
	            trainRequestDTO.getDepartureTime()
	        );
		
		Train savedTrain;
		 try {
	           savedTrain = trainRepo.save(newTrain);
	        } catch (DataIntegrityViolationException e) {
	            throw new RuntimeException("Train number must be unique. A train with this number already exists.");
	        }
	
		
		List<Coach>allCoaches = new ArrayList<>();
		for(int i=0;i<trainRequestDTO.getCoachTypes().length;i++) {
			String coachType = trainRequestDTO.getCoachTypes()[i];
			int coachCount = Integer.parseInt(trainRequestDTO.getNoOfCoaches()[i]);
            int totalSeat = Integer.parseInt(trainRequestDTO.getTotalSeats()[i]);
            int ticketPrice = Integer.parseInt(trainRequestDTO.getTicketPrices()[i]);
            
            for (int j = 1; j <= coachCount; j++) {
                String coachName = coachType.charAt(0) + Integer.toString(j);

                Coach coach = new Coach();
                coach.setCoachType(coachType);
                coach.setCoachName(coachName);
                coach.setTotalSeats(totalSeat);
                coach.setAvailableSeats(totalSeat);
                coach.setTicketPrice(ticketPrice);
                coach.setTrain(savedTrain);

                allCoaches.add(coach);
                coachRepo.save(coach);
            }
		}
		newTrain.setCoaches(allCoaches);
		
		 return savedTrain; 
	}
	@Override
	public List<Train>viewAllTrains(){
		return trainRepo.findAll();
	}
	@Override
	public Train findTrain(int trainNumber) {
		return trainRepo.findByTrainNumber(trainNumber); 
	}
	
	 
    public Train UpdateTrain(TrainRequestDTO trainRequestDTO, int trainNumber) {
        Train existingTrain = trainRepo.findByTrainNumber(trainNumber);
        if (existingTrain == null) {
            throw new RuntimeException("Train not found for trainNumber: " + trainNumber);
        }

        // Update train details
        existingTrain.setTrainName(trainRequestDTO.getTrainName());
        existingTrain.setSource(trainRequestDTO.getSource());
        existingTrain.setDestination(trainRequestDTO.getDestination());
        existingTrain.setArrivalTime(trainRequestDTO.getArrivalTime());
        existingTrain.setDepartureTime(trainRequestDTO.getDepartureTime());

        
        List<Coach> existingCoaches = coachRepo.findAllByTrain_TrainNumber(trainNumber);

        
        Map<String, Coach> existingCoachMap = existingCoaches.stream()
                .collect(Collectors.toMap(Coach::getCoachName, coach -> coach));

        List<Coach> updatedCoaches = new ArrayList<>();

        for (int i = 0; i < trainRequestDTO.getCoachTypes().length; i++) {
            String coachType = trainRequestDTO.getCoachTypes()[i];
            int coachCount = Integer.parseInt(trainRequestDTO.getNoOfCoaches()[i]);
            int totalSeats = Integer.parseInt(trainRequestDTO.getTotalSeats()[i]);
            int ticketPrice = Integer.parseInt(trainRequestDTO.getTicketPrices()[i]);

            for (int j = 1; j <= coachCount; j++) {
                String coachName = coachType.charAt(0) + Integer.toString(j);

                if (existingCoachMap.containsKey(coachName)) {
                    
                    Coach existingCoach = existingCoachMap.get(coachName);
                    existingCoach.setCoachType(coachType);
                    existingCoach.setTotalSeats(totalSeats);
                    
                    existingCoach.setAvailableSeats(existingCoach.getAvailableSeats() + (totalSeats - existingCoach.getTotalSeats()));
                    existingCoach.setTicketPrice(ticketPrice);

                    updatedCoaches.add(existingCoach);
                    existingCoachMap.remove(coachName); // Mark as processed
                } else {
                    
                    Coach newCoach = new Coach();
                    newCoach.setCoachType(coachType);
                    newCoach.setCoachName(coachName);
                    newCoach.setTotalSeats(totalSeats);
                    newCoach.setAvailableSeats(totalSeats);
                    newCoach.setTicketPrice(ticketPrice);
                    newCoach.setTrain(existingTrain);

                    updatedCoaches.add(newCoach);
                }
            }
        }

        // Remove unprocessed coaches
        coachRepo.deleteAll(existingCoachMap.values());

     
        coachRepo.saveAll(updatedCoaches);

        existingTrain.setCoaches(updatedCoaches);

        return trainRepo.save(existingTrain);
    }

    @Transactional
    public String  DeleteTrain(int trainNumber) {
    	Train existingTrain = trainRepo.findByTrainNumber(trainNumber);
        if (existingTrain == null) {
            return "No Train available for Train Number:"+trainNumber;
        }
      
        coachRepo.deleteAllByTrain_TrainNumber(trainNumber);
        trainRepo.delete(existingTrain);
        return "Train Deleted Successfully";
    }
}
