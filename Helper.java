package Project1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.*;


public class Helper 
{
    //Method 1, print a string to console
    static void printString(String input)
    {
        System.out.print(input);
    }
    
    //Method 2, generate an array of random numbers
    static int[] intRandom1DArray(int size)
    {
        return new Random().ints().limit(size).toArray();
    }
    //Method 3, generate a 2D array of random numbers
    static int[][] intRand2DArray(int row, int col)
    {
        return IntStream.range(0, row).mapToObj(x 
                -> new Random().ints().limit(col).toArray())
                .toArray(int[][]::new) ;       
    }
    
    //Method 4, Convert an 2D array to a string
    static String int2DArrayToString(int[][] input)
    {
        return Arrays.stream(input).map(x -> Arrays.stream(x).
                mapToObj(i -> String.format(" % 6d", i))
                .reduce("", (a,b) -> a + b)).reduce("", (a,b) -> a + b+'\n');
    }
    //Method 5, Get the date using localDateTime
    static String getDate()
    {
        return LocalDateTime.now().toString() ;
    }
    //Method 6, prompt the user for input given a message
    static String promptForInput(String msg)
    {
        Scanner reader = new Scanner(System.in);
        System.out.print(msg);
        return reader.next();

    }
    // Method 7, generate an ordered array
    static int[] orderedArray(int size)
    {
        return IntStream.range(0, size).toArray();
    }
      // Method 8, generate an ordered 2D array
    static int[][] ordered2DArray(int row, int col)
    {
        return IntStream.range(0, row).mapToObj(x 
                -> IntStream.range(x*10, x*10+col)
                        .toArray()).toArray(int[][]::new);
    }
    
      // Method 9, sum an array
    static int  sumArray(int[] input)
    {
        return Arrays.stream(input).reduce(0, (a,b) -> a + b);
    }
    
    // Method 10, find the Average of an array
    static int  averageArray(int[] input)
    {
        return Arrays.stream(input).reduce(0, (a,b) -> a + b)/input.length;
    }
    
    // Method 11, sum an array
    static int  sum2DArray(int[][] input)
    {
        return Arrays.stream(input).mapToInt(x->Arrays.stream(x)
                .reduce(0, (a,b) -> a + b)).reduce(0, (a,b) -> a + b);
    }
    
    // Method 12, find the Average of an array
    static int  average2DArray(int[][] input)
    {
        return Arrays.stream(input).mapToInt(x->Arrays.stream(x)
                .reduce(0, (a,b) -> a + b)/x.length)
                .reduce(0, (a,b) -> a + b)/(input.length);
    }
    //Method 13, generate an array of random numbers
    static double[] doubleRandom1DArray(int size)
    {
        return new Random().doubles().limit(size).toArray();
    }
    //Method 14, generate a 2D array of random numbers
    public static double[][] doubleRand2DArray(int row, int col)
    {
        return IntStream.range(0, row).mapToObj(x 
                -> Helper.doubleRandom1DArray(col))
                .toArray(double[][]::new) ;       
    }
    //Method 15, Convert an 2D array to a string
    public static String double2DArrayToString(double[][] input)
    {
        return Arrays.stream(input).map(x -> Arrays.stream(x).
                mapToObj(i -> String.format(" % 6d", i))
                .reduce("", (a,b) -> a + b)).reduce("", (a,b) -> a + b+'\n');
    }
}