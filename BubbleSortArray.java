// Class for sorting an array of Comparable objects into ascending order using the Bubble Sort algorithm.
public class BubbleSortArray
{
    // Wrapper method for actual bubbleSort Method
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int n)
    {
        // Invoke the bubbleSort algorithm:
        bubbleSort(arr, 0, n-2);
    }

    //Method which performs the Bubble sort algorithm on the array
    private static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int first, int last)
    {
        //Loop through the array
        while(first < last)
        {
            //Get the position of the last entry swapped
            int lastSwap = first;

            // Perform bubble sort
            for(int i = first; i <= last; i++)
            {
                // Compare adjacent entries
                if(arr[i+1].compareTo(arr[i]) == -1)
                {
                    //Invoke method swapping entries that are out of order
                    swap(arr, i);

                    //Update last entry swapped to i(index)
                    lastSwap = i;
                }
            }
            // Update last entry to be compared
            last = lastSwap;

            // Display current state of the array
            ArrayUtil.displayArrayContent(arr);
        }
    }

    //Method to swap two entries in the array
    private static <T extends Comparable<? super T>> void swap(T[] arr, int i)
    {
        // Temporarily store the object to be moved:
        T temp = arr[i];

        // Swap the two entries
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }
}