package kata.algorithms;

public class Sorting {

	/**
	*	Any algorithm that requires sorting will always be O(n logn). The reason
	*	why is because the number of comparisons is equal to the number of possible
	*	comparisons of n which is n! (factorial). If you put your sorted array into
	*	a binary tree, the best that you can hope for is a "tree" that is fat and bushy
	*/

	/**
	*	Counting sort is a sort which works great if the range of the numbers is known and is limited:
	*	Example: If you have 1,000 integers which ranged from 10,000 - 150,000, Sort them in O(n) time.
	*	You could create an array with size (150,000 - 10,000) where each cell is the range starting with 10k.
	*	Initialize the array to zero and pass through the input one time and increment the count of each Indicie where
	*	the indicie is the starting range, and You can go through the array printing the "cell" a number of times that there
	*	is an entry to get a sorted array.
	*/
	
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
	public static void insertionSort(int[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j > 1; j--) {
				if (input[j] > input[j - 1]) {
					break;
				} else {
					swapElements(j, j-1, input);
				}
			}
		}
	}


	/**
	*  Merge sort is a O(nlog n) sorting algorithm. The goal is to continually split an 
	* array into two pieces and sort them individually, then 'merge' them together.
	* The merge is like taking two decks of cards, and bridge shuffling them together
	* the lowest card goes on top. 
	*
	*	First we need to get the midpoint. If there is only one elemnt, return itself. 
	*	Call MergeSort on itself on the first half of the array at the midpoint using the split utility
	*   Then call MergeSort on the second part of the array. This splits and returns the merged sorted copy.
	* 
	*	One of the big strengths with merge sort is being able to Merge data 'offline'
	* 	It's possible to merge data as it comes in and then store the data on disk. 
	*  	data can be merged and sorted on disk. 
	*/
	public static int[] mergeSort(int[] input) {
		int midpoint = input.length / 2;
		
		if (midpoint == 0 || input.length < 1) {
			return input;
		}

		int[] arr1 = mergeSort(split(0, midpoint, input));
		int[] arr2 = mergeSort(split(midpoint, input.length, input));
		return merge(arr1, arr2); 
	}

	/**
	*	Split is a utility method that takes in a start and stop point and returns a new array 
	* 	that is all the values between those points in the array.
	*
	*/ 
	private static int[] split(int start, int stop, int[] input) {
		if (input.length <= 1) { 
			return input;
		}
		
		int[] newArr = new int[stop - start];
		
		int counter = 0;
		for (int i = start; i < stop; i++) {
			newArr[counter++] = input[i];
		}
		return newArr;
	}

	/** 
	*	Takes in two arrays and cobines them into one array. The input of the arrays sare 
	* 	expected to be sorted. 
	*/ 
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] returnArr = new int[arr1.length + arr2.length];
		int x = 0, y = 0;
		
		for(int i = 0; i < returnArr.length; i++) {
			if (y >= arr2.length) {
				returnArr[i] = arr1[x++];
			} else if (x >= arr1.length) {
				returnArr[i] = arr2[y++];
			} else if(arr1[x] <= arr2[y]) {
				returnArr[i] = arr1[x++];
			} else if (arr2[y] <= arr1[x]) {
				returnArr[i] = arr2[y++];
			}
		}

		return returnArr;
	}

	/**
	*	Bucket and Radix sort are a combinations of fast sorts. They are attempts at making sorting
	* 	within linear time. Any time you use a lot of comparisons you can never get better then O(n logn)
	*	
	*	QuickSort is like Merge sort except instead of recursion then merge, Quicksort takes the array, figures
	*	out the array and "partitions" the array, and partitions it into two parts. The partition procedure will 
	*	find a place in the middle of the array and puts the partion to a place in the array and will do this
	*	recursive..Create two indicies with the second indicie and the second to last indicy until we find something
	*	on the left to  until we get to the center of the array and move 37 in there.   
	*/
	public static int[] partitionQuickSort(int[] input) {
		return null;
	}


	/**
	*	Uses a commonly used Data Structure: Heap. Heap is different than "dynamic allocation" of memory
	*	Heap is a data structure. 
	*
	*	'Binary Tree' in an Array -> In a binary tree-like structure, which is as "complete as possible"
	* 	it will never become unbalanced.  Children of parents are smaller than the parents
	*
	*	There are lots of ways to store trees. Storing an array in 
	* 	You got to be able txo insert things into a heap
	*	Fixing the heap is the most important thing to understand.
	*
	*	Insert takes O(log n)
	*	Delete takes O(log n)
	*	Max takes O(1)
	*	Search takes O(log neap in array.
	*	Storing Ha
	*	 
	*	If you are given an index for a particular child node, you divide by 2 and the floor
	*	Proof by induction ->  The children of a particular index are double that child and double that child + 1
	*	If you are given a particular index you divide by 2. At a parent you multiply by 2 and by 2 + 1 to go to the
	*	Children. 
	*	With the level ordering
	*
	*	Getting data into a heap is the most difficult thing to do. 
	*	Sorting in place is possible: The maximum belongs on top, the smallest begins in the end.
	*	You swap data around by checking the parent with their children. You only push things down in heap sort.
	*	The biggest child switches with the parent. Heap Sort is not stable.
	*/	
	public static int[] heapSort() {
		return null;
	}

	/**
	*	Bucket sort is really good for datasets that have a "Uniformish" distribution. Without a Uniform distribution
	*	THis is a terrible data structure. But what you do is create buckets with ranges, and put each range as a bucket
	*	Each bucket is a spot in the array, a bucket is represented as a LinkedList. When you add an item to the bucket put
	*	it in the array. 
	*
	*/
	public static int[] bucketSort() {
		return null;
	}

	/**
	*	The idea of Radix sort is to use a 'counting' sort trick on the prefix. It's just like Bucket and Counting Sort in
	*	This matter.
	*
	*/ 
	public static void radixSort(int[] input) {
		int m = input[0];
		int exp = 1;
		int n = input.length;
		int[] returnArr = new int[n];

		for (int i = 1; i < n; i++) {
			if (input[i] > m) {
				m = input[i];
			}
		}

		while(m / exp > 0) {
			int[] bucket = new int[10];
			for (int i = 0; i < n;  i++) {
				bucket[(input[i] / exp) % 10]++;
			}
			for (int i = 1; i <10; i++) {
				bucket[i] += bucket[i - 1];
			}
			for (int i = n - 1; i >= 0; i--) {
				returnArr[--bucket[(input[i] / exp) % 10]] = input[i];
			}
			for (int i = 0; i < n; i++) {
				input[i] = returnArr[i];
			}

			exp *= 10;
		}
	}

	/**
	* At 1 * 2 = 2 + 3, 2 & 3 are the children for the children of 2 would be 2* 2(+1) so 4 & 5
	* The children of 3 would be 3 * 2 + 1, so 6, 7, the children of 4 would be 8-9
	*
	*/ 
	public static int[] binaryHeap() {
		return null;
	}

	private int findLeftChildArrayLocation(int parentIndex) {
		return parentIndex * 2;
	}

	private int findRightChildArrayLocation(int parentIndex) {
		return (parentIndex * 2) + 1;
	}

	private int findParentLocation(int childLocation) {
		return childLocation / 2;
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