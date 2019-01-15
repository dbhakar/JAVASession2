package com.example.collection;

import java.util.*;
import java.util.stream.IntStream;

public class SortTest {

	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	int N = 10000;

	public static void main(String[] s) {
		new SortTest();
	}

	public SortTest() {
		
		addIntoArrayList();
		listOriginalSort();
		collectionSort();
		arraysSort();
	}

	public void addIntoArrayList() {

		for (int i = 0; i < N; i++) {
			arrayList.add(i);
		}
		System.out.println("ArrayList additions Done");
	}

	public void listOriginalSort() {

		arrayList.sort((a,b) -> a-b);
		
		System.out.println("listOriginalSort Done");
	}


	public void collectionSort() {

		Collections.sort(arrayList, (a,b) -> a-b);
			
		System.out.println("collectionSort Done");
	}

	public void arraysSort() {

		Arrays.sort(IntStream.range(1, N).toArray());
			
		System.out.println("arraysSort Done");
	}

}