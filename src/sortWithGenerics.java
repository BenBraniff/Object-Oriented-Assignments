//Ben Braniff

import java.util.*;

class Student implements Comparable<Student> {
    int grade;

    public Student(int grade) {
        this.grade = grade;
    }

    public int compareTo(Student stu) {
        return grade - stu.grade;
    }

    @Override
    public String toString() {
        return "" + grade;
    }
}


public class sortWithGenerics {

    
    public static <E extends Comparable<E>> void bubblesort(ArrayList<E> a) {
        for(int i = a.size(); i > 1; i--) {
            for(int j = 0; j < i -1; j++) {
                if(a.get(j).compareTo(a.get(j+1)) > 0) {
                    
                    E temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                    
                    // int temp = a[j];
                    // a[j] = a[j+1];
                    // a[j+1] = temp;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void mergeArray(ArrayList<E> a, int start, int middle, int end) {
        ArrayList<E> c = new ArrayList<>();
        int i = start, j = middle;
        
        while(i< middle && j < end) {
            if(a.get(i).compareTo(a.get(j)) <= 0) {
                c.add(a.get(i));
                i++;
            } else {
                c.add(a.get(j));
                j++;
            }
        }

        while(i < middle) {
            c.add(a.get(i));
            i++;
        }

        while(j < end) {
            c.add(a.get(j));
            j++;
        }

        for(i = start; i < end; i++) {
            a.set(i, c.get(i - start));
        }
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> a, int start, int end) {
        if(end - start <= 1) {
            return;
        }
        
        int middle = (start + end) / 2;
        
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> a) {
        mergeSort(a, 0, a.size());
    }

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
        

        // ArrayList<Student> arrayList = new ArrayList<>();
        // Random random = new Random();
        // for(int i = 0; i < 10; i++) {
        //     arrayList.add(new Student(random.nextInt(100)));
        // }
        

        // ArrayList<Float> arrayList = new ArrayList<>();
        // Random random = new Random();
        // for(int i = 0; i < 10; i++) {
        //     arrayList.add(random.nextFloat(100));
        // }
        
        //
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(100));
        }
        //
        
        //System.out.println(arrayList.toString());
        //bubblesort(arrayList);
        //System.out.println(arrayList.toString());
        

        System.out.println(arrayList.toString());
        mergeSort(arrayList);
        System.out.println(arrayList.toString());
    }
}
