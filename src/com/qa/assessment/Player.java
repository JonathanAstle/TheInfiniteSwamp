package com.qa.assessment;

public class Player {
	private String name;
	private double playerXCoordinate;
	private double playerYCoordinate;
	
	public Player(String name, int gridSideLength) {
		double randomNumber1 = Math.random()*gridSideLength;
		double randomNumber2 = Math.random()*gridSideLength;
		double randomX = randomNumber1 - randomNumber1%1;
		double randomY = randomNumber2 - randomNumber2%1;
		
		this.name = name;
		this.playerXCoordinate = randomX; //Make this a random number between 0 and gridSizeLength
		this.playerYCoordinate = randomX; //Make this a random number between 0 and gridSizeLength
	}
	
	public double getPlayerXCoordinate() {
		return playerXCoordinate;
	}
	
	public void setPlayerXCoordinate(int playerXCoordinate) {
		this.playerXCoordinate = playerXCoordinate;
	}
	
	public double getPlayerYCoordinate() {
		return playerYCoordinate;
	}
	
	public void setPlayerYCoordinate(int playerYCoordinate) {
		this.playerYCoordinate = playerYCoordinate;
	}
	
	public void travel(String direction) {
		if (direction.equals("north")) {
			this.playerYCoordinate += 1;
		} else if (direction.equals("east")) {
			this.playerXCoordinate += 1;
		} else if (direction.equals("south")) {
			this.playerYCoordinate -= 1;
		} else if (direction.equals("west")) {
			this.playerXCoordinate -= 1;
		} else {
			System.out.println("This should never have happened. travel() should only accept north east south west");
		}
	}
}
