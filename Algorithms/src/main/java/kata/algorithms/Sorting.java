package kata.algorithms;

public class Sorting {
	
	/**
	*   The reason why it's called Bubble sort is because
	*   it goes through a number of 'bubble' phases, where the 
	*	lightest element bubbles to the top, and the heaviest ones go down.
	*   pretty much they switch elements as they go through the array
	*
	*	This algorithm is O(n^2), best case a sorted array is O(n)
	* 	Space complexity is O(n) because sorting happens in place.
	*/
	public static void bubbleSort(int[] input) {
		boolean swapped = true;
		for (int i = 0; i < input.length - 1 && swapped; i++) {
			swapped = false;
			for (int j = 1; j < input.length - 1; j++) {
				if (input[j] > input[j+1]) {
					swapElements(j, j+1, input);
					swapped = true;
				}
			}
		}
	}


	/**
	*	Often the way most people sort cards that are in their hands.
	*	Hold the cards in your hands and move the left one to put it where
	* 	it would go to put things in order. Putting the cards in the left or right
	*	side of the hand.
	*
	* 	Each time we go through it, we will increase the sorted area by top to bottom
	*
	*/
	public static void insertionSort(int x, int y, int[] input) {

	}


	/**
	* There are different ways to swap elements. The first way is
	* to use a temp variable. which is implemented below. 
	*
	*/
	public static void swapElements(int x, int y, int[] input) {
		int temp = input[x];
		input[x] = input[y];
		input[y] = temp;
	}

	/**
	*	Second way is to add b to a, then b = a-b, and then a = a-b
	*/
	public static void arithmeticSwap(int x, int y, int[] input) {
		input[x] = input[x] + input[y];
		input[y] = input[x] - input[y];
		input[x] = input[x] - input[y];
	}

	public static void bitSwap(int x, int y, int[] input) {
		input[x] = input[x] ^ input[y];
		input[y] = input[x] ^ input[y];
		input[x] = input[x] ^ input[y];
	}

	public static void multiplicationSwap(int x, int y, int[] input) {
		input[x] = input[x] * input[y];
		input[y] = input[x] / input[y];
		input[x] = input[x] / input[y];
	}
}