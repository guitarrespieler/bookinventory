package etc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
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
		
		createPublicationHeaderRow(publicatonSheet);
		createBookSheetHeaderRow(bookSheet);
		
		
		Set<Publication> publications = inventory.getPublications();
		
		Iterator<Publication> it = publications.iterator();
		
		int publicationSheetRowNum = 1;
		int bookSheetRowNum = 1;
		
		while (it.hasNext()) {
			Publication publication = it.next();
			
			Row row = publicatonSheet.createRow(publicationSheetRowNum++);
			
			HashMap<ExportHeader, String> publicationExportData = publication.getExportData();
			fillRow(publicationExportData, row);
			
			Row  bookSheetRow = bookSheet.createRow(bookSheetRowNum++);
			
			if(publication.hasSubPublications()){				
				Iterator<SubPublication> iterator = publication.getSubPublications().iterator();				
				while (iterator.hasNext()) {
					SubPublication subPublication = iterator.next();					
					fillRow(subPublication.getExportData(), bookSheetRow);					
				}				
			}else{
				Map<ExportHeader, String> bookSheetData = new HashMap<>();				
				bookSheetData.put(ExportHeader.title, publicationExportData.get(ExportHeader.title));
				bookSheetData.put(ExportHeader.author, publicationExportData.get(ExportHeader.author));
				bookSheetData.put(ExportHeader.categories, publicationExportData.get(ExportHeader.categories));
				bookSheetData.put(ExportHeader.comment, publicationExportData.get(ExportHeader.comment));
				
				fillRow(bookSheetData, bookSheetRow);
			}
		}		
		writeContentToDisk(workbook);
	}

	private static void createBookSheetHeaderRow(Sheet bookSheet) {
		Row row = bookSheet.createRow(0);
		
		row.createCell(0).setCellValue(ExportHeader.title.getHeaderName());
		row.createCell(1).setCellValue(ExportHeader.author.getHeaderName());
		row.createCell(2).setCellValue(ExportHeader.categories.getHeaderName());
		row.createCell(3).setCellValue(ExportHeader.comment.getHeaderName());		
	}

	private static void writeContentToDisk(SXSSFWorkbook workbook) throws IOException {
		File file = new File(exportFileName);
		
		if(!file.exists())
			file.createNewFile();
		
		workbook.write(new FileOutputStream(file));
	}

	private static void fillRow(Map<ExportHeader, String> values, Row row) throws ParseException {
		ExportHeader[] headers = ExportHeader.values();
		
		int cellNum = 0;
		
		for(int i = 0; i < headers.length; i++){
			ExportHeader key = headers[i];
			if(!values.containsKey(key))
				continue;
			
			Cell cell = row.createCell(cellNum++);
			
			switch (key) {
			case number_of_pieces:
				cell.setCellValue(Double.parseDouble(values.get(key)));
				break;
			case date_of_publish:
				SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
				cell.setCellValue(format.parse(values.get(key)));
				break;
			default:
				cell.setCellValue(values.get(key));
				break;
			}
		}
	}

	private static Row createPublicationHeaderRow(Sheet sheet) {
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
