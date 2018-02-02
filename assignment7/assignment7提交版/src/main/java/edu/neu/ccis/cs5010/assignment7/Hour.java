package edu.neu.ccis.cs5010.assignment7;

import java.util.*;

public class Hour {
	private int hour;
	private Queue<Lift> queue;
	private Set<Integer> liftIds;
	private Map<Integer, Integer> map;

	public Hour(int hour) {
		this.hour = hour;
		this.liftIds = new HashSet<>();
		this.map = new HashMap<>();
		this.queue = new PriorityQueue<>(10, new Comparator<Lift>() {
			@Override
			public int compare(Lift o1, Lift o2) {
				return o1.getRides() - o2.getRides();
			}
		});
	}

	public void addLift(int liftId) {
		if(map.containsKey(liftId)) {
			map.put(liftId, map.get(liftId) + 1);
		}
		else {
			map.put(liftId, 1);
		}
	}

	public Map<Integer, Integer> getMap() {
		Map<Integer, Integer> map1 = this.map;
		return map1;
	}

	public int getHour() {
		return this.hour;
	}

}
