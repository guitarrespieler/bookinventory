package model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Publication {
	private String title = "";
	
	private Set<String> authors = new HashSet<>();
	
	private String publisher = "";
	
	private Date dateOfPublish = Calendar.getInstance().getTime();
	
	private boolean lendable = true;
	
	private String comment = "";
	
	private int numberOfPieces = 1;
	
	private Place placeOfPublication = new Place();
	
	private Set<String> publicationType = new HashSet<>();
	
	private Set<String> categories = new HashSet<>();
	
	private Set<Publication> subPublications = new HashSet<>();
	
	public Publication(){}
	
	public Publication addAuthor(String author){
		authors.add(author);
		return this;
	}
	
	public Publication addPublicationType(String type){
		publicationType.add(type);
		return this;		
	}

	public Publication addCategory(String categoryName){
		categories.add(categoryName);
		return this;
	}
	
	public Publication addSubPublication(Publication pub){
		subPublications.add(pub);
		return this;
	}
	
	public void incrementNumberOfPieces(){
		numberOfPieces++;
	}
	
	@Override
	public String toString() {
		return title + " - " + authors;
	}
	
	public int hashCode() {return (title + authors.toString() + publisher).hashCode();}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(!this.getClass().equals(obj.getClass()))
			return false;
		
		Publication other = (Publication) obj;
		
		return this.authors.equals(other.authors) &&
				this.publisher.equals(other.publisher) &&
				this.title.equals(other.title);
	}
//getters & setters:

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> author) {
		this.authors = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getDateOfPublish() {
		return dateOfPublish;
	}

	public void setDateOfPublish(Date dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isLendable() {
		return lendable;
	}

	public void setLendable(boolean lendable) {
		this.lendable = lendable;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getNumberOfPieces() {
		return numberOfPieces;
	}

	public void setNumberOfPieces(int numberOfPieces) {
		this.numberOfPieces = numberOfPieces;
	}

	public Place getPlaceOfPublication() {
		return placeOfPublication;
	}

	public void setPlaceOfPublication(Place placeOfPublication) {
		this.placeOfPublication = placeOfPublication;
	}

	public Set<String> getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(Set<String> publicationType) {
		this.publicationType = publicationType;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	public Set<Publication> getSubPublications() {
		return subPublications;
	}

	public void setSubPublications(Set<Publication> subPublications) {
		this.subPublications = subPublications;
	}
}
