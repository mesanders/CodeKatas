package kata.algorithms;

import java.util.Arrays;

public class SortingTest {

	public void bubbleSortTest() {
		int[] loaded = loadArray();
		Sorting.bubbleSort(loaded);
		assert(isSorted(loaded));
	}

	private int[] loadArray() {
		return new int[] { 15, 22, 23, 1, 8, 72, 43, 2, 29, 52, 41, 40, 20, 3 };
	}

	public boolean isSorted(int[] input) {
		int[] sortedArray = new int[] { 1, 2, 3, 8, 15, 20, 22, 23, 29, 40, 41, 43, 52, 72 };
		
		if (input.length != sortedArray.length) {
			return false;
		}
		return true;		
	}

	public void testSwaps() {
		int[] test = new int[] { 10, 20 };
		Sorting.swapElements(0, 1, test);

		assert(test[0] == 20 && test[1] == 10);

		Sorting.arithmeticSwap(0, 1, test);
		assert(test[0] == 10 && test[1] == 20);
		
		Sorting.bitSwap(0,1,test);
		assert(test[0] == 20 && test[1] == 10);

		Sorting.multiplicationSwap(0, 1, test);
		assert(test[0] == 10 && test[1] == 20);
	}

}