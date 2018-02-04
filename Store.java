/*Store.java
*@Daniela Kepper
*05.12.2017
*/

import java.util.Scanner;
import java.util.Arrays;

public class Store {

  // MEMBER VARIABLES
  private int guessedNumber[][];
  private int gameNumber = 0;
  private int numberLines;
  private String incorrectInput = "";

  // OBJECTS
  Scanner userInput = new Scanner(System.in);

  // DEFAULT CONSTRUCTORS
  public Store(){
  }

  // SETTERS
  public void setGameNumber(int gameNumber) {
    this.gameNumber = gameNumber;
  }

  public void setNumberLines(int numberLines) {
    this.numberLines = numberLines;
  }

  // PROCESS

  // method to play the lottery game
  public void playGame(){
    do {

      System.out.println("This is game number " + gameNumber);
      System.out.println("Would you like to play 1, 2 or 3 lines in this game?");
      numberLines = userInput.nextInt();


      if (numberLines==1 || numberLines==2 || numberLines==3) {
        guessedNumber = new int [numberLines][6];
        for (int row=0; row<numberLines; row++) {

          for (int col=0; col<=5; col++) {
            System.out.println("Guess number " + (col+1) + " out of 6 in your line " + (row+1) + " : ");
            int userNumber = userInput.nextInt();

              // check between 1 and 40
              if (userNumber>=1 && userNumber<=40){

                // check if number is a duplicate aka. has been used in the same row before
                  boolean duplicate = false;
                  for(int l = 0; l<guessedNumber[row].length; l++){

                    if (guessedNumber[row][l] == userNumber) {
                      duplicate = true;
                    }
                  }
                    // store number in array if it's between 1-40 and unique per line
                    if (duplicate == false) {
                      guessedNumber[row][col] = userNumber;
                    }

                    // duplicate statement & going back to same number input
                    else {
                      System.out.println("Your number was a duplicate, please try again!");
                      col = col - 1;
                    }
              }
              // incorrect value range statement & going back to same number input
              else {
                System.out.println("Your number was not between 1 and 40, please try again!");
                col = col - 1;
              }
            }
          }
        }
        // incorrect input statement, if user didn't enter 1 - 3 lines
        else {
          incorrectInput = "Incorrect input - please try again: ";
          System.out.println(incorrectInput);
        }
      }
      while (incorrectInput.equals("Incorrect amount of lines - please try again: "));
    }

    // method to clear array after a game to avoid line duplications in different games
    public void clearArray(){
      for (int row = 0; row < guessedNumber.length; row++) {
        for (int col = 0; col < guessedNumber[row].length; col++) {
          guessedNumber[row][col] = 0;
        }
      }
    }

    // GETTERS
    public int getGameNumber(){
      return gameNumber;
    }

    public int[][] getGuessedNumber(){
      return guessedNumber;
    }

    public int getNumberLines(){
      return numberLines;
    }

    // closing tag - DO NOT CHANGE!
}
