package ver1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class UI {
	
	private VBox vb;
	private BorderPane bp;
	private GridPane gp;
	private TextField tf;
	private Button[] buttons;
	
	private int numberOfButtons;
	
	private char[][] key = {
			{'1', '2', '3', '+'},
			{'4', '5', '6', '-'},
			{'7', '8', '9', '*'},
			{'^', '0', '.', '/'},
			{'(', ')', '=', 'C'}
	};
	
	UI() {
		vb = new VBox();
		bp = new BorderPane();
		gp = new GridPane();
		tf = new TextField();
		
		numberOfButtons = computeNumberOfKeys();
		buttons = new Button[numberOfButtons];
		
		configGridPane();
		configBorderPane();
		
		setTextArea();
		setButton();
		setUI();
	}
	
	VBox getUI() {
		return vb;
	}
	
	TextField getTextField() {
		return tf;
	}
	
	Button[] getButtons() {
		return buttons;
	}
	
	int computeNumberOfKeys() {
		int value = 0;
		for(int i = 0; i < key.length; i++) {
			for(int j = 0; j < key[i].length; j++) {
				value++;
			}
		}
		return value;
	}
	
	void configGridPane() {
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(20, 20, 20, 20));
		gp.prefWidthProperty().bind(vb.widthProperty());
		gp.setAlignment(Pos.CENTER);
	}
	
	void configBorderPane() {
		bp.setPadding(new Insets(10, 10, 0, 10));
		bp.prefWidthProperty().bind(vb.heightProperty());
	}
	
	void setTextArea() {
		bp.setCenter(tf);
	}
	
	void setButton() {
		int value = 0;
		for(int i = 0; i < key.length; i++) {
			for(int j = 0; j < key[i].length; j++) {
				Button btn = new Button(Character.toString(key[i][j]));
				btn.setMinWidth(30);
				btn.setMinHeight(30);
				gp.add(btn, j, i);
				buttons[value] = btn;
				value++;
			}
		}
	}
	
	void setUI() {
		vb.getChildren().addAll(bp, gp);
	}
}
