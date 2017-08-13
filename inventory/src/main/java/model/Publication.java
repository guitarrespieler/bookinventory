package model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Publication {
	private String author = "";
	
	private String publisher = "";
	
	private Date dateOfPublish = Calendar.getInstance().getTime();
	
	private String title = "";
	
	private boolean lendable = true;
	
	private String comment = "";
	
	private int numberOfPieces = 1;
	
	private Place placeOfPublication = new Place();
	
	private Set<String> publicationType = new HashSet<>();
	
	private Set<String> categories = new HashSet<>();
	
	private Set<Publication> subPublications = new HashSet<>();
	
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
	
	public String getAuthor() {return author;}

	public void setAuthor(String author) {this.author = author;}

	public String getPublisher() {return publisher;}

	public void setPublisher(String publisher) {this.publisher = publisher;}

	public Date getDateOfPublish() {return dateOfPublish;}

	public void setDateOfPublish(Date dateOfPublish) {this.dateOfPublish = dateOfPublish;}

	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}
	
	public void addPublicationType(String type){publicationType.add(type);}

	public void removePublicationType(String type){publicationType.remove(type);}
	
	public Object[] getPublicationTypes(){return publicationType.toArray();}
	
	public void addCategory(String categoryName){categories.add(categoryName);}
	
	public void removeCategoryName(String categoryName){categories.remove(categoryName);}
	
	public Object[] getcategories() {return categories.toArray();}
	
	public void addSubPublication(Publication pub){subPublications.add(pub);}
	
	public void removeSubPublication(Publication pub){subPublications.remove(pub);}
	
	public Object[] getSubPublications(){return subPublications.toArray();}

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

	public void setSubPublications(Set<Publication> subPublications) {
		this.subPublications = subPublications;
	}
}
