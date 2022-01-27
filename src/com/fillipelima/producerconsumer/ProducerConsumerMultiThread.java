package com.fillipelima.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerMultiThread {
	List<Integer> list = new ArrayList<Integer>();
	ReentrantLock lock = new ReentrantLock();

	Condition full = lock.newCondition();
	Condition empty = lock.newCondition();

	private static final int CAPACITY = 2;

	private static final int NUM_PRODUCERS = 10;

	private static final int NUM_CONSUMERS = 10;

	private ExecutorService producerExecutor = Executors.newFixedThreadPool(3);
	private ExecutorService consumerExecutor = Executors.newFixedThreadPool(3);

	public void add(Integer n) {
		lock.lock();
		System.out.println("Thread name:" + Thread.currentThread().getName());
		try {
			if (list.size() == CAPACITY)
				full.await();
			list.add(n);
			// Notify empty waiters
			empty.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public Integer get() {
		lock.lock();
		System.out.println("Thread name:" + Thread.currentThread().getName());
		try {
			if (list.size() == 0)
				empty.await();
			int removed = list.remove(0);
			// Notify full waiters
			full.signalAll();
			return removed;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			lock.unlock();
		}
	}

	private void createProducers() {
		Random random = new Random();
		for (int i = 0; i < NUM_PRODUCERS; i++) {
			Thread t = new Thread(() -> {
				while (true) {
					add(random.nextInt());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			});
			producerExecutor.submit(t);
		}
	}

	private void createConsumers() {
		for (int i = 0; i < NUM_CONSUMERS; i++) {
			Thread t = new Thread(() -> {
				while (true) {
					get();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			consumerExecutor.submit(t);
		}
	}

	private void init() {
		createProducers();
		createConsumers();
	}

	public static void main(String[] args) {
		new ProducerConsumerMultiThread().init();
	}

}
