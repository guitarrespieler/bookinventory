package model;

public class SubPublication {
	PublicationDTO dto = new PublicationDTO();
	
	Publication parent = new Publication();

	public PublicationDTO getDto() {
		return dto;
	}

	public void setDto(PublicationDTO dto) {
		this.dto = dto;
	}

	public Publication getParent() {
		return parent;
	}

	public void setParent(Publication parent) {
		this.parent = parent;
	}
}
