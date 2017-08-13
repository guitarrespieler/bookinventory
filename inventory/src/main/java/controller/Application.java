package controller;

import java.util.Calendar;

import model.Inventory;
import model.Publication;

public class Application {

	public static void main(String[] args) {
		
		Inventory inventory;
		
		if(Serializer.doesInventoryExist())
			inventory = Serializer.loadInventory();
		else
			inventory = new Inventory();
		
		Publication book = new Publication();
		
		book.setTitle("Galaxis útikalaúz stopposoknak");	
		
		book.addAuthor("Douglas Adams")
			.addCategory("SciFi")
			.addPublicationType("könyv")
			.setDateOfPublish(Calendar.getInstance().getTime());
		
		book.setComment("dummy comment");
		
		inventory.addPublication(book);
		
		Serializer.saveInventory(inventory);	
	}

}
