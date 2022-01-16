package com.fillipelima.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
	private String name;
	private int age;
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class CompareMultipleFields {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Fillipe", 37), new Person("Fillipe", 36));
		System.out.println("Unsorted:");
		people.stream().forEach(e -> System.out.println(e));
		
		// Sort by multiple fields
		Collections.sort(people, Comparator.comparing(Person::getName).thenComparing(Person::getAge));
		
		System.out.println("");
		System.out.println("Sorted:");
		people.stream().forEach(e -> System.out.println(e));
	}
	
}
