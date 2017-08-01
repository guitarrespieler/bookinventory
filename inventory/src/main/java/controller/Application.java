package controller;

import model.dto.Author;
import model.inventory.AuthorInventory;

public class Application {

	public static void main(String[] args) {
		Serializer serializer = new Serializer();
		
		serializer.createInventoryFiles();
		
		AuthorInventory authors = new AuthorInventory();
		
		authors.getAuthors().add(new Author("George R.R. Martin"));
		authors.getAuthors().add(new Author("J.K. Rowling"));
		authors.getAuthors().add(new Author("Arany János"));
		authors.getAuthors().add(new Author("Petőfi Sándor"));
		
		

		serializer.serialize(authors);
		
		AuthorInventory deserialized = serializer.deserializeAuthorInventory();
		
		System.out.println(deserialized.toString());
	}

}
