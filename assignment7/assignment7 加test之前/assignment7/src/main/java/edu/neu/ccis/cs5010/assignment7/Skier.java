package edu.neu.ccis.cs5010.assignment7;

public class Skier {
	private int id;
	private int vertical;

	public Skier(int id) {
		this.id = id;
		this.vertical = 0;
	}

	public void increaseVertical(int liftId) {
		if(liftId <= 10) {
			this.vertical += 200;
		}
		else if(liftId <= 20) {
			this.vertical += 300;
		}
		else if(liftId <= 30) {
			this.vertical += 400;
		}
		else {
			this.vertical += 500;
		}
	}

	public int getId() {
		return id;
	}

	public int getVertical() {
		return vertical;
	}
}
