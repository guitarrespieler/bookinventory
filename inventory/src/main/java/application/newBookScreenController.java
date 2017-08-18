package application;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.sun.javafx.scene.control.skin.TextFieldSkin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import model.Inventory;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

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
	private Label titleLbl;
	@FXML
	private Label authorLbl;
	@FXML
	private Label publisherLbl;
	@FXML
	private Label dateOfPublishLbl;
	@FXML
	private Label categoryLbl;
	@FXML
	private Label pubTypeLbl;
	@FXML
	private Label placeLbl;
	@FXML
	private Label subPubsLbl;
	
	private Inventory inventory;
	
	public newBookScreenController(Inventory inventory) {
		this.inventory = inventory;
	}
	

}
