import java.util.Random;
import java.util.Scanner;

/*
 * Info: Text based RPG game
 * Features: Character classes, currency, game as of December 27th, 2019
 * Author: James Domingo
 */

public class RPG {
	static String userName, classType = "";
	static int health, mana, strength, speed, rubies= 0;
	
	public static void main(String[] args) {
		int classChoice, userChoice = 0;
		char confirm;
		boolean accept = false;
		Scanner userInput = new Scanner(System.in);
		
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
		
		do{
			System.out.println("What would you like to do now?");
			printMenu();
			userChoice = userInput.nextInt();
			
			switch(userChoice) {
			case 1:
				break;	
			case 2:
				break;
			case 3:
				gambleGame();
				System.out.println("Thanks for playing!");
				break;
			case 4:
				playerInformation();
				break;
			case 5:
				break;
			default:
				System.out.println("Please enter valid choice.");
				}
		}while(userChoice != 5);
	}
	

	
	//High or Low game
	public static void gambleGame() {
		Random rand = new Random();
		Scanner userInput = new Scanner(System.in);
		int choice = 0;
		int winCount = 0;
		int totalGames = 0;
		int drawCount = 0;
		
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
					System.out.println("You have lost...");
					System.out.println("Total rubies: "+rubies);
					break;
				}				
			case 2:
				totalGames++;
				if(givenNumb < randomInt){
					rubies++;
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
		System.out.println("Total Rubies gained: "+rubies);
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
		System.out.println("1. Shop \n2. Battle opponenents \n3. Gamble \n4. Print Player information \n5. Quit Game");
	}
	
	public static void playerInformation() {
		System.out.println("Health: "+health+ "\nMana: "+mana+"\nStrength: "+strength+"\nSpeed: "+speed);
		System.out.println("Rubies: "+rubies);
	}
	
	public static void playerShop() {
		System.out.println("Welcome to Try and Buy shop!");
		
	}
	
	public static void printInfo() {
		System.out.println("\nHere is information of "+classType);
		System.out.println("Health: "+health+ "\nMana: "+mana+"\nStrength: "+strength+"\nSpeed: "+speed);
	}
}
