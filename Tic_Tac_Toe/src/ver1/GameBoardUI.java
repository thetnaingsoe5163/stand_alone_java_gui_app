package ver1;

import java.util.Iterator;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameBoardUI {

	private HBox hb;
	private BorderPane bp;
	private GridPane gp;
	private Cell[][] cells;
	private Label whoseTurnLabel;
	private Label xWinCountLabel;
	private Label oWinCountLabel;
	private Label winner;
	private Button next;
	private Button restart;
	
	public GameBoardUI() {
		this.hb = new HBox();
		this.bp = new BorderPane();
		this.gp = new GridPane();
		this.cells = new Cell[3][3];
		this.whoseTurnLabel = new Label("O's Turn");
		this.xWinCountLabel = new Label("X : " + 0);
		this.oWinCountLabel = new Label("O : " + 0);
		this.winner = new Label("Game starts");
		this.next = new Button("Next Match");
		this.restart = new Button("Restart");
		
	}

	HBox getUI() {
		settingUI();
		return this.hb;
	}
	
	Cell[][] getCells() {
		return this.cells;
	}
	
	Button getNext() {
		return this.next;
	}
	
	Button getRestart() {
		return this.restart;
	}
	
	void settingUI() {
		addToGridPane();
		addToBorderPane();
		addToHBox();

		configureHBox();
		configureGridPane();
		configureBorderPane();
		configureWinnerLabel();
		configureNextButton();
		configureRestartButton();
	}

	void addToHBox() {
		hb.getChildren().addAll(gp, bp);
	}
	
	void addToGridPane() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Cell c = new Cell(i, j);
				gp.add(c, j, i);
				cells[i][j] = c;
			}
		}
	}

	void addToBorderPane() {
		VBox vpane = new VBox();
		
		GridPane pane = createCircleToGridPaneInBorderPane();
		vpane.getChildren().addAll(whoseTurnLabel, pane, winner);

		vpane.setAlignment(Pos.CENTER);
		vpane.setMargin(whoseTurnLabel, new Insets(20, 0, 0, 0));
		vpane.setMargin(winner, new Insets(50));
		vpane.setMargin(pane, new Insets(20, 50, 0, 70));
		
		bp.setTop(vpane);
		
		GridPane forBtn = new GridPane();
		forBtn.add(next, 0, 0);
		forBtn.add(restart, 1, 0);
		forBtn.setHgap(50);
		
		bp.setCenter(forBtn);
		bp.setMargin(forBtn, new Insets(0, 50, 0, 50));
	}
	
	void setWinnerValue(String value) {
		winner.setText(value);
	}
	
	void setWhoseTurnLabel(char player) {
		if(player == ' ') whoseTurnLabel.setText("Game Over");
		else whoseTurnLabel.setText(player + "'s Turn");
	}
	
	void setXWinCount(int value) {
		this.xWinCountLabel.setText("X: " + value);
	}
	
	void setOWinCount(int value) {
		this.oWinCountLabel.setText("O: " + value);
	}
	
	void configureWinnerLabel() {
		winner.setMinSize(200, 30);
		winner.setAlignment(Pos.CENTER);
		winner.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		winner.setBorder(Border.stroke(Color.BLACK));
	}

	void configureHBox() {
//		Image img = new Image("C:\\Users\\hp\\Workspace\\My-App(2022)\\GUIProject\\Tic_Tac_Toe\\image\\bg2.png");
		Image img = new Image("image/bg2.png");
		BackgroundImage bimg = new BackgroundImage(img, null, null, null, null);
		Background bg = new Background(bimg);
		hb.setBackground(bg);
		hb.setMinHeight(500);
		hb.setMinWidth(550);

	}
	
	GridPane createCircleToGridPaneInBorderPane() {
		GridPane pane = new GridPane();
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		
		c1.setRadius(30);
		c1.setCenterX(40);
		c1.setCenterY(40);
		c1.setStroke(Color.BLUE);
		
		c2.setRadius(30);
		c2.setCenterX(40);
		c2.setCenterY(40);
		c2.setStroke(Color.BLUE);
		
		xWinCountLabel.setTextFill(Color.WHITE);
		xWinCountLabel.setPadding(new Insets(0, 0, 0, 20));
		pane.add(c1, 0, 0);
		pane.add(xWinCountLabel, 0, 0);
		
		oWinCountLabel.setTextFill(Color.WHITE);
		oWinCountLabel.setPadding(new Insets(0, 0, 0, 20));
		pane.add(c2, 1, 0);
		pane.add(oWinCountLabel, 1, 0);
		
		pane.setHgap(40);
		return pane;
	}

	void configureGridPane() {
		gp.setPadding(new Insets(70, 10, 0, 10));
	}

	void configureBorderPane() {

	}
	
	void configureNextButton() {

	}
	
	void configureRestartButton() {
		
	}
	

}
