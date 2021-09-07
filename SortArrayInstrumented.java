// Instantiable Class for generating comparison operation statistics for each sorting algorithm
public class SortArrayInstrumented 
{
    // Declaration of statistics variables used to compute statistics
    private long comparisons;
    private long totalComparisons;
    private long maxComparisons;
    private long minComparisons;
    private long swaps;
    private long totalSwaps;
    private long maxSwaps;
    private long minSwaps;
    // Default constructor for the SortArrayInstrumented class.
    public SortArrayInstrumented()
    {
        // Initialization of statistics variables
        comparisons = 0;
        totalComparisons = 0;
        maxComparisons = 0;
        minComparisons = Long.MAX_VALUE;
        swaps = 0;
        totalSwaps = 0;
        maxSwaps = 0;
        minSwaps = Long.MAX_VALUE;
    }
    // Accessor methods for the statistics
    public Long getTotalComparisons()
    {
        return totalComparisons;
    }

        public Long getMaxComparisons()
    {
        return maxComparisons;
    }

    public Long getMinComparisons()
    {
        return minComparisons;
    }

    public Long getTotalSwaps()
    {
        return totalSwaps;
    }

    public Long getMaxSwaps()
    {
        return maxSwaps;
    }

    public Long getMinSwaps()
    {
        return minSwaps;
    }

    // Method to start collecting data:
    private void startStatistics()
    {
        comparisons = 0;
        swaps = 0;
    }

    // Method to stop collecting data and compute the resulting statistics.
    private void endStatistics()
    {
        totalComparisons = totalComparisons + comparisons;
        totalSwaps = totalSwaps + swaps;
        if(comparisons < minComparisons)
        {
            minComparisons = comparisons;
        }

        if(comparisons > maxComparisons)
        {
            maxComparisons = comparisons;
        }

        if(swaps < minSwaps)
        {
            minSwaps = swaps;
        }

        if(swaps > maxSwaps)
        {
            maxSwaps = swaps;
        }
    }

    /**Methods for performing each sorting algorithm */

    // Shell Sort
    public <T extends Comparable<? super T>> void shellSort(T[] arr, int n)
    {
        // Invoke Method to start collecting data
        startStatistics();

        // Invoke the shellSort algorithm:
        shellSort(arr, 0, n-1);

        // Invoke Method to stop collecting data and compute the resulting statistics.
        endStatistics();
    }

    private <T extends Comparable<? super T>> void shellSort(T[] arr, int first, int last)
    {
        // Size of the array
        int n = last - first + 1;
        int interval = n/2;
        // Perform the interval-based insertion sort:
        while (interval > 0) 
        {
            for (int begin = first; begin < first + interval; begin++) 
            {
                // Invoke incrementalInsertionSort method to move the element
                incrementalInsertionSort(arr, begin, last, interval);
            }

        // Recalculate the interval
        interval = interval/2;
        }
    }

    private <T extends Comparable<? super T>> void incrementalInsertionSort(T[] arr, int first, int last, int interval)
    {
    int unsorted, index;
    //Loop through the array, insert each unsorted item in order
        for (unsorted = first + interval; unsorted <= last; unsorted = unsorted + interval)
        {
            // Get the next item in the unsorted array to be inserted
            T nextToInsert = arr[unsorted];

            // Set the index to the first entry in the unsorted part of the array
            (unsorted - interval)
            index = unsorted - interval;

            // Insert the entry into the appropriate position in the array.
            while ((index >= first) && (nextToInsert.compareTo(arr[index]) == -1))
            {
                //Increment number of comparisons made
                comparisons++;

                // Shift (make room) to the right of the current index + interval for the current item
                arr[index + interval] = arr[index];

                //Increment number of swaps made
                swaps++;

                // Decrement the index by the interval:
                index = index - interval;
            }

            if(index >= first)
            {
                //Increment number of comparisons made
                comparisons++;
            }

            // Insert the entry into the array:
            arr[index + interval] = nextToInsert;
        }
    }
    /** Bubble Sort */
    public <T extends Comparable<? super T>> void bubbleSort(T[] arr, int n)
    {
        // Invoke Method to start collecting data
        startStatistics();

        // Invoke the bubbleSort algorithm:
        bubbleSort(arr, 0, n-2);

        // Invoke Method to stop collecting data and compute the resulting statistics.
        endStatistics();
    }

    private <T extends Comparable<? super T>> void bubbleSort(T[] arr, int first, int last)
    {
    //Loop through the array
    while(first < last)
    {
        //Stores position of the last entry swapped
        int lastSwap = first;

        // Perform bubble sort
        for(int i = first; i <= last; i++)
        {
            // Compare adjacent entries
            if(arr[i+1].compareTo(arr[i]) == -1)
            {
                //Increment number of comparisons made
                comparisons++;

                //Invoke method swapping entries that are out of order
                swap(arr, i);

                //Increment number of swaps made
                swaps++;
                lastSwap = i;
            }
            else
            {
                //Increment number of comparisons made
                comparisons++;
            }
        }
        // Update last entry to be compared
        last = lastSwap;
        }
    }

    private <T extends Comparable<? super T>> void swap(T[] arr, int i)
    {
        // Temporarily store the object to be moved:
        T temp = arr[i];

        // Swap the two entries
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }

    /** Selection Sort */
    public <T extends Comparable<? super T>> void selectionSort(T[] arr, int n)
    {
        // Invoke Method to start collecting data
        startStatistics();

        // Invoke the selectionSort algorithm:
        selectionSort(arr, 0, n-1);

        // Invoke Method to stop collecting data and compute the resulting statistics.
        endStatistics();
    }

    private <T extends Comparable<? super T>> void selectionSort(T[] arr, int first, int last)
    {
        //Loop through the array, obtaining the index of the smallest item
        for (int i = first; i < last; i++) 
        {
            // Identify the index of the smallest entry in the array
            int indexOfNextSmallest = getIndexOfSmallest(arr, i, last);
            if(indexOfNextSmallest != i)
            {
                //Invoke method swapping the two entries
                swap(arr, i, indexOfNextSmallest);
                //Increment number of swaps made
                swaps++;
            }
        }
    }

    private <T extends Comparable<? super T>> int getIndexOfSmallest(T[] arr, int
    first, int last)
    {
        // Set the current smallest value
        T minVal = arr[first];

        // Set the index of the current smallest value
        int indexMin = first;

        //Loop through the remainder of the array
        for (int i = first + 1; i <= last; i++) 
        {
            // Compare the value at arr[index] with the current smallest value.
            if (arr[i].compareTo(minVal) == -1)
            {
                //Increment number of comparisons made
                comparisons++;

                // Set the current smallest value to arr[i]
                minVal = arr[i];

                // Set the index of the current smallest value to index.
                indexMin = i;
            }
            else
            {
                //Increment number of comparisons made
                comparisons++;
            }
        }
        return indexMin;
    }
    private <T> void swap(T[] arr, int from, int to)
    {
        // Temporarily store the object to be moved:
        T temp = arr[from];
        // Swap the two entries
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
