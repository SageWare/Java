package benchmarkingsorts;

/**-------------ABOUT----------------
 * @author Sage Fremont
 * This program creates 2 arrays of integers, of equal length, filled with the same set of random numbers
 * The first array "a" is sorted via selection short, the second array "b" by insertion sort
 * Time is calculated for benchmarking purposes of the different types of sorting methods */

/**------------REPORTS---------------
 * SORT TIME IN MILLISECONDS:
 * Size 1000 array a : 2 (range ~2-4 after multiple trials)
 * Size 1000 array b : 2 (range ~2-3 after multiple trials)
 * Size 10000 array a : 50 (range ~48-54 after multiple trials)
 * Size 10000 array b : 33 (range ~32-36 after multiple trials)
 * Size 100000 array a : 4551 (range ~4494-4596 after multiple trials)
 * Size 100000 array b : 2825 (range ~2752-2834 after multiple trials)

 * SORT TIME IN SECONDS:
 * Size 1000 array a : ~0.002
 * Size 1000 array b : ~0.002
 * Size 10000 array a : ~0.050
 * Size 10000 array b : ~0.033
 * Size 100000 array a : ~4.551
 * Size 100000 array b : ~2.825
 *
 * CONCLUSION: According to the trials, Insertion Sort is slightly more efficient.  */


public class BenchmarkingSorts {

	
	/** Selection Sort Routine
	* @param array of integers */
	static void selectionSort(int[] A) {
		for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
			int maxLoc = 0;  // Location of largest item seen so far.
			for (int j = 1; j <= lastPlace; j++) {
				if (A[j] > A[maxLoc]) {
					maxLoc = j;  
				}
			}
			int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
			A[maxLoc] = A[lastPlace];
			A[lastPlace] = temp;
		}  // end of for loop
	}

	/** Insertion Sort Routine
	* @param array of integers */
	static void insertionSort(int[] A) {
		int itemsSorted; // Number of items that have been sorted so far.
		for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {   
			int temp = A[itemsSorted];  // The item to be inserted.
			int loc = itemsSorted - 1;  // Start at end of list.
			while (loc >= 0 && A[loc] > temp) {
				A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
				loc = loc - 1;       // Go on to next location.
			}
			A[loc + 1] = temp; // Put temp in last vacated space.
		}
	}


	public static void main(String[] args) {

		// Create arrays a and b & set constant size
		int[] a;
		int[] b;
		int size = 10000;
		a = new int[size];
		b = new int[size];

		// Fill both arrays with the same random numbers
		for ( int i = 0; i <= a.length-1; i++ ){
			int rand = (int) Math.floor(Math.random()*101);
			a[i] = rand;
			b[i] = rand;
		}

		// Selection Sort for array a & runtime calculations
		double startTimeAms = System.currentTimeMillis();
		selectionSort(a);
		double runTimeAms = System.currentTimeMillis() - startTimeAms;
		double runTimeA = runTimeAms / 1000;

		// Insertion Sort for array b & runtime calculations
		double startTimeBms = System.currentTimeMillis();
		insertionSort(b);
		double runTimeBms = System.currentTimeMillis() - startTimeBms;
		double runTimeB = runTimeBms / 1000;

		// Reports runtime for sorting a & b in both ms and seconds
		System.out.println("Size = " + size);
		System.out.println("The runtime for array a sorting in milliseconds = " + runTimeAms);
		System.out.println("The runtime for array a sorting in seconds = " + runTimeA);
		System.out.println("The runtime for array b sorting in milliseconds = " + runTimeBms);
		System.out.println("The runtime for array b sorting in seconds = " + runTimeB);
		System.exit(0); // Terminates program
	}

}

