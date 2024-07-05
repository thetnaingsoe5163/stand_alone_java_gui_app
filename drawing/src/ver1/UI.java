package ver1;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class UI {
	
	private HBox hb;
	
	private Canvas canvas;
	private ColorPicker palette;
	private VBox vb;
	private BorderPane bp;
	private GridPane gp;
	private GridPane gp2;
	
	private TextField tf;
	private CheckBox erase;
	private Button clear;
	private ToggleGroup toggleGp;
	
	
	UI(double width, double height) {
		this.hb = new HBox();
		this.vb = new VBox();
		this.bp = new BorderPane();
		this.gp = new GridPane();
		this.gp2 = new GridPane();
		this.palette = new ColorPicker();
		this.canvas = new Canvas();
		this.tf = new TextField();
		this.erase = new CheckBox("Eraser");
		this.clear = new Button("Clear");
		this.toggleGp = new ToggleGroup();
	}
	
	HBox getUI() {
		setUI();
		return this.hb;
	}
	
	ColorPicker getPalette() {
		return palette;
	}
	
	Canvas getCanvas() {
		return canvas;
	}
	
	TextField getTextField() {
		return this.tf;
	}
	
	CheckBox getErase() {
		return this.erase;
	}
	
	Button getClear() {
		return this.clear;
	}
	
	void setUI() {
		addToVBox();
		addToHBox();
		addToGridPane1();
		addToGridPane2();
		addToBorderPane();
		
		configureHBox();
		configureVBox();
		configureBorderPane();
		configureCanvas();
		configureTextField();
		configureGridPane();
	}
	
	void addToHBox() {
		hb.getChildren().addAll(canvas, vb);
	}
	
	void addToVBox() {
		vb.getChildren().addAll(bp);
	}
	
	void addToBorderPane() {
		bp.setTop(gp);
		bp.setCenter(gp2);
	}
	
	void addToGridPane1() {
		gp.add(palette, 0, 0);
		gp.add(erase, 1, 0);
		gp.add(clear, 2, 0);
	}
	
	void addToGridPane2() {
		gp2.add(tf, 0, 0);
//		Button 
	}
	
	void configureHBox() {
		hb.setMinWidth(500);
		hb.setMinHeight(500);
	}
	
	void configureVBox() {
		vb.setMinWidth(500);
		Image img = new Image("C:\\Users\\hp\\Workspace\\My-App(2022)\\GUIProject\\Drawing\\image\\logo3.png");
		BackgroundImage bimg = new BackgroundImage(img, null, null, null, new BackgroundSize(500, 500, false, false, false, false));
		Background bg = new Background(bimg);
		vb.setBackground(bg);
	}
	
	void configureGridPane() {
		gp.setHgap(20);
		gp.setVgap(20);
		
		gp2.setHgap(20);
		gp2.setVgap(20);
	}
	
	
	void configureTextField() {
		
	}
	
	void configureBorderPane() {
		bp.setMargin(gp, new Insets(20, 20, 20, 20));
		bp.setMargin(gp2, new Insets(0, 20, 20, 20));
		
	}
	
	void configureCanvas() {
		canvas.setWidth(500);
		canvas.setHeight(500);
	}
}
