package com.game.dare.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Generate {
	public static Queue<Integer> randomSequence(int max) {
		Random rng = new Random();
		Queue<Integer> generated = new LinkedList<Integer>();
		for (int i = 0; i < max; i++) {
			while (true) {
				Integer next = rng.nextInt(max) + 1;
				if (!generated.contains(next)) {
					// Done for this iteration
					generated.add(next);
					break;
				}
			}
		}
		return generated;
	}
}
