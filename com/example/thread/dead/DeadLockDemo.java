package com.example.thread.dead;

public class DeadLockDemo implements Runnable {

	String notepad="Boss Notepad";
	String pen="Reynold Pen";
	
	Thread  threadA,threadB;
	
	@Override
	public void run() {

		if(Thread.currentThread() == threadA){
			synchronized (notepad) {
				System.out.println("Thread A   ----  Got Notepad");
				
				synchronized (pen) {
					System.out.println("Thread A   ----  Got Pen");
				}
			}
			
		}
		
		if(Thread.currentThread() == threadB){
				synchronized (pen) {
					System.out.println("Thread B   ----  Got Pen");
					
					synchronized (notepad) {
						System.out.println("Thread B   ----  Got Notepad");
					}
				}
		}
	}

	public DeadLockDemo() {
		
		threadA=new Thread(this,"Thread A");
		threadB=new Thread(this,"Thread B");

		
		
		threadA.start();
		threadB.start();

		
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}


	public static void main(String[] args) {
		new DeadLockDemo();
	}
}
