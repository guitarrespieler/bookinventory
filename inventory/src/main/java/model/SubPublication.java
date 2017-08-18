package model;

import java.util.HashMap;
import java.util.Set;

import etc.ExportHeader;

public class SubPublication {
	private PublicationDTO dto = new PublicationDTO();
	
	private String parent = "";
	
	public SubPublication addAuthors(Set<String> authors){
		dto.getAuthors().addAll(authors);
		return this;
	}
	
	public SubPublication addCategories(Set<String> categories){
		dto.getCategories().addAll(categories);
		return this;
	}
	public SubPublication addTitle(String title){
		dto.setTitle(title);
		return this;
	}
	public SubPublication addParent(String parent){
		this.parent = parent;
		return this;
	}
	
	
	public HashMap<ExportHeader, String> getExportData() {
		HashMap<ExportHeader, String> retMap = new HashMap<>();
		
		retMap.put(ExportHeader.title, dto.getTitle());
		retMap.put(ExportHeader.author, dto.getAuthors().toString());
		retMap.put(ExportHeader.categories, dto.getCategories().toString());
		
		dto.setComment("Ez a könyv tartalmazza: " + parent);
		retMap.put(ExportHeader.comment, dto.getComment());
		
		return retMap;
	}
	

	public PublicationDTO getDto() {
		return dto;
	}

	public void setDto(PublicationDTO dto) {
		this.dto = dto;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dto == null) ? 0 : dto.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
		if (!(obj instanceof SubPublication)) {
			return false;
		}
		SubPublication other = (SubPublication) obj;
		if (dto == null) {
			if (other.dto != null) {
				return false;
			}
		} else if (!dto.equals(other.dto)) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!parent.equals(other.parent)) {
			return false;
		}
		return true;
	}
}
