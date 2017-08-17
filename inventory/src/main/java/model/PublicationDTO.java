package model;

import java.util.HashSet;
import java.util.Set;

public class PublicationDTO {
	private String title = "";
	
	private Set<String> authors = new HashSet<>();
	
	private Set<String> publicationType = new HashSet<>();
	
	private Set<String> categories = new HashSet<>();
	
	private String comment = "";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
