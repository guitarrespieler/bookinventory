package dto;

import java.util.Date;
import java.util.List;

public class Publication {
	private Author author;
	
	private Publisher publisher;
	
	private Date dateOfPublish;
	
	private Title title;
	
	private List<String> publicationType;
	
	private List<String> themes;
	
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
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Date getDateOfPublish() {
		return dateOfPublish;
	}

	public void setDateOfPublish(Date dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public List<String> getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(List<String> publicationType) {
		this.publicationType = publicationType;
	}

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}
}
