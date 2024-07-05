package com.tns.fileSearch.ui;

import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class UI {

	private VBox mainPane;
	private HBox hb;
	private GridPane gp;
	private TextField input1;
	private TextField input2;
	private Label label1;
	private Label label2;
	private Button submit;
	private TextArea tArea;
	private Button clear;

	public UI() {
		this.mainPane = new VBox();
		this.hb = new HBox();
		this.gp = new GridPane();
		this.input1 = new TextField();
		this.input2 = new TextField();
		this.label1 = new Label();
		this.label2 = new Label();
		this.submit = new Button();
		this.tArea = new TextArea();
		this.clear = new Button();
	}

	public VBox getUI() {
		setMainPane();
		return this.mainPane;
	}

	private void setMainPane() {
		setHB();
		mainPane.getChildren().add(hb);
		
		setButton();
		mainPane.getChildren().add(submit);
		
		setTextArea();
		mainPane.getChildren().add(tArea);
		
		setButtonClear();
		mainPane.getChildren().add(clear);
		
		mainPane.setPadding(new Insets(20, 0, 0, 10));
		
		mainPane.setSpacing(20);
	}
	
	private void setButton() {
		submit.setText("Search");
		submit.setMinWidth(100);
		submit.setMinHeight(25);			
	}
	
	private void setButtonClear() {
		clear.setText("Clear");
		clear.setMinWidth(100);
		clear.setMinHeight(25);			
	}
	
	private void setTextArea() {		
		tArea.setMinHeight(400);
		tArea.setMaxWidth(580);
	}
	
	private void setHB() {

		setLabelAndInput();

		setGridPane();

		hb.getChildren().add(gp);
	}

	private void setGridPane() {
		gp.add(label1, 0, 0);
		gp.add(input1, 1, 0);

		gp.add(label2, 0, 1);
		gp.add(input2, 1, 1);

		gp.setVgap(10);
		gp.setHgap(20);

	}

	private void setLabelAndInput() {
		label1.setText("Enter Target Folder: ");
		label2.setText("Enter Searched File: ");
		
		input1.setMinWidth(450);
		input1.setMinHeight(30);
		
		input2.setMaxWidth(200);
		input2.setMinHeight(30);
	}
	
	public TextField getInput1() {
		return this.input1;
	}
	
	public TextField getInput2() {
		return this.input2;
	}
	
	public Button getSubmit() {
		return this.submit;
	}
	
	public TextArea getTextArea() {
		return this.tArea;
	}
	
	public Button getClear() {
		return this.clear;
	}
}
