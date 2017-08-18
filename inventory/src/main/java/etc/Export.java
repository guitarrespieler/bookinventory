package etc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import model.Inventory;
import model.Publication;
import model.SubPublication;

public class Export {
	private static final String xlsxExt = ".xlsx";
	private static final String exportFileName = "könyvgyűjtemény" + xlsxExt;
	
	public static void exportInventory(Inventory inventory) throws IOException, ParseException{
		if(inventory.isEmpty())
			return;
		
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		
		Sheet publicatonSheet = workbook.createSheet("kiadványok");
		Sheet bookSheet = workbook.createSheet("művek");
		
		createHeaderRow(publicatonSheet);
		
		Set<Publication> publications = inventory.getPublications();
		
		Iterator<Publication> it = publications.iterator();
		
		int publicationSheetRowNum = 1;
		int bookSheetRowNum = 1;
		
		while (it.hasNext()) {
			Publication publication = it.next();
			
			Row row = publicatonSheet.createRow(publicationSheetRowNum++);
			
			fillRow(publication, row);
			
			if(publication.hasSubPublications()){
				Row  bookSheetRow = bookSheet.createRow(bookSheetRowNum++);
				Set<SubPublication> subpubs = publication.getSubPublications();
			}
		}
		
		writeContentToDisk(workbook);
	}

	private static void writeContentToDisk(SXSSFWorkbook workbook) throws IOException {
		File file = new File(exportFileName);
		
		if(!file.exists())
			file.createNewFile();
		
		workbook.write(new FileOutputStream(file));
	}

	private static void fillRow(Publication publication, Row row) throws ParseException {
		LinkedHashMap<String, String> values = publication.getExportData();
		
		Iterator<String> mapIter = values.keySet().iterator();
		
		int cellNum = 0;
		while (mapIter.hasNext()) {
			Cell cell = row.createCell(cellNum++);
			
			String key = mapIter.next();
			
			switch (values.get(key)) {
			case Publication.stringVal:
				cell.setCellValue(key);
				break;
			case Publication.intVal:
				cell.setCellValue(Double.parseDouble(key));
				break;
			case Publication.dateVal:
				SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
				cell.setCellValue(format.parse(key));
				break;
			default:
				cell.setCellValue(key);
				break;
			}
		}
	}

	private static Row createHeaderRow(Sheet sheet) {
		ExportHeader[] headerNames = ExportHeader.values();
		
		Row headerRow = sheet.createRow(0);
		
		for (int i = 0; i < headerNames.length; i++) {
			ExportHeader actual = headerNames[i];
			
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(actual.getHeaderName());
		}
		
		return headerRow;
		
	}
}
