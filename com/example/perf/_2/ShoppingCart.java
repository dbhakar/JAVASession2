package com.example.perf._2;

public interface ShoppingCart {

	public abstract double getBalance();

	public abstract void addItem(Product item);

	public abstract void removeItem(Product item)
			throws ProductNotFoundException;

	public abstract int getItemCount();

	public abstract void empty();

}