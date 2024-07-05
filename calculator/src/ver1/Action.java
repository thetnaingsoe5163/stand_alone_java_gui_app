package ver1;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.Button;

public class Action {
	
	private UI ui;
	private TextField tf;
	private Button[] btns;
	private boolean shiftKeyPressed;
	
	Action(UI ui) {
		this.ui = ui;
		tf = this.ui.getTextField();
		btns = this.ui.getButtons();
	}
	
	TextField getTextFile() {
		return this.tf;
	}
	
	void setButtonAction() {
		for(Button b : btns) {
			b.setOnAction(e -> {
				if(b.getText().equals("C")) {
					tf.setText("");
				} else if(b.getText().equals("=")) {
					process(tf.getText());
				} else {
					tf.setText(tf.getText()+ b.getText());
				}
				tf.requestFocus();
			});
		}
	}
	
	void setKeyAction() {
		tf.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case DIGIT1: tf.setText(tf.getText()+ "1"); 
				break;
			case DIGIT2: tf.setText(tf.getText()+ "2");
				break;
			case DIGIT3: tf.setText(tf.getText()+ "3");
				break;
			case DIGIT4: tf.setText(tf.getText()+ "4");
				break;
			case DIGIT5: tf.setText(tf.getText()+ "5");
				break;
			case DIGIT7: tf.setText(tf.getText()+ "7");
				break;
			case MINUS: tf.setText(tf.getText()+ "-");
				break;
			case SLASH: tf.setText(tf.getText() + "/");
				break;
			case ENTER: process(tf.getText());
				break;
			case C: tf.setText("");
				break;
			case BACK_SPACE: delete(tf);
				break;
			case SHIFT: shiftKeyPressed = true;
				break;
			default: 
			}
			
			if(e.getCode() == KeyCode.EQUALS && shiftKeyPressed) {
				tf.setText(tf.getText()+ "+"); 
			} else if(e.getCode() == KeyCode.DIGIT8 && shiftKeyPressed) {
				tf.setText(tf.getText() + "*");
			} else if(e.getCode() == KeyCode.DIGIT6 && shiftKeyPressed) {
				tf.setText(tf.getText() + "^");
			} else if(e.getCode() == KeyCode.DIGIT9 && shiftKeyPressed) {
				tf.setText(tf.getText() + "(");
			} else if(e.getCode() == KeyCode.DIGIT0 && shiftKeyPressed) {
				tf.setText(tf.getText() + ")");
			} else if(e.getCode() == KeyCode.DIGIT0 && !shiftKeyPressed) {
				tf.setText(tf.getText() + "0");
			} else if(e.getCode() == KeyCode.DIGIT9 && !shiftKeyPressed) {
				tf.setText(tf.getText() + "9");
			} else if(e.getCode() == KeyCode.DIGIT8 && !shiftKeyPressed) {
				tf.setText(tf.getText() + "8");
			} else if(e.getCode() == KeyCode.DIGIT6 && !shiftKeyPressed) {
				tf.setText(tf.getText() + "6");
			}

		});
		
		tf.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.SHIFT) {
				shiftKeyPressed = false;
			}
		});
		
	}
	
	void delete(TextField t) {
		if(t.getText() != "") {
			String newText = t.getText().substring(0, tf.getText().length()-1);
			t.setText(newText);
		}
	}
	
	void process(String expression) {
		StringBuilder sb = new StringBuilder(expression);
		Formatter format = new Formatter(sb);
		if(format.canProcess()) {
			calculate(new Logic(format));
		} else {
			tf.setText("Invalid Expression");
		}
		
	}
	
	void calculate(Logic l) {
		try {
			setTextField(l.operate());
		} catch(Exception e) {
			tf.setText("Invalid Expression");
		}
	}
	
	void setTextField(double value) {
		tf.setText(Double.toString(value));
	}
	
	
}
