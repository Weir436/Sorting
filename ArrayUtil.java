import java.util.Random;

public class ArrayUtil {

    // Method to display the contents of an array of objects as a String
    public static void displayArrayContent(Object [] data)
    {
        System.out.println(getString(data));
    }

    // Method to return the contents of an array of objects as a String
    private static String getString(Object [] data)
    {
        String resultString = new String("[ ");

        for(int i = 0; i< data.length; i++) {
            resultString = resultString + data[i].toString() + " ";
        }
        resultString = resultString + "]";

        return resultString;
    }

    // Method to generate an array of random integer values.
    public static Integer[] generateRandomArray(int size)
    {
        Integer resultArray[] = new Integer[size];
        Random generator = new Random();

        for(int i = 0; i< size; i++) {
            int value = generator.nextInt(size);
            resultArray[i] = value;
        }
        return resultArray;
    }



    // Method to duplicate the content of an array.
    public static Integer[] duplicateArray(Object [] orig)
    {
        int size = orig.length;
        Integer resultArray[] = new Integer[size];

        for(int i = 0; i< size; i++) {
            resultArray[i] = (Integer) orig[i];
        }
        return resultArray;
    }
}


