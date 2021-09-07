import java.util.Scanner;

//Sort Test Class used to test sorting algorithms
public class SortTest
{
    public static void main(String args[])
    {
        int arraySize;
        Integer dataSelectionSort[];
        Integer dataShellSort[];
        Integer dataBubbleSort[];

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Sort Test Started:");
        System.out.println("Please enter an integer for the size of the array?");

        // Read in an integer value for the array size:
        arraySize = getInt("  The integer value should be greater than or equal to 1: ");

        // Generate an array of data containing randomly generated integers:
        dataSelectionSort = ArrayUtil.generateRandomArray(arraySize);

        // Duplication of array for each sorting algorithm
        dataShellSort = ArrayUtil.duplicateArray(dataSelectionSort);
        dataBubbleSort = ArrayUtil.duplicateArray(dataSelectionSort);

        selectionSortArray(dataSelectionSort, arraySize);
        shellSortArray(dataShellSort, arraySize);
        bubbleSortArray(dataBubbleSort, arraySize);

        System.out.println("\nSort Test Ended");
        System.out.println("-------------------------------------------------------------------------------");
    }

    // Method to get an integer value from user input
    private static int getInt(String rangePrompt)
    {
        Scanner input;

        // Integer with a default value of 10:
        int nResult = 10;

        // Handle exceptions with try-catch block
        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            nResult = input.nextInt();
        }
        catch(NumberFormatException e) {
            System.out.println("Warning: could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Warning: will use 10 as the default value");
        }
        catch(Exception e) {
            System.out.println("Warning: there was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Warning: will use 10 as the default value");
        }
        return nResult;
    }

    //Methods invoking each sorting algorithm on the array
    private static void selectionSortArray(Integer dataSelectionSort[], int arraySize)
    {
        //Displays initial, unsorted array:
        System.out.println("\n-------------------------------------------");
        System.out.println();
        System.out.println("The initial array is: ");
        ArrayUtil.displayArrayContent(dataSelectionSort);

        //Invokes the Selection Sort algorithm on the array:
        System.out.println();
        System.out.println("Sorting using Selection Sort (Iterative): ");
        SelectionSortArray.selectionSort(dataSelectionSort, arraySize);

        //Displays the sorted array:
        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataSelectionSort);
    }

    private static void shellSortArray(Integer dataShellSort[], int arraySize)
    {
        System.out.println("\n-------------------------------------------");
        System.out.println();
        System.out.println("The initial array is: ");
        ArrayUtil.displayArrayContent(dataShellSort);

        System.out.println();
        System.out.println("Sorting using Shell Sort (Iterative): ");
        ShellSortArray.shellSort(dataShellSort, arraySize);

        // Displays the sorted array:
        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataShellSort);
    }

    private static void bubbleSortArray(Integer dataBubbleSort[], int arraySize)
    {
        System.out.println("\n-------------------------------------------");
        System.out.println();
        System.out.println("The initial array is: ");
        ArrayUtil.displayArrayContent(dataBubbleSort);

        System.out.println();
        System.out.println("Sorting using Bubble Sort (Iterative): ");
        BubbleSortArray.bubbleSort(dataBubbleSort, arraySize);

        // Displays the sorted array:
        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataBubbleSort);
    }
}