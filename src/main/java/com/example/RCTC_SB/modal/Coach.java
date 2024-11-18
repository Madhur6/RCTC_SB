package com.example.RCTC_SB.modal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Coach {
	 

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String coachType;  // AC, Sleeper, General
	    private String coachName;  // like s1,s2, A1, G1  (Added by Aqib)
	    private int totalSeats; 
	    private int availableSeats;
	    private int ticketPrice;
	    public int getTicketPrice() {
			return ticketPrice;
		}

		public void setTicketPrice(int ticketPrice) {
			this.ticketPrice = ticketPrice;
		}

		@ManyToOne
	    @JoinColumn(name = "train_id",referencedColumnName = "id")
	    @JsonBackReference // Prevents infinite recursion by breaking the cycle at the Coach side
	    private Train train;

	    @OneToMany(mappedBy = "coach")
	    private List<Booking> bookings;
	    
	    
	    public Coach() {
	    	
	    }
	    
	    public Coach(String coachType, String coachName, int totalSeats, int availableSeats, int ticketPrice) {
			super();
			this.coachType = coachType;
			this.coachName = coachName;
			this.totalSeats = totalSeats;
			this.availableSeats = availableSeats;
			this.ticketPrice = ticketPrice;
		}
	    
	    
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCoachType() {
			return coachType;
		}

		public void setCoachType(String coachType) {
			this.coachType = coachType;
		}

		public String getCoachName() {
			return coachName;
		}

		public void setCoachName(String coachName) {
			this.coachName = coachName;
		}

		public int getTotalSeats() {
			return totalSeats;
		}

		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}

		public int getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}

		public Train getTrain() {
			return train;
		}

		public void setTrain(Train train) {
			this.train = train;
		}

		public List<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(List<Booking> bookings) {
			this.bookings = bookings;
		}

		 

	    
}
