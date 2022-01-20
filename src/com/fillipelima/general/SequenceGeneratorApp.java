package com.fillipelima.general;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SequenceGeneratorApp {
	public static void unsafeSequence() throws Exception {
	    int count = 1000;
	    Set<Integer> uniqueSequences = getUniqueSequencesUnsafe(new SequenceGenerator(), count);
	    System.out.println("Unsafe - count: " + count + " uniqueSequences.size(): " + uniqueSequences.size());
	}
	
	public static void safeSequence() throws Exception {
	    int count = 1000;
	    Set<Integer> uniqueSequences = getUniqueSequencesSafe(new SequenceGeneratorSafe(), count);
	    System.out.println("Safe - count: " + count + " uniqueSequences.size(): " + uniqueSequences.size());
	}	

	private static Set<Integer> getUniqueSequencesUnsafe(SequenceGenerator generator, int count) throws Exception {
	    ExecutorService executor = Executors.newFixedThreadPool(3);
	    Set<Integer> uniqueSequences = new LinkedHashSet<>();
	    List<Future<Integer>> futures = new ArrayList<>();

	    for (int i = 0; i < count; i++) {
	        futures.add(executor.submit(generator::getNextSequence));
	    }

	    for (Future<Integer> future : futures) {
	        uniqueSequences.add(future.get());
	    }

	    executor.awaitTermination(1, TimeUnit.SECONDS);
	    executor.shutdown();

	    return uniqueSequences;
	}
	
	private static Set<Integer> getUniqueSequencesSafe(SequenceGenerator generator, int count) throws Exception {
	    ExecutorService executor = Executors.newFixedThreadPool(3);
	    Set<Integer> uniqueSequences = new LinkedHashSet<>();
	    List<Future<Integer>> futures = new ArrayList<>();

	    for (int i = 0; i < count; i++) {
	        futures.add(executor.submit(generator::getNextSequence));
	    }

	    for (Future<Integer> future : futures) {
	        uniqueSequences.add(future.get());
	    }

	    executor.awaitTermination(1, TimeUnit.SECONDS);
	    executor.shutdown();

	    return uniqueSequences;
	}	
	
	public static void main(String[] args) {
		try {
			SequenceGeneratorApp.unsafeSequence();
			SequenceGeneratorApp.safeSequence();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
