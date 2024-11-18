package com.example.RCTC_SB.dto;

public class TrainRequestDTO {

    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String arrivalTime;
    private String departureTime;
    private String[] coachTypes;
    private String[] noOfCoaches;
    private String[] ticketPrices;
    private String[] totalSeats;
    
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
	public String[] getCoachTypes() {
		return coachTypes;
	}
	public void setCoachTypes(String[] coachTypes) {
		this.coachTypes = coachTypes;
	}
	public String[] getNoOfCoaches() {
		return noOfCoaches;
	}
	public void setNoOfCoaches(String[] noOfCoaches) {
		this.noOfCoaches = noOfCoaches;
	}
	public String[] getTicketPrices() {
		return ticketPrices;
	}
	public void setTicketPrices(String[] ticketPrices) {
		this.ticketPrices = ticketPrices;
	}
	public String[] getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(String[] totalSeats) {
		this.totalSeats = totalSeats;
	}

}
