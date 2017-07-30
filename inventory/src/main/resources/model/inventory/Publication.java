package inventory;

import java.util.Date;

public class Publication {
	private String author;
	
	private Publisher publisher;
	
	private Date dateOfPublish;
	
	private Title title;
	
	private PublicationType type;
	
	private ThemeType theme;
	
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
				this.title.equals(other.title) &&
				this.type.equals(other.type))
			return true;
		
		return false;
	}
	
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
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

	public PublicationType getType() {
		return type;
	}

	public void setType(PublicationType type) {
		this.type = type;
	}
	
	

}
