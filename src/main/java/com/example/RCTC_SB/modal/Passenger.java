package com.example.RCTC_SB.modal;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Passenger {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private int age;
	    private String contactNumber;
	    private Boolean admin=false;
	    @OneToMany(mappedBy = "passenger")
	    private List<Booking> bookings;
}
