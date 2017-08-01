package model.inventory;

import java.util.LinkedList;
import java.util.List;

import model.dto.Author;


public class AuthorInventory {
	
	private List<Author> authors = new LinkedList<>();
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
