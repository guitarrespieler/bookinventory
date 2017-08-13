package model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Publication {
	private String author = "";
	
	private String publisher = "";
	
	private Date dateOfPublish = Calendar.getInstance().getTime();
	
	private String title = "";
	
	private boolean lendable = true;
	
	private String comment = "";
	
	private Set<String> publicationType = new HashSet<>();
	
	private Set<String> categories = new HashSet<>();
	
	private List<Publication> subPublications = new LinkedList<>();
	
	public int hashCode() {return (title + author + publisher + dateOfPublish.toString()).hashCode();}

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
}
