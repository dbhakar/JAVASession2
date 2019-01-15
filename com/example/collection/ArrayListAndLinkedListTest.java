package com.example.collection;

import java.util.*;

public class ArrayListAndLinkedListTest {

	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	
	int N = 50000;

	public static void main(String[] s) {
		new ArrayListAndLinkedListTest();
	}

	public ArrayListAndLinkedListTest() {
		
		addIntoArrayList();
		addIntoLinkedList();
		
		readFromArrayList();
		readFromLinkedList();
		
		removeFromArrayList();
		removeFromLinkedList();
		
	}

	public void addIntoArrayList() {

		for (int i = 0; i < N; i++) {
			arrayList.add(i);
		}
		System.out.println("ArrayList additions Done");
	}

	public void addIntoLinkedList() {

		for (int i = 0; i < N; i++) {
			linkedList.add(i);
		}
		System.out.println("LinkedList additions Done");
	}

	public void readFromArrayList() {

		for (int i = 0; i < N; i++) {
			arrayList.get(i);
		}
		System.out.println("ArrayList reading done");
	}

	public void readFromLinkedList() {

		for (int i = 0; i < N; i++) {
			linkedList.get(i);
		}
		System.out.println("LinkedList reading done");
	}

	public void removeFromArrayList() {

		for (int i = N; i >= 0; i--) {
			arrayList.remove(i);
		}
		System.out.println("ArrayList removel done");
	}

	public void removeFromLinkedList() {

		for (int i = N; i >= 0; i--) {
			linkedList.remove(i);
		}

		System.out.println("LinkedList removel done");
	}

}