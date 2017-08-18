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
