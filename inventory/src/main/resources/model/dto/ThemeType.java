package dto;

import java.util.LinkedList;
import java.util.List;

public class ThemeType {
	
	private List<String> themes;
	
	public ThemeType() {
		themes = new LinkedList<>();
	}

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}
	
	

}
