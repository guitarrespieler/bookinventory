package model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Publication {
	private String title = "";
	
	private Set<String> author = new HashSet<>();
	
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
	
	public Publication(Set<String> author, String publisher, Date dateOfPublish, String title, boolean lendable,
			String comment, int numberOfPieces, Place placeOfPublication, Set<String> publicationType,
			Set<String> categories, Set<Publication> subPublications) {
		this.author = author;
		this.publisher = publisher;
		this.dateOfPublish = dateOfPublish;
		this.title = title;
		this.lendable = lendable;
		this.comment = comment;
		this.numberOfPieces = numberOfPieces;
		this.placeOfPublication = placeOfPublication;
		this.publicationType = publicationType;
		this.categories = categories;
		this.subPublications = subPublications;
	}

	public void addPublicationType(String type){publicationType.add(type);}

	public void removePublicationType(String type){publicationType.remove(type);}
	
	public void addCategory(String categoryName){categories.add(categoryName);}
	
	public void removeCategoryName(String categoryName){categories.remove(categoryName);}
	
	public void addSubPublication(Publication pub){subPublications.add(pub);}
	
	public void removeSubPublication(Publication pub){subPublications.remove(pub);}
	
	public void incrementNumberOfPieces(){
		numberOfPieces++;
	}
	
	@Override
	public String toString() {
		return title + " - " + author;
	}
	
	public int hashCode() {return (title + author + publisher).hashCode();}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(!this.getClass().equals(obj.getClass()))
			return false;
		
		Publication other = (Publication) obj;
		
		if(this.author.equals(other.author) &&
				this.publisher.equals(other.publisher) &&
				this.dateOfPublish.equals(other.dateOfPublish) &&
				this.title.equals(other.title))
			return true;
		
		return false;
	}
//getters & setters:

	public Set<String> getAuthor() {
		return author;
	}

	public void setAuthor(Set<String> author) {
		this.author = author;
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
