// Class for sorting an array of Comparable objects into ascending order using the Selection Sort algorithm.

public class SelectionSortArray
{
    // Wrapper method for actual selectionSort Method
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int n)

    {
        // Invoke the selectionSort algorithm:
        selectionSort(arr, 0, n-1);
    }

    //Method which performs the Selection sort algorithm on the array
    private static <T extends Comparable<? super T>> void selectionSort(T[] arr, int first, int last)
    {

    // Loop through the array, obtaining the index of the smallest item and swapping the current item with the smallest item
        for (int index = first; index < last; index++) {

            // Identify the index of the smallest entry in the array:
            int indexOfNextSmallest = getIndexOfSmallest(arr, index, last);

            // Swap the two items
            swap(arr, index, indexOfNextSmallest);

            // Display current state of array
            ArrayUtil.displayArrayContent(arr);
        }
    }

    //Method finding the index of the smallest value in the array
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] arr, int first, int last)
    {

        // Set the current smallest value:
        T minVal = arr[first];

        // Set the index of the current smallest value:
        int indexMin = first;

            //Loop through the remainder of the array:
            for (int i = first + 1; i <= last; i++) {
            
                // Compare the value at arr[i] with the current smallest value.
                if (arr[i].compareTo(minVal) == -1) {

                // Set the current smallest value to arr[index]
                minVal = arr[i];

                // Set the index of the current smallest value to index.
                indexMin = i;
                
                }
            }
        return indexMin;
    }

    //Method to swap two entries in the array
    private static <T> void swap(T[] arr, int from, int to) {
        
        // Temporarily store the object to be moved:
        T temp = arr[from];

        // Swap the two entries
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
