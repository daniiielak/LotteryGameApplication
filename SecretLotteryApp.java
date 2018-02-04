/*SecretLotteryApp.java
*@Daniela Kepper
*05.12.2017
*/

import java.util.Scanner;
import java.util.Arrays;

public class SecretLotteryApp {
  public static void main(String args[]) {

  // VARIABLES
  int guessedNumber[][];
  int gameNumber = 0;
  int randomNumber[] = new int[6];
  int winnings[];
  int history[][]= new int [100][3];
  String continueGame;
  String winningText;

  // OBJECTS
  Scanner userInput = new Scanner(System.in);
  Store storeProgram = new Store();
  Compare compareNumbers = new Compare();
  compareNumbers.setStoreProgram(storeProgram);
  RandomNumber randomProgram = new RandomNumber();

  // INPUT
  System.out.println("This is a Lottery game, which allows you to guess 6 lottery numbers between 1 and 40 in up to 3 lines per game.");
  System.out.println("The game will then compare all your input lines with the Secret Lottery Number and tell you, how much you won!");
  System.out.println("After the game, you can decide, if you would like to continue playing.");

  randomProgram.generateRandom();
  compareNumbers.setSecret(randomNumber);

  // only used during the testing phase
  /* randomNumber = r.getSecret();
  System.out.println(Arrays.toString(randomNumber)); */

 // PROCESS
 do {
  gameNumber = gameNumber + 1;
  storeProgram.setGameNumber(gameNumber);
  storeProgram.playGame();
  compareNumbers.compare();
  storeProgram.clearArray();

  // game output & winnings
  winnings = compareNumbers.getWinnings();
  history = compareNumbers.getHistory();

  // continue Game

  System.out.println("Would you like to continue? Please input Yes or No: ");
  continueGame = userInput.nextLine();
  }
  while (continueGame.toLowerCase().matches("yes|y|true"));

  if(!continueGame.matches("yes|y|true")){
      for(int i = 0;i<history.length;i++){
        for (int j = 0; j<history.length;j++){
        System.out.println("Game: "+(i+1)+", Lines Played: "+history[i][0]+", LinesWon: "+history[i][1]+" Amount won:" +history[i][2]);
        }

      }
  }

  // OUTPUT
  System.out.println("Thanks for playing the Lottery Game!");

  gameNumber = 0;
  storeProgram.setGameNumber(0);



    // closing tags - DO NOT CHANGE!

  }
}
