package ver1;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class GameBoard {
	
	private Cell[][] cells;
	private GameBoardUI gbUi;
	private char currentPlayer = 'o'; //game start with o
	private int control = 0; //0 is for o and 1 is for x
	private char winner = ' ';
	private Button nextBtn;
	private Button restartBtn;
	private int xScore;
	private int oScore;
	Cell[] winningCells = new Cell[3]; 
	
	GameBoard(GameBoardUI gbUi) {
		this.gbUi = gbUi;
		this.cells = gbUi.getCells();
		this.nextBtn = gbUi.getNext();
		this.restartBtn = gbUi.getRestart();
	}
	
	void play() {
		setAction();
		setBtnAction();
	}
	
	boolean isValidMove(int row, int column) {
		boolean result = true;
		if(cells[row][column].getCellValue() != ' ') return result = false;
		return result;
	}
	
	boolean isFull() {
		boolean result = true;;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(cells[i][j].getCellValue() == ' ') return result = false;
			}
		}
		return result;
	}
	
	boolean isWinner(char player) {
		boolean result = true;
		//start
		for(int i = 0; i < 3; i++) {
			
			//horizontally checking
			if(cells[i][0].getCellValue() == player && cells[i][1].getCellValue() == player && cells[i][2].getCellValue() == player) {
				winner = player;
				winningCells[0] = cells[i][0];
				winningCells[1] = cells[i][1];
				winningCells[2] = cells[i][2];
				setWinningCells("h");
				return result;
			}
			//vertically checking
			if(cells[0][i].getCellValue() == player && cells[1][i].getCellValue() == player && cells[2][i].getCellValue() == player) {
				winner = player;
				winningCells[0] = cells[0][i];
				winningCells[1] = cells[1][i];
				winningCells[2] = cells[2][i];
				setWinningCells("v");
				return result;
			}
			
			//diagonally checking
			//diagonally left
			if(cells[0][0].getCellValue() == player && cells[1][1].getCellValue() == player && cells[2][2].getCellValue() == player) {
				winner = player;
				winningCells[0] = cells[0][0];
				winningCells[1] = cells[1][1];
				winningCells[2] = cells[2][2];
				setWinningCells("dl");
				return result;
			}
			//diagonally right
			if(cells[0][2].getCellValue() == player && cells[1][1].getCellValue() == player && cells[2][0].getCellValue() == player) {
				winner = player;
				winningCells[0] = cells[0][2];
				winningCells[1] = cells[1][1];
				winningCells[2] = cells[2][0];
				setWinningCells("dr");
				return result;
			}
		}
		//end 
		return result = false;
	}
	
	boolean isThereWinner() {
		if(winner != ' ') return true;
		return false;
	}
	
	void setAction() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Cell c = cells[i][j];
				c.setOnMouseClicked(e -> {
					int row = c.getRow();
					int column = c.getColumn();
					process(row, column);
				});
			}
		}
		
	}
	
	void setBtnAction() {
		nextBtn.setOnAction(e -> {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					cells[i][j].setCellValue(' ');
					cells[i][j].restartCellValue();
				}
			}
			nextMatch();
		});
		
		restartBtn.setOnAction(e -> {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					cells[i][j].setCellValue(' ');
					cells[i][j].restartCellValue();
				}
			}
			restartMatch();
		});
	}
	
	void restartMatch() {
		currentPlayer = 'o';
		winner = ' ';
		control = 0;
		xScore = 0;
		oScore = 0;
		this.gbUi.setWhoseTurnLabel(currentPlayer);
		this.gbUi.setOWinCount(oScore);
		this.gbUi.setXWinCount(xScore);
		this.gbUi.setWinnerValue("Game starts");
	}
	
	void nextMatch() {
		if(control == 0) {
			currentPlayer = 'o';
		} else {
			currentPlayer = 'x';
		}
		winner = ' ';
		this.gbUi.setWhoseTurnLabel(currentPlayer);
		this.gbUi.setWinnerValue("Game starts");
	}
	
	void process(int row, int column) {
		if(!isFull() && !isThereWinner()) {
			if(isValidMove(row, column)) {
				cells[row][column].setCellValue(currentPlayer);
				if(isWinner(currentPlayer)) {
					String value = winner == 'x' ? "X wins" : "O wins";
					setCount(currentPlayer);
					this.gbUi.setWhoseTurnLabel(' ');
					this.gbUi.setWinnerValue(value);
					currentPlayer = ' ';
				};
				if(currentPlayer == 'x') {
					currentPlayer = 'o';
				} else if(currentPlayer == 'o') {
					currentPlayer = 'x';
				}
				this.gbUi.setWhoseTurnLabel(currentPlayer);
			}
		}
		if(isFull()) {
			this.gbUi.setWinnerValue("Tie"); 
		}
		if(control == 1) {
			control--;
		} else {
			control++;
		}

		return;
	}
	
	void setCount(char player) {
		if(player == 'x') {
			xScore++;
			this.gbUi.setXWinCount(xScore);
		} else {
			oScore++;
			this.gbUi.setOWinCount(oScore);
		}
		
	}
	
	void setWinningCells(String position) {
		for(int i = 0; i < 3; i++) {
			winningCells[i].setWinningLine(position);
		}
	}
	
	void showCellvalue() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println("Row: " + i + " | column: " + j + " => " + cells[i][j].getCellValue());
			}
		}
	}
}
