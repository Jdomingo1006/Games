import java.util.Random;
import java.util.Scanner;

/*
 * Info: Basic high or low game
 * Features: Keeps track of draws, wins, and total games.
 * Author: James Domingo
 */
public class HighOrLowGame {
	
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner userInput = new Scanner(System.in);
		int choice = 0;
		int winCount = 0;
		int totalGames = 0;
		int drawCount = 0;
		
		System.out.println("Let us start. hehe...");
		do{
			int givenNumb = rand.nextInt(10 - 1) + 1;
			System.out.println("Number: "+givenNumb);
			System.out.println("(1)Low | (2)High | (3) Quit game.");
			choice = userInput.nextInt();
			int randomInt = rand.nextInt(10 - 1) + 1;
			
			switch(choice) {
			case 1:
				totalGames++;
				if(givenNumb > randomInt) {
					winCount++;
					System.out.println("You have won!");
					break;
				}else if(givenNumb == randomInt) {
					drawCount++;
					System.out.println("It was a draw!");
					break;
				} else {
					System.out.println("You have lost...");
					break;
				}				
			case 2:
				totalGames++;
				if(givenNumb < randomInt){
					winCount++;
					System.out.println("You have won!");
					break;
				}else if(givenNumb == randomInt) {
					drawCount++;
					System.out.println("It was a draw!");
					break;
				}else {
					System.out.println("You have lost...");
					break;
				}
			case 3:
				break;
			default:
				System.out.println("Please enter a valid number.");
				break;
				}
			}while(choice != 3);
		
		System.out.println("You have won "+winCount+" times out of "+totalGames+" games!");
		System.out.println("You had "+drawCount+" many draws!");
		}
	}
