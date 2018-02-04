/*Filename: RandomNumber.java
*@JudithPschibul
*2th of November
*This instantiable class generates 6 random secret lottery numbers between 1 and 40 and transfer them to the App class
*/

import java.util.Random;

public class RandomNumber{

	//declare an array to store the random numbers
	private int [] secret = new int [6];
	private int randomNumber;

	Random random = new Random();

	//declare a default constructor
	public RandomNumber(){
	}

	//declare a method to generate the random numbers
	public void generateRandom(){
		//declare and create a new object of type Random



		secret[0]=random.nextInt(40)+1;//create the first value and store it in array

		//generating random number
		for (int i=1; i <secret.length; i++) {

			 randomNumber = random.nextInt(40)+1;

			 //checking if the number is already in the array
			 for (int j = 0; j<i ;j++){
				 if (randomNumber == secret [j]){//if the new number is = the existing number
					 // the existing number will stay in the array
					 i--;//new number will be removed and loop starts again
			     	 j=50;// will assign value over 40, it does not get stored
			     } else{
					 secret[i] = randomNumber;
				 }
			}
		 }



	  }


	//getter: return the Secret array to the App Class

	public int [] getSecret(){
		return secret;
	}



}
