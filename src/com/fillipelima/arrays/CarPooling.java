package com.fillipelima.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
class Event {
    int km;
    int type;
    int val;
    Event(int km, int type, int val) {
        this.km = km;
        this.type = type;
        this.val = val;
    }
    public int getKm() {
        return this.km;
    }
    public int getType() {
        return this.type;
    }
}
public class CarPooling {
    public boolean carPoolingWithEvent(int[][] trips, int capacity) {
        List<Event> events = new ArrayList<Event>();
        for (int[] t : trips) {
            events.add(new Event(t[1], 1, t[0])); // start km
            events.add(new Event(t[2], 0, t[0])); // end km
        }
        Collections.sort(events, Comparator.comparing(Event::getKm).thenComparing(Event::getType));
        int count = 0;
        for (Event e : events) {
            count += e.type == 1 ? e.val : -e.val;
            if (count > capacity)
                return false;
        }
        return true;
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timestamp = new TreeMap<>();
        for (int[] trip : trips) {
            int startPassenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
            timestamp.put(trip[1], startPassenger);

            int endPassenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
            timestamp.put(trip[2], endPassenger);
        }
        int usedCapacity = 0;
        for (int passengerChange : timestamp.values()) {
            usedCapacity += passengerChange;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }    
}
