package application;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.border.TitledBorder;

import org.controlsfx.control.textfield.TextFields;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import model.SubPublication;

public class newSubPublicationWindowController implements Initializable{
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
	
	public newSubPublicationWindowController(){}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bindAutoCompleteFields();		
	}
			
	private void bindAutoCompleteFields() {
		TextFields.bindAutoCompletion(subPubTitleTF, Main.inventory.getTitles());
		TextFields.bindAutoCompletion(subPubAuthorTF, Main.inventory.getAuthors());
		TextFields.bindAutoCompletion(subPubCategoryTF, Main.inventory.getCategories());
	}

	// Event Listener on Button[#subPubSaveBtn].onMouseClicked
	@FXML
	public void saveSubPublication(MouseEvent event) {
		newBookScreenController.subPublications.add(createSubPublicationFromFields());
		
		clearFields();
		
		Main.subPublicationStage.close();
	}

	private void clearFields() {
		subPubTitleTF.clear();
		subPubAuthorTF.clear();
		subPubCategoryTF.clear();
		
		authors.clear();
		categories.clear();
	}

	private SubPublication createSubPublicationFromFields() {
		SubPublication subPub = new SubPublication();
		
		subPub.getDto().setTitle(newBookScreenController.checkNullOrEmpty(subPubTitleTF.getText()));
		
		authors.add(newBookScreenController.checkNullOrEmpty(subPubAuthorTF.getText()));
		categories.add(newBookScreenController.checkNullOrEmpty(subPubCategoryTF.getText()));
		
		subPub.getDto().setAuthors(authors);
		subPub.getDto().setCategories(categories);
		
		return subPub;
	}


}
