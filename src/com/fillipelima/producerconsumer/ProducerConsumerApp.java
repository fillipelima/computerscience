package com.fillipelima.producerconsumer;

public class ProducerConsumerApp {
	public static void main(String[] args) {

		ProducerConsumer producerConsumer = new ProducerConsumer(2);

		Thread threadProducer = new Thread(new Runnable() {
			int value = 0;

			@Override
			public void run() {
				while (true) {
					try {
						producerConsumer.produce(value++);
						System.out.println("produced: " + value);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread threadConsumer = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						int value = producerConsumer.consume();
						System.out.println("consumed: " + value);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		threadProducer.start();
		threadConsumer.start();

		try {
			threadProducer.join();
			threadConsumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
