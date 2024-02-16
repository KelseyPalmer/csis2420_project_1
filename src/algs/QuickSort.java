package algs;

import java.io.*;

class QuickSort {
    static int comparisons = 0; // Class-level variable to count comparisons

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // Increment comparison counter for each comparison made
            comparisons++;

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Reset comparison counter at the start of the sorting process
        comparisons = 0;
        
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int N = arr.length;

        quickSort(arr, 0, N - 1);
        System.out.println("Sorted array:");
        printArr(arr);
        System.out.println("Total comparisons made: " + comparisons);
    }
}