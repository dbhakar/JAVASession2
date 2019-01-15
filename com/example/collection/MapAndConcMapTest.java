package com.example.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MapAndConcMapTest {

	Map<String,Integer> hashMap = Collections.synchronizedMap(new HashMap<String,Integer>());
	ConcurrentMap<String,Integer> concurrentMap = new ConcurrentHashMap<>();
	
	int N = 20000;

	public static void main(String[] s) {
		new MapAndConcMapTest();
	}
	
	public MapAndConcMapTest() {
		testWriting();
		testReading();
	}

	public void testWriting() {

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				addIntoHashMap();
			}).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				addIntoConcurrentMap();
			}).start();
		}
	}

	public void testReading() {

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				readFromHashMap();
			}).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				readFromConcurrentMap();
			}).start();
		}
	}

	public void addIntoHashMap() {

		for (int i = 0; i < N; i++) {
			hashMap.put("K"+i,(int)(Math.random()*1000+i));
		}
		System.out.println("HashMap additions Done");
	}

	public void addIntoConcurrentMap() {

		for (int i = 0; i < N; i++) {
			concurrentMap.put("K"+i,(int)(Math.random()*1000+i));
		}
		System.out.println("ConcurrentMap additions Done");
	}

	public void readFromHashMap() {

		hashMap.forEach((k,v)-> System.out.print(v));
		System.out.println("HashMap read Done");
	}

	public void readFromConcurrentMap() {

		concurrentMap.forEach((k,v)-> System.out.print(v));
		System.out.println("ConcurrentMap read Done");
	}

}