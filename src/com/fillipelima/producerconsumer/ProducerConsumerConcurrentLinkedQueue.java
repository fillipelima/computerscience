package com.fillipelima.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerConcurrentLinkedQueue {
	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(2);
						
		Thread t1 = new Thread(()-> {
			int count = 0;
			while (true) {
				System.out.println("produced: " + count);
				try {
					queue.put(count++);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2 = new Thread(()-> {
			while (true) {				
				try {
					System.out.println("consumed: " + queue.take());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
