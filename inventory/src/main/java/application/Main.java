package application;
	
import etc.Serializer;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Inventory;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static BorderPane newBookScreen;
	public static BorderPane subPubPopup;
	
	public static Stage newBookStage;
	public static Stage subPublicationStage;
	
	public static Inventory inventory;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			newBookScreen = (BorderPane)FXMLLoader.load(getClass().getResource("newBookScreen.fxml"));
			subPubPopup = (BorderPane)FXMLLoader.load(getClass().getResource("newSubPublicationWindow.fxml"));
						
			Scene scene = new Scene(newBookScreen,1000,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			newBookStage = primaryStage;
			
			Scene scene2 = new Scene(Main.subPubPopup,600,320);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			subPublicationStage = new Stage();
			subPublicationStage.setScene(scene2);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		inventory = Serializer.loadInventory();		
		launch(args);	
	}
}
