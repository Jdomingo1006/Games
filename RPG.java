import java.util.Random;
import java.util.Scanner;

/*
 * Info: Text based RPG game
 * Features: Character classes, currency, shops game as of December 27th, 2019
 * Author: James Domingo
 * 
 * Journal: 
 * 12/27 - Added shop menus, gamble, print player information. Worked on functioning purchase weapons. 
 */

public class RPG {
	static String userName, classType = "";
	static int health, mana, strength, speed, rubies= 0;
	
	public static void main(String[] args) {
		int classChoice, userChoice = 0;
		char confirm;
		boolean accept = false;
		Scanner userInput = new Scanner(System.in);
		
		//NOTE: Code breaks when using space in name. Search for solution
		System.out.print("Let's start off with who you are! \nWhat is your name? ");
		userName = userInput.next();
		System.out.println("Hello "+userName+"! Welcome to King of Eclipse RPG!");
		
		do {
			System.out.print("\nChoose your class! \n(1)Mage \n(2)Archer \n(3)Assassin");
			classChoice = userInput.nextInt();
			
			switch(classChoice) {
			case 1:
				classType = "Mage";
				Mage();
				printInfo();
				System.out.print("Confirm: (Y/N)");
				confirm = userInput.next().charAt(0);
				if(confirm == 'Y') {
					accept = true;
				}
				break;
				
			case 2:
				classType = "Archer";
				Archer();
				printInfo();
				System.out.print("Confirm: (Y/N)");
				confirm = userInput.next().charAt(0);
				if(confirm == 'Y') {
					accept = true;
				}
				break;
			case 3:
				classType = "Assassin";
				Assassin();
				printInfo();
				System.out.print("Confirm: (Y/N)");
				confirm = userInput.next().charAt(0);
				if(confirm == 'Y') {
					accept = true;
				}
				break;
			default:
				System.out.println("Please choose a valid number");
				break;
			}
		}while(accept != true);
		
		System.out.println("\nSounds good! Your new title is: "+userName+" ("+classType+")");
		
		//Work out the detail of code
		do{
			System.out.println("What would you like to do now?");
			printMenu();
			userChoice = userInput.nextInt();
			
			switch(userChoice) {
			//Shop
			case 1:
				if(rubies <= 0) {
					System.out.println("Please gain more rubies before entering our shops...");
					break;
				}
				playerShop();
				break;	
			//Battle Opponents
			case 2:
				break;
			//Gamble
			case 3:
				gambleGame();
				System.out.println("Thanks for playing!\n");
				break;
			//Print Player information
			case 4:
				playerInformation();
				break;
			//Quit Game
			case 5:
				break;
			default:
				System.out.println("Please enter valid choice.");
				break;
				}
		}while(userChoice != 5);
		System.out.println("Thank you for playing!");
	}
	
	//High or Low game
	//NOTE: Still need to fix ruby currency and H/L game interactions
	public static void gambleGame() {
		Random rand = new Random();
		Scanner userInput = new Scanner(System.in);
		int choice = 0;
		int winCount = 0;
		int totalGames = 0;
		int drawCount = 0;
		int rubiesGained = 0;
		
		System.out.println("\n\nThis is a simple High or Low Game.\nYou'll choose High or Low depending on the given number. Simple enough");
		System.out.println("NOTE: You get +1 ruby per win!. However, you lose 2 rubies per loss... Don't get addicted.");
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
					rubies++;
					rubiesGained++;
					winCount++;
					System.out.println("You have won!");
					System.out.println("Total rubies: "+rubies);
					break;
				}else if(givenNumb == randomInt) {
					drawCount++;
					System.out.println("It was a draw!");
					break;
				} else {
					rubies--;
					rubiesGained--;
					System.out.println("You have lost...");
					System.out.println("Total rubies: "+rubies);
					break;
				}				
			case 2:
				totalGames++;
				if(givenNumb < randomInt){
					rubies++;
					rubiesGained++;
					winCount++;
					System.out.println("You have won!");
					System.out.println("Total rubies: "+rubies);
					break;
				}else if(givenNumb == randomInt) {
					drawCount++;
					System.out.println("It was a draw!");
					break;
				}else {
					rubies--;
					rubiesGained--;
					System.out.println("You have lost...");
					System.out.println("Total rubies: "+rubies);
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
		System.out.println("Rubies gained: "+rubiesGained);
		System.out.println("Total Rubies: "+rubies);
		}
	
