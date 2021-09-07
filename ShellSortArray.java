// Class for sorting an array of Comparable objects into ascending order using the Shell Sort algorithm.
public class ShellSortArray 
{
    // Wrapper method for actual shellSort Method
    public static <T extends Comparable<? super T>> void shellSort(T[] arr, int n)
    {
        // Invoke the shellSort algorithm:
        shellSort(arr, 0, n-1);
    }

    // Sorts the first n objects in an array into ascending order.
    private static <T extends Comparable<? super T>> void shellSort(T[] arr, int first, int last)
    {
        // Size of the array
        int n = last - first + 1;
        int interval = n/2;

        // Perform the interval-based insertion sort:
        while (interval > 0) {

            for (int begin = first; begin < first + interval; begin++)
            {
                //Invoke incrementalInsertionSort method to move the element.
                incrementalInsertionSort(arr, begin, last, interval);
                //Display current state of Array
                ArrayUtil.displayArrayContent(arr);
            }

        //Recalculate Interval
        interval = interval/2;
        }
    }

    // Sorts equally spaced entries of an array into ascending order.
    private static <T extends Comparable<? super T>> void incrementalInsertionSort(T[] arr, int first, int last, int interval)
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
            // Shift (make room), if necessary, in the sorted portion of the array for the entry.
            while ((index >= first) && (nextToInsert.compareTo(arr[index]) == - 1))
            {
                // Shift (make room) to the right of the current index + interval
                for the current item
                arr[index + interval] = arr[index];

                // Decrement the index by the interval:
                index = index - interval;
            }

            // Insert the entry into the array:
            arr[index + interval] = nextToInsert;
        }
    }
}
