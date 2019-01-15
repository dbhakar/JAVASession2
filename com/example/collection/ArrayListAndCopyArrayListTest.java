package com.example.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListAndCopyArrayListTest {

	List<Integer> arrayList = Collections.synchronizedList(new ArrayList<Integer>());
	CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();

	int N = 20000;

	public static void main(String[] s) {
		new ArrayListAndCopyArrayListTest();
	}

	public ArrayListAndCopyArrayListTest() {
		testWriting();
		testReading();
	}

	public void testWriting() {

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				addIntoArrayList();
			}).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				addIntoCopyArrayList();
			}).start();
		}
	}

	public void testReading() {

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				readFromArrayList();
			}).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				readFromCopyArrayList();
			}).start();
		}
	}

	public void addIntoArrayList() {

		for (int i = 0; i < N; i++) {
			arrayList.add(i);
		}
		System.out.println("ArrayList additions Done");
	}

	public void addIntoCopyArrayList() {

		for (int i = 0; i < N; i++) {
			copyOnWriteArrayList.add(i);
		}
		System.out.println("CopyOnWriteArrayList additions Done");
	}

	public void readFromArrayList() {

		for (int i = 0; i < N; i++) {
			arrayList.get(i);
		}
		System.out.println("ArrayList read Done");
	}

	public void readFromCopyArrayList() {

		for (int i = 0; i < N; i++) {
			copyOnWriteArrayList.get(i);
		}
		System.out.println("CopyOnWriteArrayList read Done");
	}

}