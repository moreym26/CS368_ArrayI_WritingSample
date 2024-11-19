import java.io.*;
import java.util.*;

public class ArrayMain {

    /**
     * Our main method.
     *  - Prompt user for a # of elements.
     *  - Create array of that size, using random values in the range
     *    -1000 to 1000, inclusive.
     *  - Compute and print various things about the array's contents.
     * @param args
     * 
     */
    public static void main(String[] args) {
        int numElements = getNumElements();
        if (numElements <= 0) {
            System.out.println("We need a positive number.");
            return;
        }

        // declare and initialize our array
        int[] numberArray = createNumberArray(numElements);

        /////////////////////////////////////////////////////////////////
        //   At this point, the array has been created and initialized.
        /////////////////////////////////////////////////////////////////

        // ***** CHECKPOINT 1 *****
        // Print the numbers, followed by a line of dashes
        System.out.println("-----Checkpoint 1-----");
        for (int i = 0; i < numberArray.length; i++){
            System.out.println(numberArray[i]);
        }
        System.out.println("--------------------");
        
        // ***** CHECKPOINT 2 *****
        // Compute/print the average of the numbers
        System.out.println("-----Checkpoint 2-----");
        int numAv = 0;
        for (int i = 0; i < numberArray.length; i++){
            numAv += numberArray[i];
        }
        numAv = numAv / numberArray.length;
        System.out.println("The average of the numbers is: "+ numAv);

        
        // ***** CHECKPOINT 3 *****
        // Set a breakpoint somewhere above and show the contents of the array
        System.out.println("-----Checkpoint 3-----");


        // ***** CHECKPOINT 4 *****
        // Find/print the smallest number in the array
        System.out.println("-----Checkpoint 4-----");
        int smallNum = numberArray[0];
        for (int i = 0; i < numberArray.length; i++){
            if (numberArray[i] < smallNum){
                smallNum = numberArray[i];
            }
        }

        System.out.println("The minimum element is "+ smallNum);


        // ***** CHECKPOINT 5 *****
        // Find/print the percentage of numbers that is even
        System.out.println("-----Checkpoint 5-----");
        float percentEven;
        float numEven = 0;
        for (int i = 0; i < numberArray.length; i++){
            if (numberArray[i] % 2 == 0){
                numEven++;
            }
        }
        percentEven = numEven / numberArray.length;
        System.out.println("The percentage of even numbers is "+ percentEven);


        // ***** CHECKPOINT 6 *****
        // Compute/print the percentage of numbers in the range -300 to 300
        System.out.println("-----Checkpoint 6-----");
        float percentRange;
        float numRange = 0;
        for (int i = 0; i < numberArray.length; i++){
            if (numberArray[i] >= -300 && numberArray[i] <= 300){
                numRange++;
            }
        }
        percentRange = numRange / numberArray.length;
        System.out.println("The percentage of numbers in the range -300..300 is "+ percentRange);

        /**
         * Context: Students will be trying to figure out how to do checkpoint 7 or 8
         * and may not realize checkpoint 8 is inside of checkpoint 7.
         * 
         * Importance: This edit will demonstrate to students that sometimes goals in 
         * code need to be nested/work together. That you don't need to do more work in
         * rewriting lines of code but using the ones that you are using already.
         * 
         * Justification: I added the checkpoint labels in front and inside the for loop to make it
         * very clear where the checkpoints code is supposed to go.
         */
        // ***** CHECKPOINT 7 & 8 *****
        
        //Initiate vars if necessary here outside of the loop
        int newSmall= numberArray[0];
        int oldOne=0;
        for (int i =0; i < numElements; i++){
            for (int x = i + 1; x < numElements; x++){
                //***** Checkpoint 7 *****
                // Sort the numbers and print them out
                if(numberArray[i] < numberArray[x]){
                    oldOne= numberArray[i];
                    numberArray[i]= numberArray[x];
                    numberArray[x]= oldOne;
                }
            }
        
            // ***** CHECKPOINT 8 *****
            // Print the sorted numbers in a list 
            // separated by spaces, up to 10 per line
            if (i % 10 != 0) {
                    System.out.print(numberArray[i]+" ");
                }
            else if (i % 10 == 0) {
                    System.out.println("");
                    System.out.print(numberArray[i] + " ");

                }
        }
    }
 
    private static int getNumElements() {
        Scanner keyboard = new Scanner(System.in); // set up for keyboard input

        // prompt user for file name; read file name
        System.out.print("Number of elements: ");
        System.out.flush();
        
        return keyboard.nextInt();
    }

    private static int[] createNumberArray(int numElements) {
        Random rand = new Random();
        return rand.ints(numElements, -1000, 1001).toArray();
    }
}