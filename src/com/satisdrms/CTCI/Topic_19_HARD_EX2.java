package com.satisdrms.CTCI;

import java.util.LinkedList;
import java.util.Random;

//Write a method to shuffle a deck of cards. 
//It must be a perfect shuffle - in other words, each 52! permutations of the deck has to be equally likely. 
//Assume that you are given a random number generator which is perfect.

public class Topic_19_HARD_EX2 {

	public static void main(String[] args) {
		mysol();
		bookSol();
		System.out.println(Math.random());
	}

	private static void bookSol() {
		int[] cards = new int[52];
		int temp, index;
		for (int i = 0; i < cards.length; i++) {
			index = (int) (Math.random() * (cards.length - i)) + i;
			temp = cards[i];
			cards[i] = cards[index];
			cards[index] = temp;
		}

	}

	private static void mysol() {
		Random rand52 = new Random();
		int[] deck = new int[52];
		int totalCards = 0;
		LinkedList<Integer> shuffledDeck = new LinkedList<Integer>();
		while (true) {
			int rand = rand52.nextInt(52);
			if (deck[rand] == 0) {
				shuffledDeck.add(rand);
				deck[rand] = 1;
				totalCards++;
			}
			if (totalCards == 52)
				break;

		}
		for (Integer i : shuffledDeck) {
			System.out.println(i);
		}
	}

}
