package com.qa.infiniteswamp;

import java.util.ArrayList;

public class Grid {
	private int treasureXCoordinate = 4;
	private int treasureYCoordinate = 4;
	private ArrayList<ArrayList<String>> board; 
	
	public Grid(boolean isNewBoard, int gridSideLength, int playerX, int playerY) {
		if (isNewBoard) {
			int randomX = (int)(Math.random()*(gridSideLength));
			int randomY = (int)(Math.random()*(gridSideLength));
		
			while (randomX == playerX && randomY == playerY) {
				System.out.println("while loop is working now"); //comment this out before submitting
				randomX = (int)(Math.random()*(gridSideLength));
				randomY = (int)(Math.random()*(gridSideLength));
			}
			
			System.out.println("random X treasure X is " + randomX);
			System.out.println("random Y treasure Y is " + randomY);
			System.out.println("player X is " + playerX);
			System.out.println("player Y is " + playerY);
			this.treasureXCoordinate = randomX; 
			this.treasureYCoordinate = randomY; 
		}	
		produceBoard(gridSideLength, playerX, playerY, this.treasureXCoordinate, this.treasureYCoordinate);
	}
	
	public Grid(boolean isNewBoard, int gridSideLength, int playerX, int playerY, int treasureX, int treasureY) {
		this.treasureXCoordinate = treasureX;
		this.treasureYCoordinate = treasureY;
		produceBoard(gridSideLength, playerX, playerY, treasureX, treasureY);
	}
	
	public void displayBoard() {
		for (ArrayList<String> row: board) {
			System.out.println(row);
		}
	}
	
	public int getTreasureXCoordinate() {
		return treasureXCoordinate;
	}
	
	public void setTreasureXCoordinate(int treasureXCoordinate) {
		this.treasureXCoordinate = treasureXCoordinate;
	}
	
	public int getTreasureYCoordinate() {
		return treasureYCoordinate;
	}
	
	public void setTreasureYCoordinate(int treasureYCoordinate) {
		this.treasureYCoordinate = treasureYCoordinate;
	}
	
	public void produceBoard(int gridSideLength ,int playerX, int playerY, int treasureX, int treasureY) {
		ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
		
		for (int i = 0; i<gridSideLength; i++) {
			ArrayList<String> emptyArray = new ArrayList<String>();
			board.add(emptyArray);
		}
		
		for (int i = 0; i<gridSideLength; i++) {
			for (int j = 0; j<gridSideLength; j++) {
				if (i == this.treasureXCoordinate && j == this.treasureYCoordinate) {
					board.get(j).add("x");
					continue;
				}
				
				if (i == playerX && j == playerY) {
					board.get(j).add("p");
					continue;
				}
				
				board.get(j).add(" ");
			}
		}
		
		this.board = board;
	}
	
	public double the2DDistance(int gridSideLength, int playerX, int playerY, int treasureX, int treasureY) {
		int xDist = the1DDistance(gridSideLength, playerX, treasureX);
		int yDist = the1DDistance(gridSideLength, playerY, treasureY);
		double dist = Math.sqrt(xDist*xDist + yDist*yDist);
		
		return dist;
	}
	
	public int the1DDistance(int gridSideLength, int x, int p) {
		int dist = Math.abs(p-x);
		
		if (Math.abs(x+gridSideLength - p) < dist) {
			dist = Math.abs(x+gridSideLength - p);
		} if (Math.abs(p+gridSideLength - x) < dist) {
			dist = Math.abs(p+gridSideLength - x);
		}
		
		return dist;
	}
	
}
