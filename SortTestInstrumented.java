import java.util.Scanner;

// SortTestInstrumented a variation of the SortTest class
// that is used to test sorting algorithms and generate statistics
// based on counting the comparison operations
public class SortTestInstrumented {
     public static void main(String args[])
    {
        int arraySize;
        int numTrials;
        Integer data[];

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Sort Test Instrumented Started:");
        System.out.println("Please enter an integer for the size of the array?");

        // Read in an integer value for the array size:
        arraySize = getInt(" The integer value should be greater than or equal to 1: ");

        // Read in an integer value for the number of trials to run:
        System.out.println("How many trials would you like?");
        numTrials = getInt(" It should be an integer value greater than or equal to 1: ");

        //Instantiated Object of SortArrayInstrumented Class
        SortArrayInstrumented sai = new SortArrayInstrumented();

        // Loop for the number of trials:
        for (int i = 0; i < numTrials; i++) {

            // Generate an array of data containing randomly generated integers:
            data = ArrayUtil.generateRandomArray(arraySize);

            // Use an ArrayUtil method to display the initial unsorted array:
            System.out.println();
            System.out.println("The initial array (Trial = " + (i+1) + ") is: ");
            ArrayUtil.displayArrayContent(data);

            // Invoke each sort algorithm on the array
            //sai.shellSort(data, arraySize);
            //sai.selectionSort(data, arraySize);
            sai.bubbleSort(data, arraySize);

            // Display the sorted array:
            System.out.println();
            System.out.println("The sorted array (Trial = " + (i+1) + ") is: ");
            ArrayUtil.displayArrayContent(data);
        }

        // Display the statistics from the trials for the comparisons made
        System.out.println("\nTotal comparisons made: " + sai.getTotalComparisons());
        System.out.println("Average comparisons made: " + (sai.getTotalComparisons()/numTrials));
        System.out.println("Minimum comparisons made: " + sai.getMinComparisons());
        System.out.println("Maximum comparisons made: " + sai.getMaxComparisons());
        System.out.println("\nTotal swaps made: " + sai.getTotalSwaps());
        System.out.println("Average swaps made: " + (sai.getTotalSwaps()/numTrials));
        System.out.println("Minimum swaps made: " + sai.getMinSwaps());
        System.out.println("Maximum swaps made: " + sai.getMaxSwaps());
        System.out.println("\nSort Test Instrumented Ended");
        System.out.println("-------------------------------------------------------------------------------");
        }
            // Method to get an integer value from user input
            private static int getInt(String rangePrompt) 
            {
                Scanner input;

                // Integer with a default value of 10:
                int nResult = 10;

                // Wrap attempt to read from input in a try-catch block
                // so as to handle any exceptions that may arise:
                try {
                    input = new Scanner(System.in);
                    System.out.println(rangePrompt);
                    nResult = input.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("Warning: could not convert input to an integer");
                    System.out.println(e.getMessage());
                    System.out.println("Warning: will use 10 as the default value");
                } catch (Exception e) {
                    System.out.println("Warning: there was an error with System.in");
                    System.out.println(e.getMessage());
                    System.out.println("Warning: will use 10 as the default value");
                }
                return nResult;
            }
}
