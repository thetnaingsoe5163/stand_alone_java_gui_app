package com.tns.fileSearch.logic;

import com.tns.fileSearch.ui.UI;

import javafx.scene.control.Button;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UIController {
	
	private UI ui;
	
	public UIController(UI ui) {
		this.ui = ui;		
	}
	
	public void start() {
		setActionForSearch();
		setActionForClear();
	}
	
	private void setActionForSearch() {
		Button search = ui.getSubmit();
		
		search.setOnAction(a -> {
			String i1 = ui.getInput1().getText();
			String i2 = ui.getInput2().getText();
			TextArea ta = ui.getTextArea();
			
			if(i1.isBlank() || i2.isBlank()) {
				ta.setText("Input Correctly");
			}
			else {
				try {
					var finder = new FileFinder();
					var list = finder.findFile(i1, i2);
					if(list.size() != 0) {
						StringBuilder sb = new StringBuilder();
						list.forEach(s -> {
							sb.append(s + "\n");
						});
						ta.setText(sb.toString());
					}
					else {
						ta.setText("File Not Found!");
					}
				} catch (IllegalArgumentException e) {
					ta.setText(e.getMessage());
				} catch(RuntimeException e) {
					ta.setText(e.getMessage());
				} catch(Exception e) {
					e.printStackTrace();
					ta.setText(e.getMessage());
				}
			}
		});
	}
	
	private void setActionForClear() {
		Button clear = ui.getClear();
		clear.setOnAction(a -> {
			ui.getInput1().setText("");
			ui.getInput2().setText("");
			ui.getTextArea().setText("");
		});
	}
}
