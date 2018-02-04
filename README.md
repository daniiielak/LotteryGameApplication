# Overview Lottery Game Application Project

## Overview
The Lottery Game Application Project was developed as a group project by	Daniela Elisabeth Kepper, Judith Pschibul and Lohengrin Perez as part of HDip in Computer Sciences (1st Semester) at NCIRL.

## Objective
The aim of the project is to develop an application that allows the user to play the lottery in up to three lines per game, entering six chosen numbers between one and forty. The game then compares the played lines with the secret winning six numbers and outputs the result to the user, telling him about the amount of money he won.

## Class Diagram Overview
The Class Diagram shows, how the different classes are setup, which attributes and methods they provide and how they work together. [Class Diagram Overview](https://github.com/daniiielak/SecretLotteryApplication/blob/master/Images/LotteryGameStructure.png)

## Class Setup
** 1. App class (SecretLotteryApp.java):**
The App class is the main application for the lottery game and provides the interface that the user is interacting with, while calling the instantiable classes to perform different functions of the app. The main functionalities of the App class include: printing out the game instructions, calling Random class to generate Random, starting the do-while loop to play the lottery game that calls the playGame() method in Store, the compareNumber() method in Compare and clears the array after the game. As final steps, it calls the history class and prints the last words of the game. The random numbers are setup to stay the same during one session of as many games the player decides to start. Only after he exits the app with choosing “No” and then restarts, he would create new random numbers.

** 2. Store class (Store.java):**
The Store class is called by the App class during the do-while loop that starts off the lottery game. The Store class is restarted after every single game and the values of the array in Store are cleared after every single game to ensure overwriting works correctly.The functionalities of the Store class are to ask the user for the amount of Lines to play each game, prompting the user for Scanner input for the six numbers per line and verifying the numbers are not duplicate within a line and lay between one and 40 - if those two conditions are not met, the user has to input the described number in the line again.

** 3.	RandomNumber class (RandomNumber.java): **
The RandomNumber is an instantiable class that generates generates 6 random and unique secret lottery numbers between 1 and 40 and transfer them to the App class, from where they are pushed into the Compare class to be checked with the user input.

** 4. Compare class (Compare.java): **
The Compare class is needed twice in the game, once to compare the user input numbers from the Store class with the secret Numbers from the RandomNumbers class and print the results and once to print a final history of all games played after the user exits the game. The main functionalities of the Compare class are evaluating each number on each line from the userInput with the Secret number and storing matched numbers to then show to the user the won games, using these won games to then evaluate, how much money a user has won, storing all the information about won lines and won games in the history class and printing these information out after exiting the game in the end.
