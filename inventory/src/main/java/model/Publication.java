package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import etc.ExportHeader;

public class Publication {
	private PublicationDTO dto = new PublicationDTO();
	
	private String publisher = "";
	
	private LocalDate dateOfPublish = LocalDate.now();
	
	private boolean lendable = true;
	
	private int numberOfPieces = 1;
	
	private Place placeOfPublication = new Place();
	
	private Set<SubPublication> subPublications = new HashSet<>();

	public static final String stringVal = "STRING";

	public static final String dateVal = "DATE";

	public static final String intVal = "INT";
	
	
	
	public Publication(){}
	
	public Publication addTitle(String title){
		dto.setTitle(title);
		return this;
	}
	
	public Publication addAuthor(String author){
		dto.getAuthors().add(author);
		return this;
	}
	
	public Publication addAuthors(Set<String> authors){
		dto.getAuthors().addAll(authors);
		return this;
	}
	
	public Publication addPublicationType(String type){
		dto.getPublicationType().add(type);
		return this;
	}
	
	public Publication addPublicationTypes(Set<String> types){
		dto.getPublicationType().addAll(types);
		return this;		
	}
	
	public boolean hasSubPublications(){
		return !subPublications.isEmpty();
	}
	
	public Publication addCategory(String category){
		dto.getCategories().add(category);
		return this;
	}

	public Publication addCategories(Set<String> categories){
		dto.getCategories().addAll(categories);
		return this;
	}
	
	public Publication addSubPublications(Set<SubPublication> subPubs){
		subPublications.addAll(subPubs);
		return this;
	}
	
	public Publication addComment(String comment){
		dto.setComment(comment);
		return this;
	}
	
	public void incrementNumberOfPieces(){
		numberOfPieces++;
	}
	
	@Override
	public String toString() {
		return dto.getTitle() + " - " + dto.getAuthors().toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfPublish == null) ? 0 : dateOfPublish.hashCode());
		result = prime * result + ((dto == null) ? 0 : dto.hashCode());
		result = prime * result + (lendable ? 1231 : 1237);
		result = prime * result + numberOfPieces;
		result = prime * result + ((placeOfPublication == null) ? 0 : placeOfPublication.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((subPublications == null) ? 0 : subPublications.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Publication other = (Publication) obj;
		
		if (dto == null) {
			if (other.dto != null) {
				return false;
			}
		} else if (!dto.equals(other.dto)) {
			return false;
		}		
		if (placeOfPublication == null) {
			if (other.placeOfPublication != null) {
				return false;
			}
		} else if (!placeOfPublication.equals(other.placeOfPublication)) {
			return false;
		}
		if (publisher == null) {
			if (other.publisher != null) {
				return false;
			}
		} else if (!publisher.equals(other.publisher)) {
			return false;
		}
		if (subPublications == null) {
			if (other.subPublications != null) {
				return false;
			}
		} else if (!subPublications.equals(other.subPublications)) {
			return false;
		}
		return true;
	}

//getters & setters:
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getDateOfPublish() {
		return dateOfPublish;
	}

	public void setDateOfPublish(LocalDate dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}

	public boolean isLendable() {
		return lendable;
	}

	public void setLendable(boolean lendable) {
		this.lendable = lendable;
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

	public Set<SubPublication> getSubPublications() {
		return subPublications;
	}

	public void setSubPublications(Set<SubPublication> subPublications) {
		this.subPublications = subPublications;
	}

	public PublicationDTO getDto() {
		return dto;
	}

	public void setDto(PublicationDTO dto) {
		this.dto = dto;
	}

	public HashMap<ExportHeader, String> getExportData() {
		HashMap<ExportHeader, String> retMap = new HashMap<>();
		
		retMap.put(ExportHeader.title, dto.getTitle());
		retMap.put(ExportHeader.author, dto.getAuthors().toString());
		retMap.put(ExportHeader.publisher, getPublisher());
		retMap.put(ExportHeader.date_of_publish, dateOfPublish.toString());
		retMap.put(ExportHeader.categories, dto.getCategories().toString());
		retMap.put(ExportHeader.hasSubpublications, hasSubPublications()? "igen": "nem");
		retMap.put(ExportHeader.number_of_pieces, String.valueOf(numberOfPieces));
		retMap.put(ExportHeader.comment, dto.getComment());
		retMap.put(ExportHeader.lendable, lendable? "igen": "nem");
		retMap.put(ExportHeader.room, placeOfPublication.getRoom());
		retMap.put(ExportHeader.bookCase, placeOfPublication.getBookCase());
		retMap.put(ExportHeader.bookShelf, placeOfPublication.getBookShelf());
		
		return retMap;
	}
}
