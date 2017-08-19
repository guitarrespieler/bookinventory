package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import org.controlsfx.control.textfield.TextFields;

import etc.Export;
import etc.Serializer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Place;
import model.Publication;
import model.SubPublication;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class newBookScreenController implements Initializable{
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
	@FXML
	private Label kiadvanyokSzamaLbl;
	
	private Set<String> authors = new HashSet<>();
	private Set<String> pubTypes = new HashSet<>();
	private Set<String> categories = new HashSet<>();
	
	public static Set<SubPublication> subPublications = new HashSet<>();
	
	public newBookScreenController(){}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bindAutoCompleteFields();
		
		//WoW :OOOOO
		//method pointers in Java??? Just wow.
		
		addAuthorBtn.setOnMouseClicked(this::addAuthor);
		addPubTypeBtn.setOnMouseClicked(this::addPublicationType);
		saveBtn.setOnMouseClicked(this::saveBtnClicked);
		addCategoryBtn.setOnMouseClicked(this::addCategory);
		addSubPublicationBtn.setOnMouseClicked(this::addSubPublication);
	}

	private void bindAutoCompleteFields() {
		TextFields.bindAutoCompletion(titleTF, Main.inventory.getTitles());
		TextFields.bindAutoCompletion(authorTF, Main.inventory.getAuthors());
		TextFields.bindAutoCompletion(publisherTF, Main.inventory.getPublishers());
		TextFields.bindAutoCompletion(PublicationTypeTF, Main.inventory.getPublicatoinTypes());
		TextFields.bindAutoCompletion(categoryTF, Main.inventory.getCategories());
		TextFields.bindAutoCompletion(roomTF, Main.inventory.getRooms());
		TextFields.bindAutoCompletion(caseTF, Main.inventory.getBookCases());
		TextFields.bindAutoCompletion(shelfTF, Main.inventory.getBookShelves());		
	}
	
	// Event Listener on Button[#addAuthorBtn].onMouseClicked
	@FXML
	public void addAuthor(MouseEvent event) {
		authors.add(checkNullOrEmpty(authorTF.getText()));
		authorTF.clear();
		bindAutoCompleteFields();
	}
	// Event Listener on Button[#addPubTypeBtn].onMouseClicked
	@FXML
	public void addPublicationType(MouseEvent event) {
		pubTypes.add(checkNullOrEmpty(PublicationTypeTF.getText()));
		PublicationTypeTF.clear();
		bindAutoCompleteFields();
	}
	// Event Listener on Button[#saveBtn].onMouseClicked
	@FXML
	public void saveBtnClicked(MouseEvent event) {
		Publication newPub = createPublicationFromFields();
		
		Main.inventory.addPublication(newPub);
		kiadvanyokSzamaLbl.setText(String.valueOf(Main.inventory.getPublications().size()));
		
		addParentsToSubPublications(newPub.getDto().getTitle());
		
		bindAutoCompleteFields();
		
		clearSets();
		clearFields();
		
		Serializer.saveInventory(Main.inventory);
		
	}
	
	private Publication createPublicationFromFields() {
		addAuthor(null);
		addCategory(null);
		addPublicationType(null);
		
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
	
	private void addParentsToSubPublications(String parentPubTitle) {
		Iterator<SubPublication> iterator = subPublications.iterator();
		
		while (iterator.hasNext()) {
			iterator.next().setParent(parentPubTitle);		
		}
	}

	// Event Listener on Button[#addCategoryBtn].onMouseClicked
	@FXML
	public void addCategory(MouseEvent event) {
		categories.add(checkNullOrEmpty(categoryTF.getText()));
		categoryTF.clear();
		bindAutoCompleteFields();
	}
	// Event Listener on Button[#addSubPublicationBtn].onMouseClicked
	@FXML
	public void addSubPublication(MouseEvent event) {
		Main.subPublicationStage.show();
	}
	
	@FXML
	public void createExcelExport(MouseEvent event){
		try {
			Export.exportInventory(Main.inventory);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	private void clearSets() {
		authors.clear();
		pubTypes.clear();
		categories.clear();
	}
	
	public static String checkNullOrEmpty(String value){
		if(value == null)
			return "";
		if(value.isEmpty())
			return "";
		return value;
	}
}
