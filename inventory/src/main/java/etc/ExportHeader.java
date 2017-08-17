package etc;

public enum ExportHeader {
	title("Cím"),
	author("Szerző"),
	publisher("Kiadó"),
	date_of_publish("Kiadás dátuma"),
	categories("kategória"),
	hasSubpublications("Több művet tartalmaz"),
	number_of_pieces("darabszám"),
	comment("megjegyzés"),
	lendable("kölcsönadható"),
	room("szoba"),
	bookCase("szekrény"),
	bookShelf("polc");
	
	private String headerName = "";
	
	private ExportHeader(String headerName){
		this.headerName = headerName;
	}
	
	public String getHeaderName(){
		return headerName;
	}
}
