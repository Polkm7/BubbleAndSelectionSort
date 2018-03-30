import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {
    private int[] array;
    private int[] array2;
    private long itemsSorted = 0;

    public static void main(String[] args) {
        Main main = new Main();

        //prompt user for size of array.
        //create array of n size with random numbers
        //print array
        //bubble sort array
        //print array

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");


        main.runIteration(500, 1000);
        main.runIteration(2500, 1000);
        main.runIteration(5000, 1000);



        /*        main.createArray(arraySize);

        long runningTime = 0;
        long startTime;
        long endTime;
        long timeElapsed;

        int loopCount = 500;

        main.resetItemsSorted();
        for(int i = 0;i < loopCount; i++){
            main.createArray(arraySize);
            startTime = System.currentTimeMillis();
            //start timer
            main.bubbleSort();
            //stop timer
            endTime = System.currentTimeMillis();
            timeElapsed = endTime - startTime;
            runningTime += timeElapsed;

        }
        System.out.println("Time elapsed for bubble sort: " + runningTime);
        System.out.println("Milliseconds per operation: " + (double)runningTime/loopCount + "." );
        System.out.println("Items sorted: " + main.getItemsSorted());


        runningTime = 0;
        main.resetItemsSorted();
        for(int i = 0;i < loopCount; i++){
            main.createArray2(arraySize);
            startTime = System.currentTimeMillis();
            //start timer
            main.selectionSort();
            //stop timer
            endTime = System.currentTimeMillis();
            timeElapsed = endTime - startTime;
            runningTime += timeElapsed;
        }
        System.out.println("Time elapsed for selection sort: " + runningTime);
        System.out.println("Milliseconds per operation: " + (double)runningTime/loopCount + "." );
        System.out.println("Items sorted: " + main.getItemsSorted());*/

    }
    private void createArray(int size){
        array = new int[size];
        for (int i = 0; i < array.length; i++){

            array[i] = (int) (Math.random()*1000);

        }
    }

    private void createArray2(int size){
        array2 = new int[size];
        for (int i = 0; i < array2.length; i++){
            array2[i] = (int) (Math.random()*1000);

        }
    }

    private void printArray(){
        System.out.print("Array 1: ");
        for(int number : array){
            System.out.print(number+", ");

        }
        System.out.println();
    }
    private void printArray2(){
        System.out.print("Array 2: ");
        for(int number : array2){
            System.out.print(number+", ");

        }
        System.out.println();
    }
    private void bubbleSort(){
        int temp;
        for(int l = array.length; l > 0; l--){
            for(int i = 1; i < array.length; i++){
                if(array[i -1] > array[i]){ //if left number if bigger, swap with the smaller one to the right
                    temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                    itemsSorted++;
                }
            }
        }

    }
    /*The algorithm starts at the first position in the array and looks through the array for the smallest element.
    Once it reaches the end of the array, it puts that element in the first cell of the array.
    It then restarts the whole process from the second position in the array,
    and continues until the entire array has been sorted.
     */
    private void selectionSort() {
        int i, j;
        int iMin;
        int temp;
        for(j = 0; j < array2.length; j++){
            iMin = j;

            for ( i = j+1; i < array2.length; i++) {
                if (array2[i] < array2[iMin]) {
                    iMin = i;
                }
            }

            if ( iMin != j ) {
                temp = array2[j];
                array2[j] = array2[iMin];
                array2[iMin] = temp;
                itemsSorted++;
            }
        }
    }
    private long getItemsSorted(){
        return itemsSorted;
    }
    private void resetItemsSorted(){
        itemsSorted = 0;
    }
    private void runIteration(int arraySize, int loopCount){
        System.out.println("///////Running array size " + arraySize +  ". ////////");
        createArray(arraySize);

        long runningTime = 0;
        long startTime;
        long endTime;
        long timeElapsed;


        resetItemsSorted();
        for(int i = 0;i < loopCount; i++){
            createArray(arraySize);
            startTime = System.currentTimeMillis();
            //start timer
            bubbleSort();
            //stop timer
            endTime = System.currentTimeMillis();
            timeElapsed = endTime - startTime;
            runningTime += timeElapsed;

        }
        System.out.println("Time elapsed for bubble sort: " + runningTime);
        System.out.println("Milliseconds per operation: " + (double)runningTime/loopCount + "." );
        System.out.println("Items sorted: " + getItemsSorted());


        runningTime = 0;
        resetItemsSorted();
        for(int i = 0;i < loopCount; i++){
            createArray2(arraySize);
            startTime = System.currentTimeMillis();
            //start timer
            selectionSort();
            //stop timer
            endTime = System.currentTimeMillis();
            timeElapsed = endTime - startTime;
            runningTime += timeElapsed;
        }
        System.out.println("Time elapsed for selection sort: " + runningTime);
        System.out.println("Milliseconds per operation: " + (double)runningTime/loopCount + "." );
        System.out.println("Items sorted: " + getItemsSorted());

        System.out.println();
        System.out.println();
    }
}
