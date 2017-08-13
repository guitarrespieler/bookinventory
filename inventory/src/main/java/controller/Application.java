package controller;

import model.Inventory;

public class Application {

	public static void main(String[] args) {
		
		Inventory inventory;
		
		if(Serializer.doesInventoryExist())
			inventory = Serializer.loadInventory();
		else
			inventory = new Inventory();
		
		
		
		
		
	}

}
