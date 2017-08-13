package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Inventory {
	private Set<Publication> publications = new HashSet<>();
	
	private Set<String> authors = new HashSet<>();
	
	private Set<String> publishers = new HashSet<>();
	
	private Set<String> titles = new HashSet<>();
	
	private Set<String> publicatoinTypes = new HashSet<>();
	
	private Set<String> categories = new HashSet<>();
	
	private Set<String> rooms = new HashSet<>();
	
	private Set<String> bookCases = new HashSet<>();
	
	private Set<String> bookShelves = new HashSet<>();
	
	public void addPublication(Publication newPub){
		if(publications.contains(newPub)){
			publications.remove(newPub);
			newPub.incrementNumberOfPieces();
		}
		publications.add(newPub);
		
		authors.add(newPub.getAuthor());
		publishers.add(newPub.getPublisher());
		titles.add(newPub.getTitle());
		publicatoinTypes.addAll(newPub.getPublicationType());
		categories.addAll(newPub.getCategories());
		rooms.add(newPub.getPlaceOfPublication().getRoom());
		bookCases.add(newPub.getPlaceOfPublication().getBookCase());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("The following publications are stored in the book inventory:\n\n");
		
		Iterator<Publication> iterator = publications.iterator();
		
		while(iterator.hasNext()){
			sb.append(iterator.next().toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public boolean isEmpty(){
		return publications.isEmpty();
	}

	public Set<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Set<Publication> publications) {
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

	public Set<String> getPublicatoinTypes() {
		return publicatoinTypes;
	}

	public void setPublicatoinTypes(Set<String> publicatoinTypes) {
		this.publicatoinTypes = publicatoinTypes;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	public Set<String> getRooms() {
		return rooms;
	}

	public void setRooms(Set<String> rooms) {
		this.rooms = rooms;
	}

	public Set<String> getBookCases() {
		return bookCases;
	}

	public void setBookCases(Set<String> bookCases) {
		this.bookCases = bookCases;
	}

	public Set<String> getBookShelves() {
		return bookShelves;
	}

	public void setBookShelves(Set<String> bookShelves) {
		this.bookShelves = bookShelves;
	}
}
