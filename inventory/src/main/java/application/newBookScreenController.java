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
import model.Place;
import model.Publication;
import model.PublicationDTO;
import model.SubPublication;
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
	
	private Set<SubPublication> subPublications = new HashSet<>();
	
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
		clearFields();
	}

	private void clearFields() {
		authorTF.clear();
		caseTF.clear();
		categoryTF.clear();
		PublicationTypeTF.clear();
		publisherTF.clear();
		roomTF.clear();
		shelfTF.clear();
		titleTF.clear();
		
	}

	private Publication createPublicationFromFields() {
		Publication newPub = new Publication();
		
		newPub.addTitle(checkNullOrEmpty(titleTF.getText())).
		addAuthors(authors).
		addCategories(categories).
		addPublicationTypes(pubTypes).
		addSubPublications(subPublications).
		addComment(checkNullOrEmpty(comment.getText())).
		setLendable(lendableCB.isSelected());
		
		newPub.setDateOfPublish(dateOfPublish.getValue() == null? LocalDate.now() : dateOfPublish.getValue());
		newPub.setPublisher(checkNullOrEmpty(publisherTF.getText()));
		
		Place place = new Place(checkNullOrEmpty(roomTF.getText()), 
								checkNullOrEmpty(caseTF.getText()), 
								checkNullOrEmpty(shelfTF.getText()));
		
		newPub.setPlaceOfPublication(place);
		
		return newPub;
	}

	private void clearSets() {
		authors.clear();
		pubTypes.clear();
		categories.clear();
	}
	
	private String checkNullOrEmpty(String value){
		if(value == null)
			return "";
		if(value.isEmpty())
			return "";
		return value;
	}

}
