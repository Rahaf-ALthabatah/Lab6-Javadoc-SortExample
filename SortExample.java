/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6javadoc;

import java.util.*;

/**
 * Provides sorting utility methods including Quick Sort and Merge Sort,
 * along with helper methods for swapping elements and verifying sort order.
 *
 * @author Rahaf Sinan Al-Thabath
 * @version 1.0
 */
public class SortExample {

    /**
     * Main entry point to demonstrate Quick Sort and Merge Sort algorithms.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Unsorted arrays for testing
        Integer[] array1 = new Integer[]{12, 13, 24, 10, 3, 6, 90, 70};
        int[] array2 = {2, 6, 3, 5, 1};

        // Sort array1 using Quick Sort and print result
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        // Sort array2 using Merge Sort and print result
        mergeSort(array2, array2.length);
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts an array of Integers in ascending order using the Quick Sort algorithm.
     *
     * @param arr  The array of Integer elements to be sorted.
     * @param low  The starting index of the subarray to sort.
     * @param high The ending index of the subarray to sort.
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low;
        int j = high;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements at specified positions in an Integer array.
     *
     * @param array The array in which elements will be swapped.
     * @param x     The index of the first element.
     * @param y     The index of the second element.
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Recursively divides and sorts an integer array using the Merge Sort algorithm.
     *
     * @param a The integer array to be sorted.
     * @param n The number of elements in the array.
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sorted subarrays into a single sorted array.
     *
     * @param a     The destination array to store merged elements.
     * @param l     The left sorted subarray.
     * @param r     The right sorted subarray.
     * @param left  The number of elements in the left subarray.
     * @param right The number of elements in the right subarray.
     */
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks whether an integer array is sorted in ascending order.
     *
     * @param x The integer array to check.
     * @return {@code true} if the array is sorted in ascending order; {@code false} otherwise.
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }
}