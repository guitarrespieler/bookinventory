package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import etc.Export;
import model.Inventory;
import model.Publication;

public class ExportTest {
	
	Inventory inv;
	
	@Before
	public final void Init(){
		inv = new Inventory();
		
		Publication pub = new Publication();
		
		pub.addAuthor("Douglas Adams").
		addCategory("Scifi").addCategory("Tudomány").
		addPublicationType("könyv").
		setDateOfPublish(Calendar.getInstance().getTime());
		
		pub.getDto().setTitle("Galaxis útikalaúz stopposoknak");
		pub.getDto().setComment("nocomment..");
		pub.getPlaceOfPublication().setRoom("anyáék szobája");
		pub.getPlaceOfPublication().setBookCase("első polc");
		pub.getPlaceOfPublication().setBookShelf("alsó polc");
		
		inv.addPublication(pub);
	}
	@Test
	public final void testExportInventory() {
		try {
			Export.exportInventory(inv);
			assertTrue(true);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertFalse(true);
		}
		
	}

}
