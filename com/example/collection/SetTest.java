package com.example.collection;

import java.util.*;

public class SetTest {

	HashSet<Book> hashSet = new HashSet<Book>();
	TreeSet<Book> treeSet = new TreeSet<Book>();
	LinkedHashSet<Book> linkedHashSet = new LinkedHashSet<Book>();
	
	int N = 50000;

	public static void main(String[] s) {
		new SetTest();
	}

	public SetTest() {
		addIntoHashSet();
		addIntoTreeSet();
		addIntoLinkedHashSet();
	}

	public void addIntoHashSet() {

		for (int i = 0; i < N; i++) {
			hashSet.add(new Book("Compete with Time",1200.00+i));
		}
		System.out.println("HashSet additions Done");
	}

	public void addIntoTreeSet() {

		for (int i = 0; i < N; i++) {
			treeSet.add(new Book("Compete with Time",1200.00+i));
		}
		System.out.println("TreeSet additions Done");
	}

	public void addIntoLinkedHashSet() {

		for (int i = 0; i < N; i++) {
			linkedHashSet.add(new Book("Compete with Time",1200.00+i));
		}
		System.out.println("LinkedHashSet additions Done");
	}


}