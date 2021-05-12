package com.fillipelima.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerClassicBetter {
	public static void main(String[] args) {
		
		MySafeQueue<Integer> queue = new MySafeQueue<Integer>(2);
		
		Thread producer = new Thread(new Runnable() {
			public void run() {
				int count = 0;
				while (true) {
					try {
						queue.produce(count);	
						System.out.println("produced by my safe queue: " + count);
						count++;
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						
					}					
				}
			}
		});

		Thread consumer = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						int consumed = queue.consume();	
						System.out.println("consumed by my safe queue: " + consumed);
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						
					}					
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
	
	static class MySafeQueue<E> {
		private Queue<E> queue;
		private int limit;
		
		public MySafeQueue(int limit) {
			this.limit = limit;
			this.queue = new LinkedList<E>();
		}
		
		public void produce(E e) throws InterruptedException {
			synchronized (this) {
				if (queue.size() >= limit)
					wait();
				queue.add(e);				
				notify();
			}			
		}
		
		public E consume() throws InterruptedException {
			synchronized (this) {
				if (queue.size() == 0)
					wait();
				E consumed = queue.poll();				
				notify();
				return consumed;
			}			
		}
		
	}
	
}
