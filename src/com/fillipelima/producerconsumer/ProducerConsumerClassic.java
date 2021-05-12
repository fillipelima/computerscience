package com.fillipelima.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerClassic {
	
	public static void main (String args[]) {
		Buffer buffer = new Buffer(2);		
		Thread producer = new Thread(new Runnable() {			
			public void run() {
				try {
					buffer.produce();	
				}catch(InterruptedException e) {				
				}				
			}
		});
		
		Thread consumer = new Thread(new Runnable() {			
			public void run() {
				try {
					buffer.consume();	
				}catch(InterruptedException e) {				
				}				
			}
		});
		
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
			consumer.join();			
		}catch(InterruptedException e) {
		}

				
	}

	static class Buffer {
		private Queue<Integer> queue;
		private int capacity;
		
		public Buffer(int size) {
			this.queue = new LinkedList<>();
			this.capacity = size;
		}
		
		public void produce() throws InterruptedException {
			int count = 0;
			while (true) {
				synchronized (this) {
					if (queue.size() >= capacity)
						wait();
					queue.add(count);
					System.out.println("produced: " + count);
					// Increment by one.
					count++;		
					notify();
					Thread.sleep(1000);
				}

			}
		}
		
		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					if (queue.size() == 0)
						wait();
					int removed = queue.poll();
					System.out.println("consumed: " + removed);
					notify();
					Thread.sleep(1000);
				}

			}
		}
		
	}		
}
