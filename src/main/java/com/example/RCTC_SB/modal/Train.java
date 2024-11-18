package com.example.RCTC_SB.modal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Train {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	 	@Column(unique = true) 
	    private int trainNumber;
	    private String trainName;
	    private String source;
	    private String destination;
		private String arrivalTime;
		private String departureTime;
		
		 @OneToMany(mappedBy = "train")
		 @JsonManagedReference // Prevents infinite recursion by breaking the cycle at the Train side
	     private List<Coach> coaches;
	    

		 public Train() {
		        
		    }
		public Train(int trainNumber, String trainName, String source, String destination,
				String arrivalTime, String departureTime) {
			super();
			
			this.trainNumber = trainNumber;
			this.trainName = trainName;
			this.source = source;
			this.destination = destination;
			this.arrivalTime = arrivalTime;
			this.departureTime = departureTime;
			
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public int getTrainNumber() {
			return trainNumber;
		}



		public void setTrainNumber(int trainNumber) {
			this.trainNumber = trainNumber;
		}



		public String getTrainName() {
			return trainName;
		}



		public void setTrainName(String trainName) {
			this.trainName = trainName;
		}



		public String getSource() {
			return source;
		}



		public void setSource(String source) {
			this.source = source;
		}



		public String getDestination() {
			return destination;
		}



		public void setDestination(String destination) {
			this.destination = destination;
		}



		public String getArrivalTime() {
			return arrivalTime;
		}



		public void setArrivalTime(String arrivalTime) {
			this.arrivalTime = arrivalTime;
		}



		public String getDepartureTime() {
			return departureTime;
		}



		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
		}



		public List<Coach> getCoaches() {
			return coaches;
		}



		public void setCoaches(List<Coach> coaches) {
			this.coaches = coaches;
		}
	    
	    

}
