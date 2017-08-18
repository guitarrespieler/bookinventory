package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Publication {
	private PublicationDTO dto = new PublicationDTO();
	
	private String publisher = "";
	
	private LocalDate dateOfPublish = LocalDate.now();
	
	private boolean lendable = true;
	
	private int numberOfPieces = 1;
	
	private Place placeOfPublication = new Place();
	
	private Set<Publication> subPublications = new HashSet<>();

	public static final String stringVal = "STRING";

	public static final String dateVal = "DATE";

	public static final String intVal = "INT";
	
	public Publication(){}
	
	public Publication addTitle(String title){
		dto.setTitle(title);
		return this;
	}
	
	public Publication addAuthors(Set<String> authors){
		dto.getAuthors().addAll(authors);
		return this;
	}
	
	public Publication addPublicationTypes(Set<String> types){
		dto.getPublicationType().addAll(types);
		return this;		
	}
	
	public boolean hasSubPublications(){
		return !subPublications.isEmpty();
	}

	public Publication addCategories(Set<String> categories){
		dto.getCategories().addAll(categories);
		return this;
	}
	
	public Publication addSubPublications(Set<Publication> subPubs){
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
	
	public int hashCode() {return (dto.getTitle() + dto.getAuthors().toString() + publisher).hashCode();}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(!this.getClass().equals(obj.getClass()))
			return false;
		
		Publication other = (Publication) obj;
		
		return dto.getAuthors().equals(other.dto.getAuthors()) &&
				this.publisher.equals(other.publisher) &&
				dto.getTitle().equals(other.dto.getTitle());
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

	public Set<Publication> getSubPublications() {
		return subPublications;
	}

	public void setSubPublications(Set<Publication> subPublications) {
		this.subPublications = subPublications;
	}

	public PublicationDTO getDto() {
		return dto;
	}

	public void setDto(PublicationDTO dto) {
		this.dto = dto;
	}

	/**
	 * Key: value to write into the export file
	 * value: type of the data (String, Date ? )
	 * @return
	 */
	public LinkedHashMap<String, String> getExportData() {
		LinkedHashMap<String, String> retMap = new LinkedHashMap<>();
		
		retMap.put(dto.getTitle(), stringVal);
		retMap.put(dto.getAuthors().toString(), stringVal);
		retMap.put(publisher, stringVal);
		retMap.put((new SimpleDateFormat("YYYY-MM-DD").format(dateOfPublish)), dateVal);
		retMap.put(dto.getCategories().toString(), stringVal);
		retMap.put(hasSubPublications()? "igen": "nem", stringVal);
		retMap.put(String.valueOf(numberOfPieces), intVal);
		retMap.put(dto.getComment(), stringVal);
		retMap.put(lendable? "igen": "nem", stringVal);
		retMap.put(placeOfPublication.getRoom(), stringVal);
		retMap.put(placeOfPublication.getBookCase(), stringVal);
		retMap.put(placeOfPublication.getBookShelf(), stringVal);
		
		return retMap;
	}
}
