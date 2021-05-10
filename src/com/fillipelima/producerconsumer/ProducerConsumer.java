package com.fillipelima.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	Queue<Integer> queue;
	int capacity;
	
	public ProducerConsumer(int size) {
		queue = new LinkedList<Integer>();
		capacity = size;
	}
	
	public void produce(int value) throws InterruptedException {
			synchronized (this) {
				while (queue.size() >= capacity) 
					wait();
				queue.add(value);				
				// Notify consume thread it can start consuming.
				notify();
			}
	}
	
	public int consume() throws InterruptedException {
			synchronized (this) {
				while (queue.size() == 0)
					wait();
				int value = queue.poll();			
				// Notify producer thread it can start producing.
				notify();
				return value;				
			}
	}
}
