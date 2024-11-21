//Ben Braniff

import java.util.*;


public class mergesort {

    // merging two different arrays into one assuming each one is already sorted
    // if each one isnt already sorted then your combined array is not sorted properly
    public static int[] mergeArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while(i < a.length && j < b.length) {
            if(a[i] <= b[j]) {
                c[k] = a[i];
                k++;
                i++;
            } else {
                c[k] = b[j];
                k++;
                j++;
            }
        }
        while(i < a.length) {
            c[k] = a[i];
            k++;
            i++;
        }
        while(j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }
        return c;
    }

    // merging 2 back to back sections of the same array
    // still assuming each section is sorted
    public static void mergeArray(int[] a, int start, int middle, int end) {
        int[] c = new int[end - start];
        int i = start, j = middle, k = 0;
        
        while(i< middle && j < end) {
            if(a[i] <= a[j]) {
                c[k] = a[i];
                k++;
                i++;
            } else {
                c[k] = a[j];
                k++;
                j++;
            }
        }

        while(i < middle) {
            c[k] = a[i];
            k++;
            i++;
        }

        while(j < end) {
            c[k] = a[j];
            k++;
            j++;
        }

        for(i = start; i < end; i++) {
            a[i] = c[i - start];
        }
    }

    // merging-sorting a section of an array through the use of recursion
    public static void mergeSort(int[] a, int start, int end) {
        // a[start] is included
        // a[end] is not included in the mergeSort
        if(end - start <= 1) {
            return;
        }
        
        int middle = (start + end) / 2;
        
        //                  V middle not included
        mergeSort(a, start, middle);
        //          V middle included
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    // merge-sorting the whole array
    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }


    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i=0;i<arrayLength; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }


    public static boolean isSorted(int[] array) {
        for ( int i=0; i< array.length - 1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void printTheArray (int[] a, int length) {
        for(int i = 0; i <length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws Exception {
        int length = 6_000_000;
        int[] array = createRandomArray(length);
        
        //printTheArray(array, length);
        System.out.println("is array sorted?\n"+isSorted(array));
        
        long startTime = System.currentTimeMillis();
        mergeSort(array);
        long timeSpent = System.currentTimeMillis() - startTime;
        
        //printTheArray(array, length);
        System.out.println("is array sorted?\n"+isSorted(array));
        System.out.println("it took " + timeSpent + " milliseconds to run code");
        
    }
}
