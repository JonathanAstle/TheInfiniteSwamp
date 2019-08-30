package com.qa.assessment;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
	private double treasureXCoordinate;
	private double treasureYCoordinate;
	private ArrayList<ArrayList<String>> board; 
	
	public Grid(int gridSideLength) {
		//had to use doubles for this to work :(
		double randomNumber1 = Math.random()* gridSideLength;
		double randomNumber2 = Math.random()* gridSideLength;
		double randomX = randomNumber1 - randomNumber1%1;
		double randomY = randomNumber2 - randomNumber2%1;
		
		
		
		
		
		
		this.treasureXCoordinate = randomX; //Make this a random number between 0 and gridSizeLength
		this.treasureYCoordinate = randomY; //Make this a random number between 0 and gridSizeLength
		
		
		
		ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> y = new ArrayList<String>();
		for (int i = 0; i<gridSideLength; i++) {
			y.add("o");
		}
		
		ArrayList<String> rowWithTreasure = new ArrayList<String>();
		for (int i = 0; i<gridSideLength; i++ ) {
			if (i==treasureYCoordinate) {
				rowWithTreasure.add("x");
			} else {
				rowWithTreasure.add("o");
			}
		}
			
		for (int i = 0; i<gridSideLength; i++) {
			if (i!=treasureXCoordinate) {
				board.add(y);
			} else {
				board.add(rowWithTreasure);
			}
			
		}
		
		this.board = board;
	}
	
	public void displayBoard() {
		for (ArrayList<String> row: board) {
			System.out.println(row);
		}
	}
	
	public double getTreasureXCoordinate() {
		return treasureXCoordinate;
	}
	
	public void setTreasureXCoordinate(int treasureXCoordinate) {
		this.treasureXCoordinate = treasureXCoordinate;
	}
	
	public double getTreasureYCoordinate() {
		return treasureYCoordinate;
	}
	
	public void setTreasureYCoordinate(int treasureYCoordinate) {
		this.treasureYCoordinate = treasureYCoordinate;
	}
	
}
