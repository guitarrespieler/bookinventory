package inventory;

import java.util.LinkedList;
import java.util.List;

public class PublicationTypes {
	private List<String> types = new LinkedList<>();

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}
}