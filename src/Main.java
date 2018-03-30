import java.util.Scanner;

public class Main {
    private int[] array;
    private int[] array2;
    //@TODO  1. Get arrays identical 2. Time sorts.
    public static void main(String[] args) {
        Main main = new Main();

        //prompt user for size of array.
        //create array of n size with random numbers
        //print array
        //bubble sort array
        //print array

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int arraySize = sc.nextInt();
        main.createArray(arraySize);

        System.out.println("Array 1 before bubble sort");
        main.printArray();
        main.bubbleSort();
        System.out.println("Array 1 after bubble sort");
        main.printArray();

        System.out.println();
        System.out.println("Array 2 before selection sort");
        main.printArray2();
        main.selectionSort();
        System.out.println("Array 2 after selection sort");
        main.printArray2();
    }
    private void createArray(int size){
        array = new int[size];
        array2 = new int[size];
        for (int i = 0; i < array.length; i++){

            array[i] = (int) (Math.random()*1000);

        }
        System.arraycopy(array, 0,array2,0,size);
    }
/*
    private void createArray2(int size){
        array2 = new int[size];
        for (int i = 0; i < array2.length; i++){
            array2[i] = (int) (Math.random()*1000);

        }
    }
*/
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
            }
        }
    }
}
