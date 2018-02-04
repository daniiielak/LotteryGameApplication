/*Compare.java
 *@author: L. Perez & J. Pschibul
 *2-12-2017
 */
import java.util.Arrays;

public class Compare{
	//variables
	private int[] secret = new int[6];
	private int[][] games;
	private int[] winnings;
	private int numberLines;

	//variables history
	private int linesPlayed; // store Number of Lines played
	private int linesWon;//add number of lines won
	private int amountWon;
	private boolean wonLottery;// store win amount per game
	private int [][]history = new int[10][3];

	// Objects
	Store storeProgram;

	//Constructor
	public Compare(){
	}

	//set

	public void setStoreProgram(Store object1){
		storeProgram = object1;
	}

	public void setSecret(int[] secret){
		this.secret = secret;
	}
	public void setGuess (int[][] games){
		this.games = games;
	}
	public void setNumberLines(int numberLines){
		this.numberLines = numberLines;
	}

	public void compare(){
		numberLines = storeProgram.getNumberLines();
		games = new int[numberLines][6];
		games = storeProgram.getGuessedNumber();
		winnings = new int[numberLines];
		int win = 0;
     	for(int row = 0; row < games.length; row++){
			for(int col = 0; col < games[row].length; col++){
				for(int j = 0; j < secret.length; j++){
					if (secret[j]==games[row][col]){
						win++;
					}
				}
			winnings[row] = win;
			}
			win = 0;
		}
		int prize = 0;
		int winAmount = 0;
		for(int i = 0; i < winnings.length; i++){
		    prize = 0;
			if (winnings[i] == 3){
				prize = 9;
			} else if (winnings[i] == 4){
				prize = 54;
			} else if (winnings[i] == 5){
				prize = 1000;
			} else if (winnings[i] == 6) {
				prize = 1000000;
			}
			winAmount = winAmount + prize;
			System.out.println("Game "+(i+1)+"     "+winnings[i]+" wins    amount " + prize + " Euros");
		}
		//history
		// get  values from Lohengrin
		linesPlayed = storeProgram.getNumberLines();
		linesWon = 0;
			for (int n = 0; n < winnings.length; n++){
				if (winnings[n] > 2) {
					linesWon++;
				}
			}
		amountWon = prize;
		//store the values in the history array
		for(int l = 0; l<history.length; l++){//by rows
			for(int m = 0; m<history[l].length; m++){// by columns
				history[l][0]=linesPlayed;
				history[l][1]=linesWon;
				history[l][2]=amountWon;
			}
		}
	}
	//get
	public int[] getWinnings(){
		return winnings;
	}
	public int[][]getHistory(){
		return history;
	}
}
