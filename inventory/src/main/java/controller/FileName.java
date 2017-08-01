package controller;

public enum FileName {
	PUBLICATIONS("/publications"),
	PUBLICATIONTYPES("/publicationtypes"),
	THEMES("/themes"),
	TITLES("/titleinventory"),
	AUTHORS("/authors");
	
	private String fileName;
	private static final String extension = ".json";
	
	private FileName(String fileName){
		this.fileName = fileName + extension;
	}
	
	public String getFileName(){
		return fileName;
	}
}
