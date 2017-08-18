package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import etc.Export;
import model.Inventory;
import model.Publication;

public class ExportTest {
	
	Inventory inv;
	Publication pub;
	
	@Before
	public final void Init(){
		inv = new Inventory();
		
		pub = initPublication();
		
		inv.addPublication(pub);
	}
	private Publication initPublication() {
		Publication newPub = new Publication();
		
		newPub.addTitle("Galaxis útikalaúz stopposoknak").addAuthor("Douglas Adams").
		addCategory("Scifi").addCategory("Tudomány").
		addPublicationType("könyv").
		addComment("no comment").
		setDateOfPublish(LocalDate.now());
		
		newPub.getPlaceOfPublication().setRoom("anyáék szobája");
		newPub.getPlaceOfPublication().setBookCase("első polc");
		newPub.getPlaceOfPublication().setBookShelf("alsó polc");
		
		return newPub;
	}
	@Test
	public void testExportInventory() {
		try {
			Export.exportInventory(inv);
			assertTrue(true);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertFalse(true);
		}
	}
	
	@Test
	public void testEquals(){
		assertTrue(pub.equals(pub));
		
		Publication obj1 = initPublication();
		assertTrue(pub.equals(obj1));
		assertTrue(obj1.equals(pub));
		assertEquals(pub.hashCode(), obj1.hashCode());
		
		
		assertTrue(initPublication().equals(initPublication()));
		assertEquals(initPublication().hashCode(), initPublication().hashCode());
		
		pub.addCategory("Szórakoztató irodalom");
		
		assertTrue(pub.equals(pub));
		
		assertFalse(pub.equals(obj1));
		assertFalse(obj1.equals(pub));
	}

}
