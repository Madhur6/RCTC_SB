package com.example.RCTC_SB.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RCTC_SB.dto.TrainRequestDTO;
import com.example.RCTC_SB.modal.Train;
import com.example.RCTC_SB.service.TrainService;


@RestController
@RequestMapping("/train")
public class TrainController {
	
	 @Autowired
	 private TrainService trainService;
	 
	 @GetMapping("/check")
	 public String check() {
		 return "working";
	 }
	 @PostMapping("/add")
	 public Train addNewTrain(@RequestBody TrainRequestDTO trainRequestDTO) {
		
		 return trainService.addTrain(trainRequestDTO);
	 }
	 @GetMapping("/allTrains")
	 public List<Train>allTrains(){
		 return trainService.viewAllTrains();
	 }
	 @GetMapping("/{trainNumber}")
	    public ResponseEntity<Train> getTrainByNumber(@PathVariable int trainNumber) {
		 Train train = trainService.findTrain(trainNumber);
		    if (train == null) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
		    }
		    return ResponseEntity.ok(train); 
	    }
	 @PutMapping("/update/{trainNumber}")
	 public Train updatedTrain(@RequestBody TrainRequestDTO trainRequestDTO,@PathVariable int trainNumber) {
		 return trainService.UpdateTrain(trainRequestDTO,trainNumber);
	 }
	 
	 @DeleteMapping("/delete/{trainNumber}")
	 public String deleteTrain(@PathVariable int trainNumber) {
		 return trainService.DeleteTrain(trainNumber);
	 }
}
