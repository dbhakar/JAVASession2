package com.example.perf._2;

public class Main implements Runnable{
	
	Calculator calculator=new Calculator();
	ShoppingCart shoppingCart=new ShoppingCartImpl();
		
	Thread threadA,threadB=null;
	
	public Main() {
		
		
		threadA=new Thread(this,"Print");
		threadB=new Thread(this,"SpellCheck");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		threadA.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		threadB.start();

		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("Done!!!!");
	}
	
	@Override
	public void run() {
		
		if(Thread.currentThread() == threadA){
			for(int i=0;i<500;i++){
				calculator.doSum(10,3);
				calculator.doDiff(10,3);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if(Thread.currentThread() == threadB){

			for(int i=0;i<500;i++){
			
			
				Product p1=new Product("Nano", 1000000.00);
				Product p2=new Product("Audi", 1450000.00);
				Product p3=new Product("BMW", 7800000.00);
				
				shoppingCart.addItem(p1);
				shoppingCart.addItem(p1);
				shoppingCart.addItem(p1);
				shoppingCart.addItem(p1);
				shoppingCart.addItem(p1);
	
				System.out.println(shoppingCart.getBalance());
				
				shoppingCart.addItem(p2);
				shoppingCart.addItem(p3);
	
				System.out.println(shoppingCart.getBalance());
	
				try {
					shoppingCart.removeItem(p3);
					System.out.println(shoppingCart.getBalance());
				} catch (ProductNotFoundException e) {
					e.printStackTrace();
				}
				
				
				System.out.println(shoppingCart.getItemCount());
	
				shoppingCart.empty();
				
				System.out.println(shoppingCart.getItemCount());

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
