package application;

import java.util.HashSet;
import java.util.Set;

import org.controlsfx.control.textfield.TextFields;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Inventory;
import model.SubPublication;

public class newSubPublicationWindowController {
	@FXML
	private TextField subPubTitleTF;
	@FXML
	private TextField subPubAuthorTF;
	@FXML
	private TextField subPubCategoryTF;
	@FXML
	private Button subPubAddAuthorBtn;
	@FXML
	private Button subPubAddCategoryBtn;
	@FXML
	private Button subPubSaveBtn;
	
	private Set<String> authors = new HashSet<>();
	private Set<String> categories = new HashSet<>();
	
	private Set<SubPublication> subPublications = new HashSet<>();
	
	private Inventory inventory;
	
	public newSubPublicationWindowController(Inventory inventory) {
		this.inventory = inventory;
		
		initAutoComplete();
	}

	private void initAutoComplete() {
		TextFields.bindAutoCompletion(subPubTitleTF, inventory.getTitles());
		TextFields.bindAutoCompletion(subPubAuthorTF, inventory.getAuthors());
		TextFields.bindAutoCompletion(subPubCategoryTF, inventory.getCategories());
	}

	// Event Listener on Button[#subPubSaveBtn].onMouseClicked
	@FXML
	public void saveSubPublication(MouseEvent event) {
		subPublications.add(createSubPublicationFromFields());
		
		Stage stage = (Stage)subPubSaveBtn.getScene().getWindow();
		stage.close();
	}

	private SubPublication createSubPublicationFromFields() {
		SubPublication subPub = new SubPublication();
		
		subPub.getDto().setAuthors(authors);
		subPub.getDto().setCategories(categories);
		
		return subPub;
	}
}
