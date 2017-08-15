package etc;

public enum ExportHeader {
	title("Cím"),
	author("Szerző"),
	date_of_publish("Kiadás dátuma"),
	publisher("Kiadó"),
	number_of_pieces("darabszám"),
	categories("kategória");
	
	private String headerName = "";
	
	private ExportHeader(String headerName){
		this.headerName = headerName;
	}
	
	public String getHeaderName(){
		return headerName;
	}
}
