package com.satisdrms.CCTI;

import java.util.ArrayList;

//Othello is played as follows: Each Othello piece is white on one side and black on the other. 
//When a piece is surrounded by its opponents on both the left and right sides, or both the top and bottom, it is said to be captured and its color is flipped. 
//On your turn, you must capture at least one of your opponent’s pieces. 
//The game ends when either user has no more valid moves, and the win is assigned to the person with the most pieces. Implement the object oriented design for Othello.

enum color {
	black, white
}
class Board{
	@SuppressWarnings("unchecked")
	ArrayList<Coins>[][] board=new ArrayList[8][8];
	
}
class Coins {
	color c;

	Coins(color c) {
		this.c = c;
	}
}

class game {
	Player p1, p2;

	game(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

}

class Player {
	String id;

	Player(String id) {
		this.id = id;
	}

}

class HumanPlayer extends Player {

	HumanPlayer(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	void getNextMove(){
		
	}

}

class ComputerPlayer extends Player {

	ComputerPlayer(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

}

public class Topic_19_OOD_EX8 {

	public static void main(String[] args) {

	}

}
