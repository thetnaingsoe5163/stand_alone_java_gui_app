package ver1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TicTacToe extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
//		Cell c = new Cell();
		GameBoardUI gbUI = new GameBoardUI();
		GameBoard gb = new GameBoard(gbUI);
		HBox hb = gbUI.getUI();
		Scene s = new Scene(hb);
		stage.setScene(s);
		gb.play();
		stage.show();
	}
}