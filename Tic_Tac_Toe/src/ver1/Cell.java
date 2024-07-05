package ver1;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Cell extends Pane{
	
	private char value = ' ';
	private int row;
	private int column;
	
	Cell(int row, int column) {
		setPrefSize(100, 100);
		setCellValue(' ');
		setBorder(Border.stroke(Color.BLACK));
		this.row = row;
		this.column = column;
	}
	
	char getCellValue() {
		return this.value;
	}
	
	int getRow() {
		return this.row;
	}
	
	int getColumn() {
		return this.column;
	}
	
	void restartCellValue() {
		this.value = ' ';
	}
	
	void setCellValue(char value) {
		if(value == 'x') {
			Line l1 = new Line();
//			l1.setStartX(0);
//			l1.setStartY(0);
//			l1.endXProperty().bind(super.widthProperty());
//			l1.endYProperty().bind(super.heightProperty());
//			l1.setStroke(Color.BLACK);
//			l1.setStrokeWidth(5);
			
			l1.setStartX(20);
			l1.setStartY(20);
			l1.setEndX(80);
			l1.setEndY(80);
			l1.setStroke(Color.BLACK);
			l1.setStrokeWidth(5);
			
			Line l2 = new Line();
//			l2.startXProperty().bind(super.widthProperty());
//			l2.setStartY(0);
//			l2.setEndX(0);
//			l2.endYProperty().bind(super.heightProperty());
//			l2.setStroke(Color.BLACK);
//			l2.setStrokeWidth(5);
			
			l2.setStartX(80);
			l2.setStartY(20);
			l2.setEndX(20);
			l2.setEndY(80);
			l2.setStroke(Color.BLACK);
			l2.setStrokeWidth(5);
	
			getChildren().addAll(l1, l2);
			this.value = value; 
		} else if(value == 'o') {
			Circle c = new Circle();
//			c.centerXProperty().bind(super.widthProperty().divide(2));
//			c.centerYProperty().bind(super.heightProperty().divide(2));
//			c.radiusProperty().bind(super.widthProperty().divide(3));
			c.setCenterX(super.getWidth()/2);
			c.setCenterY(super.getHeight()/2);
			c.setStroke(Color.BLACK);
			c.setRadius(40);
			c.setFill(Color.TRANSPARENT);
			c.setStrokeWidth(5);
			getChildren().add(c);
			this.value = value;
		} else if(value == ' ') {
			value = ' ';
			getChildren().clear();
		}
		
	}
	
	void setWinningLine(String position) {
		if(position.equalsIgnoreCase("h")) {
			Line l = new Line();
			l.setStartX(0);
			l.setStartY(super.getHeight()/2);
			l.setEndX(super.getWidth());
			l.setEndY(super.getHeight()/2);
			l.setStroke(Color.BLACK);
			l.setStrokeWidth(5);
			getChildren().add(l);
			
		} else if(position.equalsIgnoreCase("v")) {
			Line l = new Line();
			l.setStartX(super.getWidth()/2);
			l.setStartY(0);
			l.setEndX(super.getWidth()/2);
			l.setEndY(super.getHeight());
			l.setStroke(Color.BLACK);
			l.setStrokeWidth(5);
			getChildren().add(l);
		} else if(position.equalsIgnoreCase("dl")){
			Line l = new Line();
			l.setStartX(0);
			l.setStartY(0);
			l.setEndX(super.getWidth());
			l.setEndY(super.getHeight());
			l.setStroke(Color.BLACK);
			l.setStrokeWidth(5);
			getChildren().add(l);
		} else if(position.equalsIgnoreCase("dr")) {
			Line l = new Line();
			l.setStartX(super.getWidth());
			l.setStartY(0);
			l.setEndX(0);
			l.setEndY(super.getHeight());
			l.setStroke(Color.BLACK);
			l.setStrokeWidth(5);
			getChildren().add(l);
		}
	}
	
}
