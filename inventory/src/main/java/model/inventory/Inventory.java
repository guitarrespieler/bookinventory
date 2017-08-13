package model.inventory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import model.dto.Publication;

public class Inventory {
	private List<Publication> publications = new LinkedList<>();
	
	private Set<String> authors = new HashSet<>();
	
	private Set<String> publishers = new HashSet<>();
	
	private Set<String> titles = new HashSet<>();
	
	public boolean isEmpty(){
		return publications.isEmpty() &&
				authors.isEmpty() &&
				publishers.isEmpty() &&
				titles.isEmpty();
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	public Set<String> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<String> publishers) {
		this.publishers = publishers;
	}

	public Set<String> getTitles() {
		return titles;
	}

	public void setTitles(Set<String> titles) {
		this.titles = titles;
	}
	
	
}
