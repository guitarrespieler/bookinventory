package etc;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import model.Inventory;
import model.Publication;

public class Export {
	private static final String xlsxExt = ".xlsx";
	private static final String exportFileName = "könyvgyűjtemény" + xlsxExt;
	
	public static void exportInventory(Inventory inventory){
		if(inventory.isEmpty())
			return;
		
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		
		SXSSFRow header = createRow();
		
		Set<Publication> publications = inventory.getPublications();
		
		Iterator<Publication> it = publications.iterator();
		
		while (it.hasNext()) {
			Publication publication = it.next();
			
			
		}
	}

	private static SXSSFRow createRow() {
		// TODO Auto-generated method stub
		return null;
	}
}
