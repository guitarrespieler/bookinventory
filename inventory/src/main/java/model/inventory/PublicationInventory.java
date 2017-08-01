package inventory;

import java.util.LinkedList;
import java.util.List;

import dto.Publication;

public class PublicationInventory {
	private List<Publication> publications = new LinkedList<>();

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
}
