package com.tns.fileSearch;

import com.tns.fileSearch.logic.FileFinder;
import com.tns.fileSearch.logic.UIController;
import com.tns.fileSearch.ui.UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Search extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
		FileFinder f = new FileFinder();
		var list = f.findFile("C:\\Users\\hp\\Desktop\\Test1", "t1.txt");
		list.forEach(a -> System.out.println(a));
		
	}

	@Override
	public void start(Stage stg) throws Exception {
		UI ui = new UI();
		Pane pane = ui.getUI();
		Scene scene = new Scene(pane, 600, 610);
		stg.setResizable(false);
		stg.setScene(scene);
		
		UIController uic = new UIController(ui);
		uic.start();
		
		stg.show();
	}
}
