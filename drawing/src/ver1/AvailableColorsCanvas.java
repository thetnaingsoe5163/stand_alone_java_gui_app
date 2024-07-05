package ver1;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

public class AvailableColorsCanvas extends GridPane {
	
	private ArrayList<Color> colors;
	private ArrayList<Pane> colorPanes;
	private GridPane gp;
	
	public AvailableColorsCanvas() {
		this.gp = new GridPane();
		this.colors = new ArrayList();
		this.colorPanes = new ArrayList();
		setAvailableColors();
	}
	
	public GridPane getAvailableColorsCanvas() {
		setUpAvailableColorsCanvas();
		return this.gp;
	}
	
	public ArrayList<Color> getColors() {
		return (ArrayList<Color>)colors.clone();
	}
	
	public ArrayList<Color> getColorPanes() {
		return (ArrayList<Color>)colorPanes.clone();
	}
	
	public void setUpAvailableColorsCanvas() {
		addPaneToGrid();
		
		configureGridPane();
	}
	
	Pane createPane(Color c) {
		Pane pane = new Pane();
		pane.setMinHeight(50);
		pane.setMinWidth(50);
		Background bg = new Background(new BackgroundFill(c, new CornerRadii(5), new Insets(10)));
		pane.setBackground(bg);
		return pane;
	}
	
	void setAvailableColors() {
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.BLUE);
		colors.add(Color.BLACK);
		colors.add(Color.YELLOW);
		colors.add(Color.CYAN);
	}
	
	void addPaneToGrid() {
		int index = 0;
		for(int i = 0; i <= colors.size()/5; i++) {
			for(int j = 0; j < 5; j++) {
				if(index == colors.size()) {
					break;
				}
				Pane p = createPane(colors.get(index));
				colorPanes.add(p);
				gp.add(p, j, i);
				index++;
			}
		}
	}
	
	void configureGridPane() {
		
	}
	

}
