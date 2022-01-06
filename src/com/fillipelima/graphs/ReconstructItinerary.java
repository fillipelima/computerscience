package com.fillipelima.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * You are given a list of airline tickets where tickets[i] = [fromi, toi]
 * represent the departure and the arrival airports of one flight. Reconstruct
 * the itinerary in order and return it.
 * 
 * All of the tickets belong to a man who departs from "JFK", thus, the
 * itinerary must begin with "JFK". If there are multiple valid itineraries, you
 * should return the itinerary that has the smallest lexical order when read as
 * a single string.
 * 
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"]. You may assume all tickets form at least one valid itinerary.
 * You must use all the tickets once and only once.
 * 
 * @author Fillipe Lima
 *
 */
public class ReconstructItinerary {
	class Node implements Comparable<Object> {
	    
	    String val;
	    Queue<Node> edges = new PriorityQueue<Node>();
	    
	    public Node (String val) {
	        this.val = val;
	    }
	    
	    public boolean equals(Object o) {
	        return ((Node)o).val.equals(val);
	    }
	    
	    public int compareTo(Object o) {
	        return this.val.compareTo(((Node)o).val);
	    }
	}

	class Solution {
	    
	    LinkedList<String> list = new LinkedList<String>();
	    Map<String, Node> map = new HashMap<String, Node>();
	    
	    public List<String> findItinerary(List<List<String>> tickets) {
	        // Traverse all tickets and create one node to the origin and another node to the destiny
	        for (List<String> ticket : tickets ) {
	            Node node1 = map.computeIfAbsent(ticket.get(0), n -> new Node(ticket.get(0)));
	            node1.edges.add(map.computeIfAbsent(ticket.get(1), n -> new Node(ticket.get(1))));            
	        }
	        
	        addNodesToList(map.get("JFK"));
	        return list;
	    }
	    
	    private void addNodesToList(Node node) {
	        while (!node.edges.isEmpty())
	            addNodesToList(node.edges.poll());
	        list.offerFirst(node.val);
	    }
	}
}
