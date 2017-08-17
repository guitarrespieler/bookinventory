package controller;

import etc.Serializer;
import model.Inventory;

public class Application {

	public static void main(String[] args) {
		
		Inventory inventory = Serializer.loadInventory();
		
		
		
		Serializer.saveInventory(inventory);	
	}

}
