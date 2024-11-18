package com.example.RCTC_SB.modal;

import java.sql.Date;

import jakarta.persistence.*;


@Entity
public class Booking {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Date bookingDate;
	    private String status;  // "Confirmed", "Cancelled", "Pending"
	    private int seatNumber;

	    @ManyToOne
	    @JoinColumn(name = "passenger_id")
	    private Passenger passenger;

	    @ManyToOne
	    @JoinColumn(name = "train_id")
	    private Train train;

	    @ManyToOne
	    @JoinColumn(name = "coach_id")
	    private Coach coach;

	    private int seatsBooked;
}
