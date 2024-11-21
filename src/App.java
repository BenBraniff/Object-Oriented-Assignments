import java.util.*;
import java.io.*;


public class App {

    // swaps 2 neighboring elements in the array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /* the original bubbleSort method */
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static boolean isSorted(int[] array) {
        for ( int i=0; i< array.length - 1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i=0;i<arrayLength; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) throws IOException {
        try(FileWriter fileWriter = new FileWriter(filename)) {
            for (int i = 0; i < array.length; i++) {
                fileWriter.write(array[i] + "\n");
            }
        }
    }

    public static int[] readFileToArray(String filename) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()) {
                    String s = scanner.nextLine();
                    arrayList.add(Integer.parseInt(s));
                }
                scanner.close();
            } catch (IOException e) {

            }
            int[] array = new int[arrayList.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = arrayList.get(i);
                System.out.println(array[i]);
            }
            return array;
    }

    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the array length:");
        int arrayLength = scanner.nextInt();
        
        int[] array= createRandomArray(arrayLength);
        
        writeArrayToFile(array, "ArrayFile.txt");

        System.out.println("Here's the array");
        readFileToArray("ArrayFile.txt");
        
        
        System.out.println("is array sorted?\n"+isSorted(array));
        bubbleSort(array);
        System.out.println("is array sorted?\n"+isSorted(array));
        scanner.close();
    }
}
