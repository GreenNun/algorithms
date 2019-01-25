package eu.bausov.algorithms.basics.mergesrot.impl;

import eu.bausov.algorithms.basics.mergesrot.MergeSort;
import eu.bausov.algorithms.basics.util.Tuple2;

import java.util.Arrays;

/**
 * Created by GreenNun on 2019-01-24.
 */
public class MergeSortImpl implements MergeSort {
    public static void main(String[] args) {
        final int[] unsorted = {8, 6, 4, 8, 6, 4, 2, 5, 4, 8, 5, 9, 1, 4, 6, 3, 5, 2, 8, 5, 6, 4, 7, 5, 6, 3, 0};
        System.out.println(Arrays.toString(unsorted));

        final int[] sorted = new MergeSortImpl().sort(unsorted);
        System.out.println(Arrays.toString(sorted));
    }

    public int[] sort(int[] array) {
        if (array.length > 2) {
            final Tuple2<int[], int[]> tuple = splitArray(array);
            final int[] sort1 = sort(tuple.getFirst());
            final int[] sort2 = sort(tuple.getSecond());
            return mergeSorted(sort1, sort2);
        } else {
            if (array.length == 1) {
                return array;
            } else {
                final int i1 = array[0];
                final int i2 = array[1];
                if (i1 < i2) {
                    return new int[]{i1, i2};
                } else {
                    return new int[]{i2, i1};
                }
            }
        }
    }

    public Tuple2<int[], int[]> splitArray(int[] array) {
        final int[] ints1 = Arrays.copyOfRange(array, 0, array.length / 2);
        final int[] ints2 = Arrays.copyOfRange(array, array.length / 2, array.length);

        return new Tuple2<>(ints1, ints2);
    }

    public int[] mergeSorted(int[] arr1, int[] arr2) {
        final int[] merged = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;

        for (int k = 0; k < merged.length; k++) {
            if (arr1.length == i) {
                return addTail(arr2, merged, j, k);
            }

            if (arr2.length == j) {
                return addTail(arr1, merged, i, k);
            }

            if (arr1[i] < arr2[j]) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }

        }

        return merged;
    }

    private int[] addTail(int[] arr, int[] merged, int j, int k) {
        for (int l = j; l < arr.length; l++) {
            merged[k] = arr[l];
            k++;
        }
        return merged;
    }
}
