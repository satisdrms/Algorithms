package com.github.satisdrms;

public class HanoiStackNode {
	int weight;
	HanoiStackNode above, below;

	HanoiStackNode(int weight) {
		this.weight = weight;
		above = null;
		below = null;
	}

}
