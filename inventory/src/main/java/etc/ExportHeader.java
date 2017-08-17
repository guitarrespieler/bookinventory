package etc;

public enum ExportHeader {
	title("Cím"),
	author("Szerző"),
	publisher("Kiadó"),
	date_of_publish("Kiadás dátuma"),
	number_of_pieces("darabszám"),
	categories("kategória"),
	comment("megjegyzés"),
	lendable("kölcsönadható");
	
	
	private String headerName = "";
	
	private ExportHeader(String headerName){
		this.headerName = headerName;
	}
	
	public String getHeaderName(){
		return headerName;
	}
}
