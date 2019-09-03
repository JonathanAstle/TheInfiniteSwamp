package com.qa.infiniteswamp;

public class Player {
	private String name;
	private int playerXCoordinate;
	private int playerYCoordinate;
	
	public Player(String name, int gridSideLength) {
		int randomX = (int)(Math.random()*(gridSideLength));
		int randomY = (int)(Math.random()*(gridSideLength));
		
		this.name = name;
		this.playerXCoordinate = randomX; //Make this a random number between 0 and gridSizeLength
		this.playerYCoordinate = randomY; //Make this a random number between 0 and gridSizeLength
	}
	
	public String getname() {
		return this.name;
	}
	
	public int getPlayerXCoordinate() {
		return playerXCoordinate;
	}
	
	public void setPlayerXCoordinate(int playerXCoordinate) {
		this.playerXCoordinate = playerXCoordinate;
	}
	
	public int getPlayerYCoordinate() {
		return playerYCoordinate;
	}
	
	public void setPlayerYCoordinate(int playerYCoordinate) {
		this.playerYCoordinate = playerYCoordinate;
	}
	
	public void travel(String direction) {
		if (direction.equals("north")) {
			this.playerYCoordinate -= 1;
		} else if (direction.equals("east")) {
			this.playerXCoordinate += 1;
		} else if (direction.equals("south")) {
			this.playerYCoordinate += 1;
		} else if (direction.equals("west")) {
			this.playerXCoordinate -= 1;
		} else {
			//comment this out later
			System.out.println("This should never have happened. travel() should only accept north east south west");
		}
	}
}
