package application;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.DateUtil;
import org.controlsfx.control.textfield.TextFields;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import model.Inventory;
import model.Publication;
import model.PublicationDTO;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;

public class newBookScreenController {
	@FXML
	private TextField titleTF;
	@FXML
	private TextField authorTF;
	@FXML
	private TextField PublicationTypeTF;
	@FXML
	private Button addAuthorBtn;
	@FXML
	private TextField categoryTF;
	@FXML
	private Button addPubTypeBtn;
	@FXML
	private TextField publisherTF;
	@FXML
	private DatePicker dateOfPublish;
	@FXML
	private Button saveBtn;
	@FXML
	private TextField roomTF;
	@FXML
	private TextField caseTF;
	@FXML
	private TextField shelfTF;
	@FXML
	private Button addCategoryBtn;
	@FXML
	private RadioButton lendableCB;
	@FXML
	private Button addSubPublicationBtn;
	@FXML
	private TextArea comment;	
	
	private Inventory inventory;
	
	private Set<String> authors = new HashSet<>();
	private Set<String> pubTypes = new HashSet<>();
	private Set<String> categories = new HashSet<>();
	private Set<String> rooms = new HashSet<>();
	private Set<String> bookCases = new HashSet<>();
	private Set<String> bookshelves = new HashSet<>();
	
	private Set<Publication> subPublications = new HashSet<>();
	
	public newBookScreenController(Inventory inventory) {
		this.inventory = inventory;
		
		bindAutoCompleteFields();
	}

	private void bindAutoCompleteFields() {
		TextFields.bindAutoCompletion(authorTF, inventory.getAuthors());
		TextFields.bindAutoCompletion(publisherTF, inventory.getPublishers());
		TextFields.bindAutoCompletion(PublicationTypeTF, inventory.getPublicatoinTypes());
		TextFields.bindAutoCompletion(categoryTF, inventory.getCategories());
		TextFields.bindAutoCompletion(roomTF, inventory.getRooms());
		TextFields.bindAutoCompletion(caseTF, inventory.getBookCases());
		TextFields.bindAutoCompletion(shelfTF, inventory.getBookShelves());		
	}
	
	@FXML
	public void saveBtnPressed(){
		Publication newPub = createPublicationFromFields();
		
		inventory.addPublication(newPub);
		
		clearSets();
	}

	private Publication createPublicationFromFields() {
		Publication newPub = new Publication();
		
		newPub.addTitle(titleTF.getText()).
		addAuthors(authors).
		addCategories(categories).
		addPublicationTypes(pubTypes).
		addSubPublications(subPublications).
		addComment(comment.getText()).
		setLendable(lendableCB.isSelected());
		
		newPub.setDateOfPublish(dateOfPublish.getValue());
		newPub.setPublisher(publisherTF.getText());
		
		return newPub;
	}

	private void clearSets() {
		authors.clear();
		pubTypes.clear();
		categories.clear();
		rooms.clear();
		bookCases.clear();
		bookshelves.clear();		
	}

}
