package com.github.satisdrms;

import java.util.Hashtable;
import java.util.LinkedList;

//The Game of Master Mind is played as follows:
//The computer has four slots containing balls that are red (R), yellow (Y), green (G) or blue (B). For example, the computer might have RGGB (e.g., Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
//You, the user, are trying to guess the solution. You might, for example, guess YRGB.
//When you guess the correct color for the correct slot, you get a “hit”. If you guess a color that exists but is in the wrong slot, you get a “pseudo-hit”. For example, the guess YRGB has 2 hits and one pseudo hit.
//For each guess, you are told the number of hits and pseudo-hits.
//Write a method that, given a guess and a solution, returns the number of hits and pseudo hits.
enum balls {
	red, yellow, green, blue;
}

public class Topic_19_MOD_EX5 {

	public static void main(String[] args) {
		balls[] solution = { balls.red, balls.green, balls.green, balls.blue };
		balls[] input = { balls.green, balls.red, balls.green, balls.blue };
		int red = 0, blue = 0, yello = 0, green = 0;
		int hit = 0, pseudo = 0;
		LinkedList<balls> p = new LinkedList<balls>();
		for (int i = 0; i < 4; i++) {
			if (solution[i] == input[i]) {
				hit++;
			}
			if (p.contains(solution[i])) {
				pseudo++;
				p.remove(solution[i]);
			} else
				p.add(solution[i]);

			if (p.contains(input[i])) {
				pseudo++;
				p.remove(input[i]);
			} else
				p.add(input[i]);
		}

		System.out.println(hit + " " + (pseudo - hit));
	}

}
