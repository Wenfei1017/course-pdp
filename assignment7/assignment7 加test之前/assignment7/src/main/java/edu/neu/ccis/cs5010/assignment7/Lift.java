package edu.neu.ccis.cs5010.assignment7;

public class Lift {
	private int id;
	private int rides;

	public Lift(int id) {
		this.id = id;
		this.rides = 0;
	}

	public void addRide() {

		this.rides = this.rides + 1;
	}

	public int getId() {
		return this.id;
	}

	public int getRides() {
		return this.rides;
	}
}
