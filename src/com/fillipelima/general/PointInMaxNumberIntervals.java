package com.fillipelima.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * [1, 5] [7, 10] [12, 20] [23, 30]
 * 
 * @author Fillipe Lima
 *
 */
class Event {
	Integer time;
	String type;
	public Event(Integer time, String type) {
		this.time = time;
		this.type = type;
	}
	public Integer getTime() {
		return time;
	}
	public String getType() {
		return type;
	}
}
public class PointInMaxNumberIntervals {

	public static int[] findMaxGuests(int[] Entry, int Exit[], int N) {
		int[] ans = new int[2];
		List<Event> list = new ArrayList<Event>();

		for (int n : Entry)
			list.add(new Event(n, "Arrival"));

		for (int n : Exit)
			list.add(new Event(n, "Exit"));
		
		Collections.sort(list, Comparator.comparing(Event::getTime).thenComparing(Event::getType));

		int count = 0;

		for (Event e : list) {
			if (e.getType().equals("Arrival")) {
				count++;
				if (count > ans[0]) {
					ans[0] = count;
					ans[1] = e.getTime();
				} else if (count == ans[0]) {
					ans[1] = Math.min(ans[1], e.getTime());
				}
			} else {
				count--;
			}
		}

		return ans;

	}

	public static void main(String[] args) {
		int[] r = PointInMaxNumberIntervals.findMaxGuests(new int[] { 8, 5 }, new int[] { 9, 15 },
				2);
		System.out.println(r[0] + " - " + r[1]);
	}

}
