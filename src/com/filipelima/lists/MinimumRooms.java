package com.filipelima.lists;

import java.util.List;
/**
 * 
 * @author fillipe
 *
 * {[30, 80], [50, 100], [70, 150]}
 */
public class MinimumRooms {
	public int compute(List<List<Integer>> data) {
		int count = 1;
		data.sort((a, b) -> a.get(0).compareTo(b.get(0)));
		Integer end = null;
		for (List<Integer> pair : data) {
			if (end != null) {
				if (pair.get(0) < end) {
					count++;
					end = pair.get(1);	
				}
			}else {
				end = pair.get(1);
			}
		}
		return count;
	}
}
