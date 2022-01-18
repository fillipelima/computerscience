package com.fillipelima.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class DigitsOccurMostNumeberOfTimes {
	public static int[] calculateWithCustomType(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<MyPair> list = new ArrayList<MyPair>();
		
		// Build map with numbers and how many time each occurs
		for (int n : a) 
			map.put(n, map.getOrDefault(n, 0)+1);
		
		// Add Map Entries as Pairs to list to be able to sort
		for (Map.Entry<Integer, Integer> e : map.entrySet())
			list.add(new MyPair(e.getKey(), e.getValue()));
		
		// Sort
		Collections.sort(list, Comparator.comparing(MyPair::getCount).reversed().thenComparingInt(MyPair::getNumber));
		
		// Filter pairs with max occurrence number only
		int max = list.stream().max(Comparator.comparing(MyPair::getCount)).get().getCount();
		return list.stream().filter(v -> v.getCount().equals(max)).mapToInt(v -> v.getNumber()).toArray();
	}
	public static int[] calculateWithPrimitiveType(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<int[]> queue = new PriorityQueue<int[]>( (x, y) -> x[1] == y[1] ? x[0] - y[0] : y[1] - x[1] );
		List<Integer> list = new ArrayList<Integer>();
		
		for (int n : a) 
			map.put(n, map.getOrDefault(n, 0)+1);
		
		for (Map.Entry<Integer, Integer> e : map.entrySet())
			queue.add(new int[] {e.getKey(), e.getValue()});
		
		Integer lastCount = 0;
		while (!queue.isEmpty()) {
			int[] n = queue.poll();
			if (lastCount == 0 || lastCount.equals(n[1])) 
				list.add(n[0]);
			else
				break;
			lastCount = n[1];
		}
			
		
		return list.stream().mapToInt(i->i).toArray();
	}
	public static void main(String[] args) {
		System.out.println("-- With Custom Type --");
		int[] r1 = DigitsOccurMostNumeberOfTimes.calculateWithCustomType((new int[] {10, 10, 10, 1, 2, 2, 3, 3, 5, 5, 5, 4, 4, 4, 6, 7, 8, 9}));
		Arrays.stream(r1).forEach(e -> System.out.println(e));
		System.out.println("-- With Primitive Type --");
		int[] r2 = DigitsOccurMostNumeberOfTimes.calculateWithPrimitiveType((new int[] {1, 2, 2, 3, 3, 5, 5, 5, 4, 4, 4, 6, 7, 8, 9}));
		Arrays.stream(r2).forEach(e -> System.out.println(e));
	}
}

class MyPair {
	private Integer number;
	private Integer count;
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public MyPair(Integer number, Integer count) {
		super();
		this.number = number;
		this.count = count;
	}
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyPair other = (MyPair) obj;
		return Objects.equals(number, other.number);
	}
	
	
	
}
