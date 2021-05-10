package com.fillipelima.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExecutorService {
	public static void main (String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable producerTask = () -> {
			int count = 0;
			while (true) {
				try {
					queue.put(count);
					System.out.println("produced: " + count);
					count++;
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable consumerTask = () -> {
			while (true) {
				try {
					int value = queue.take();
					System.out.println("consumed: " + value);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};		
		
		executor.execute(producerTask);
		executor.execute(consumerTask);
		
		executor.shutdown();
		
	}
}
