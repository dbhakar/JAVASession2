package com.example.exercise;

import java.util.List;
import java.util.ArrayList;

public class MemoryTest {

    public static void main(String args[]) throws Exception{

        System.out.println("Starting the App");

	List<Car> cars = new ArrayList<>();

	for(int i=0;i<2000000;i++){
		cars.add(new Car(100,"X1","BMW",1260000.00));
		Thread.sleep(50);
	}
		
        System.out.println("Finished the App");
    }
}
