package com.example.perf._2;

import java.util.ArrayList;
import java.util.Iterator;


public class ShoppingCartImpl implements ShoppingCart {

	private ArrayList<Product> items;

	public ShoppingCartImpl() {
		items = new ArrayList<Product>();
	}

	/* (non-Javadoc)
	 * @see com.ibm.service.impl.ShoppingCart#getBalance()
	 */
	@Override
	public double getBalance() {
		double balance = 0.00;
		for (Iterator<Product> i = items.iterator(); i.hasNext();) {
			Product item = (Product) i.next();
			balance += item.getPrice();
		}
	
		return balance;
	}

	/* (non-Javadoc)
	 * @see com.ibm.service.impl.ShoppingCart#addItem(com.ibm.service.impl.Product)
	 */
	@Override
	public void addItem(Product item) {
		items.add(item);
	}

	/* (non-Javadoc)
	 * @see com.ibm.service.impl.ShoppingCart#removeItem(com.ibm.service.impl.Product)
	 */
	@Override
	public void removeItem(Product item) throws ProductNotFoundException {
		if (!items.remove(item)) {
			throw new ProductNotFoundException();
		}
	}

	/* (non-Javadoc)
	 * @see com.ibm.service.impl.ShoppingCart#getItemCount()
	 */
	@Override
	public int getItemCount() {
		return items.size();
	}

	/* (non-Javadoc)
	 * @see com.ibm.service.impl.ShoppingCart#empty()
	 */
	@Override
	public void empty() {
		items.clear();
	}
}