	//Player Classes 
	public static void Mage() {
		health = 75;
		mana = 150;
		strength = 7;
		speed = 7;
	}
	public static void Archer() {
		health = 100;
		mana = 100;
		strength = 5;
		speed = 10;
	}
	public static void Assassin() {
		health = 50;
		mana = 100;
		strength = 7;
		speed = 15;
	}
	
	public static void printMenu() {
		System.out.println("1. Shop \n2. Battle opponents \n3. Gamble \n4. Print Player information \n5. Quit Game");
	}
	
	public static void playerInformation() {
		System.out.println("Health: "+health+ "\nMana: "+mana+"\nStrength: "+strength+"\nSpeed: "+speed);
		System.out.println("Rubies: "+rubies);
		System.out.println("");
	}
	
	//Shop of the rpg
	//NOTE: Need to add a backpack/inventory to rpg.
	public static void playerShop() {
		int userChoice, itemChoice = 0;
		char userAnswer;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to Try and Buy shop!");
		do {
			System.out.println("What would you like to buy today? \n(1) Items \n(2) Weapons \n(3) Return to menu");
			userChoice = userInput.nextInt();
			//purchasing items
			if(userChoice == 1) 
			{
				System.out.println("Here are our Items. \n(1) HP Potion \n(2) Mana Potion \n(3) Attack Buff Potion");
			//purchasing weapons
			}else if(userChoice == 2) 
			{
				//Work in progress
				System.out.println("Here are our weapons. \n(1) Dagger (+1 strength) \n(2) Sword (+2 strength) \n(3) Shuriken (+3 strength)");
				System.out.print("Which one would you like to buy?");
				itemChoice = userInput.nextInt();
				switch(itemChoice){
					case 1:
						System.out.print("Are you sure you want to buy (1) Dagger? It will be 2 rubbies. (Y/N)");
						userAnswer = userInput.next().charAt(0);
						if((rubies >= 2) && (userAnswer == 'Y' || userAnswer == 'y')) {
							rubies = rubies - 2;
							strength++;
							System.out.println("Thank you for purchasing a Dagger!");
						}else {
							if(rubies < 2) {
								System.out.println("\nLooks like you do not have enough rubies...");
							}
							System.out.println("No worries! Come back next time.");
						}
						break;
					case 2:
						System.out.print("Are you sure you want to buy (2) Sword? It will be 4 rubbies. (Y/N)");
						userAnswer = userInput.next().charAt(0);
						if((rubies >= 4) && (userAnswer == 'Y' || userAnswer == 'y')) {
							rubies = rubies - 4;
							strength = strength + 2;
							System.out.println("Thank you for purchasing a Sword!");
						}else {
							if(rubies < 4) {
								System.out.println("\nLooks like you do not have enough rubies...");
							}
							System.out.println("No worries! Come back next time.");
						}
						break;
					case 3:
						System.out.print("Are you sure you want to buy (3) Shuriken? It will be 6 rubbies. (Y/N)");
						userAnswer = userInput.next().charAt(0);
						if((rubies >= 6) && (userAnswer == 'Y' || userAnswer == 'y')) {
							rubies = rubies - 6;
							strength = strength + 3;
							System.out.println("Thank you for purchasing a Shuriken!");
						}else {
							if(rubies < 6) {
								System.out.println("\nLooks like you do not have enough rubies...");
							}
							System.out.println("No worries! Come back next time.");
						}
						break;
				}
			}else if(userChoice == 3) {
				break;
			}else {
				System.out.println("Please enter a valid choice.");
				}
			}while(userChoice != 3);
	}
	
	public static void printInfo() {
		System.out.println("\nHere is information of "+classType);
		System.out.println("Health: "+health+ "\nMana: "+mana+"\nStrength: "+strength+"\nSpeed: "+speed);
	}
}
