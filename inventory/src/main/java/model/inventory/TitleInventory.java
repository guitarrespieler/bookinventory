package model.inventory;

import java.util.LinkedList;
import java.util.List;

import model.dto.Title;


public class TitleInventory {

	private List<Title> titles = new LinkedList<>();

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}
}
