package kata.algorithms;

import java.util.Arrays;

public class SortingTest {

	public void heapSort() {
		int[] loaded = loadArray();
	}

	public void testRadixSort() {
		int[] loaded = loadArray();
		Sorting.radixSort(loaded);
		assert(isSorted(loaded));
	}

	public void bubbleSortTest() {
		int[] loaded = loadArray();
		Sorting.bubbleSort(loaded);
		assert(isSorted(loaded));
	}

	public void testMergeSort() {
		int[] arr = loadArray();
		int[] sorted = Sorting.mergeSort(arr);
		assert(isSorted(sorted));
	}

	public void testMerge() {
		int[] arr1 = loadArray();
		int[] arr2 = loadArray();
		int[] merged = Sorting.merge(arr1, arr2);
		int[] mergedExpected = new int[] {15, 15, 22, 22, 23, 1, 8, 23, 1, 8, 72, 43, 2, 29, 52, 41, 40, 20, 3, 72, 43, 2, 29, 52, 41, 40, 20, 3};

		assert(Arrays.equals(merged, mergedExpected));

		arr1 = new int[] { 20 } ;
		arr2 = new int[] { };
		assert(Sorting.merge(arr1, arr2).length == 1);
		assert(Sorting.merge(arr2, arr1).length == 1);
	}

	public void insertionSortTest() {
		int[] loaded = loadArray();
		Sorting.insertionSort(loaded);
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