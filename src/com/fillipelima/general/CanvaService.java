package com.fillipelima.general;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * Design (id, content, userId) 
 * 
 * <key> : <value>
 * designId : List of userId
 * designId : content 
 * 
 * userId : List of designId / List of Design
 * designId : content 
 * 
 * @author fillipe
 *
 */
public class CanvaService {
	private Map<Integer, String> designMap = new HashMap<Integer, String>();
	private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	public CanvaService() {
		// TODO Auto-generated constructor stub
		List<String> r = map.get(1).stream().map(n -> designMap.get(n)).collect(Collectors.toList());
	}
	// Create Design
	
	
	// Find Designs from an User
	
	// Share Designs between users
	
	
	
}
