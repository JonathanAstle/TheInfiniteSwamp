package com.qa.infiniteswamp;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Starting game ...");
		System.out.println("You wake up with a splitting headache the morning after your stag do. You find yourself in a swamp stretching as far as the eye can see. The only interesting feature is some bloke stood nearby");
		System.out.println("\"Get up!\",");
		System.out.println("he shouts at you when he realises you're awake.");
		System.out.println();
		System.out.println("He's absolutely stacked so you do as he says.");
		System.out.println("\"What's your name?\"");
		System.out.println();
		System.out.println("Tell him your name by typing below: ");
		String name = sc.next();
		System.out.println("\"Okay " + name + ", I will only let you leave when you find the treasure hidden somewhere in this swamp. I will tell you how far away from the treasure you are after every kilometer that you walk in any direction. Only I know where the treasure is.\"");
		System.out.println("He gestures to a GPS in his hand.");
		System.out.println();
		System.out.println("The swamp forms a square grid. How big would you like each side of your grid to be in kilometers?");
		
		int gridSideLength;
	    while (!sc.hasNextInt() || (gridSideLength = sc.nextInt()) <= 1) {
	        System.out.print("You did not enter an integer larger than 1. Try again! \n");
	        sc.nextLine();
	    }
	    sc.nextLine();
		
		System.out.println("Okay, " + name + " the size of your swamp is " + gridSideLength + "km by " + gridSideLength +"km.");
		System.out.println("Would you like a map to display at the start of each turn? (This makes the game a lot easier)");
		String wouldLikeMap = sc.next().toLowerCase();
		while (!(wouldLikeMap.equals("yes")) && !(wouldLikeMap.equals("no"))) {
			System.out.println("Please type \"yes\" or \"no\": ");
			wouldLikeMap = sc.next().toLowerCase();
		}
		
		Player player = new Player(name, gridSideLength);
		Grid grid = new Grid(true, gridSideLength, player.getPlayerXCoordinate(), player.getPlayerYCoordinate());
		int treasureX = grid.getTreasureXCoordinate();
		int treasureY = grid.getTreasureYCoordinate();
		
		int turns = 0;
		while (player.getPlayerXCoordinate() != grid.getTreasureXCoordinate() || player.getPlayerYCoordinate() != grid.getTreasureYCoordinate()) {
			grid = new Grid(false, gridSideLength, player.getPlayerXCoordinate(), player.getPlayerYCoordinate(), treasureX, treasureY); 
			
			if(wouldLikeMap.equals("yes")) {
				grid.displayBoard();
			}
			
			//System.out.println("Treasure Location is: (" + grid.getTreasureXCoordinate() + ", " + grid.getTreasureYCoordinate() + ")");
			//System.out.println("Your location is: (" + player.getPlayerXCoordinate() + ", " + player.getPlayerYCoordinate() + ")");
			
			System.out.println("\"You are " + grid.the2DDistance(gridSideLength, player.getPlayerXCoordinate(), player.getPlayerYCoordinate(), grid.getTreasureXCoordinate(), grid.getTreasureYCoordinate()) + "km away.\"");
			System.out.println("The man yells. Which direction would you like to travel?");
			String direction = sc.next().toLowerCase();
			
			while (!(direction.equals("north")) && !(direction.equals("east")) && !(direction.equals("south")) && !(direction.equals("west"))) {
				System.out.println("Please type \"north\", \"south\", \"east\" or \"west\": ");
				direction = sc.next().toLowerCase();
			}
			System.out.println("you walk 1km " + direction + "...");
			
			player.travel(direction);
			
			if (player.getPlayerXCoordinate() > gridSideLength-1) {
				player.setPlayerXCoordinate(0);
			} else if (player.getPlayerXCoordinate() < 0) {
				player.setPlayerXCoordinate(gridSideLength-1);
			}
			
			
			if (player.getPlayerYCoordinate() > gridSideLength-1) {
				player.setPlayerYCoordinate(0);
			} else if (player.getPlayerYCoordinate() < 0) {
				player.setPlayerYCoordinate(gridSideLength-1);
			}
			
			turns += 1;
			if (player.getPlayerXCoordinate() != grid.getTreasureXCoordinate() || player.getPlayerYCoordinate() != grid.getTreasureYCoordinate()) {
				System.out.println("You have used " + turns + " turns so far!");
			}
			
			
			
		}
		
		System.out.println("... and find the treasure!");
		
		System.out.println();
		System.out.println("\"Thanks " + player.getname() + ". You can go now!\"");
		System.out.println();
		System.out.println();
		
		System.out.println("You managed to finish the game in " + turns + " turns.");
		
		sc.close();
	}
	
	

}
