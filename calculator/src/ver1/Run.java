package ver1;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Run extends Application {

	public static void main(String[] args) {
		
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		UI ui = new UI();
		Action action = new Action(ui);
		action.setButtonAction();
		action.setKeyAction();
		VBox gp = ui.getUI();
		
		
		Scene scene = new Scene(gp);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
		action.getTextFile().setEditable(false);
		action.getTextFile().requestFocus();
		
	}

}