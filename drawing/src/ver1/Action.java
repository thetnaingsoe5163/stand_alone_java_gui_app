package ver1;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Action {
	
	Stage stage;
	UI ui;
	ColorPicker palette;
	Canvas canvas;
	TextField tf;
	GraphicsContext gc;
	
	double brushSize = 2;
	char[] validKey = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	Action(Stage stage, UI ui) {
		this.stage = stage;
		this.ui = ui;
		this.palette = ui.getPalette();
		this.canvas = ui.getCanvas();
		this.tf = ui.getTextField();
		this.gc = canvas.getGraphicsContext2D();
	}
	
	void startAction(Scene scene) {
		stage.setScene(scene);
		stage.show();
	}
	
	
	void setCanvasAction() {
		
		tf.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.ENTER) {
				boolean valid = false;
				String text = tf.getText();
				for(int i = 0; i < text.length(); i++) {
					for(int j = 0; j < validKey.length; j++) {
						if(text.charAt(i) == validKey[j]) {
							valid = true;
							break;
						}
					}
					if(!valid) {
						break;
					}
				}
				if(valid) {
					brushSize = Double.parseDouble(text);
				}
				if(valid && brushSize > 30) {
					brushSize = 30;
				}
			}
			
		});
		
		canvas.setOnMousePressed(e -> {
			boolean erase = ui.getErase().isSelected();
			double x = e.getX();
			double y = e.getY();
			
			if(erase) {
				gc.clearRect(x, y, brushSize, brushSize);
			} else {
				gc.setFill(palette.getValue());
				gc.fillRect(x, y, brushSize, brushSize);
			}

		});
		
		canvas.setOnMouseDragged(e -> {
			boolean erase = ui.getErase().isSelected();
			double x = e.getX();
			double y = e.getY();
			
			if(erase) {
				gc.clearRect(x, y, brushSize, brushSize);
			} else {
				gc.setFill(palette.getValue());
				gc.fillRect(x, y, brushSize, brushSize);
			}
		});
		
		ui.getClear().setOnAction(e -> {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		});
		
	}
}
