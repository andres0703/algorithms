package basic_algorithms;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(Comparable[] list) {
        sort(list, 0, list.length - 1);
    }

    private void sort(Comparable[] list, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = partition(list, lo, hi);
        sort(list, lo, pivot - 1);
        sort(list, pivot + 1, hi);
    }

    private int partition(Comparable[] list, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (less(list[++i], list[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(list[lo], list[--j])) {
//                if (j == lo) break;  // redundant because it'll automatically stop when it reaches list[lo]
            }

            if (i >= j) {
                break;
            }

            swap(list, i, j);
        }
        swap(list, lo, j);
        return j;
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void swap(Comparable[] list, int a, int b) {
        Comparable temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        Integer[] intArr = {0, 5, 1, 9, 3, 7, 8};
        qs.quickSort(intArr);
        System.out.println(Arrays.toString(intArr));
    }
}
