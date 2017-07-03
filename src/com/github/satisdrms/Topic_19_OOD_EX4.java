package com.github.satisdrms;

import java.util.ArrayList;

//Design a chess game using object oriented principles.

class ChessBoard {
	ArrayList<Piece>[] piece = new ArrayList[32];

	void move(Piece p, Spot s1, Spot s2) {
		if (isPossible(p, s1, s2)) {
			s2.empty = false;
			s1.empty = true;
			p.pos=s2;
			if(kill(p,s1,s2)){
				//remoce piece from chess board
			}
		}
	}

	private boolean kill(Piece p, Spot s1, Spot s2) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isPossible(Piece p, Spot s1, Spot s2) {
		// TODO Auto-generated method stub
		return false;
	}

}

class Piece {
	Spot pos;
	String name;
	boolean canJump = false;
	Move steps;
}

class Move {
	ArrayList<STEPS> move = new ArrayList<STEPS>();
}

enum STEPS {
	UP, DOWN, LEFTUP, RIGHTUP, LEFTDOWN, RIGHTDOWN, LEFT, RIGHT
}

class Spot {
	int pos;
	boolean empty;
}

public class Topic_19_OOD_EX4 {
	public static void main(String[] args) {

	}
}
