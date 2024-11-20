package com.example.passenger_service.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Passenger{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	private String contact;
	
//	@OneToMany(mappedBy="passenger")
	private List<String> bookings;

	
	public Passenger() {
		super();
	}

	public Passenger(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getContact() {return contact;}
	public void setContact(String contact) {this.contact=contact;}

	public List<String> getBookings() {
		return bookings;
	}
	
	
    // WILL CHANGE LATER...
	public void setBookings(List<String> bookings) {
		this.bookings = bookings;
	}
	
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", bookings=" + bookings + "]";
	}

}
