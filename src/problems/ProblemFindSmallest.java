package problems;

import common.Problem;

import java.util.Arrays;

/**
 * Solution for <a href="https://projecteuler.net/problem=FindSmallest">Problem FindSmallest</a>
 * from <a href="https://projecteuler.net/">Project Euler</a>
 */
public class ProblemFindSmallest extends Problem {
    public static void main(String[] args) {
        new ProblemFindSmallest().runBoth();
    }

    final int[] numbers = {10, 4, 6, 3, 2, 1, 9, 7, 8, 5};

    final int n = 5;

    @Override
    protected void solve() {
        int[] arr = Arrays.copyOf(numbers, 10);
        bubbleNsort(arr, n);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    @Override
    protected void solveSimple() {
        int[] arr = Arrays.copyOf(numbers, 10);
        heapNsort(arr, n);
        for(int i = arr.length - 1; i > arr.length-1-n; i--) {
            System.out.print(arr[i] + ", ");
        }
    }

    void heapify(int arr[], int N, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < N && arr[l] < arr[largest])
            largest = l;
        if (r < N && arr[r] < arr[largest])
            largest = r;
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, N, largest);
        }
    }

    void heapNsort(int[] arr, int n)
    {
        int N = arr.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
        int tmp;
        for (int i = N - 1; i >= n; i--) {
            tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i, 0);
        }
    }

    private void bubbleNsort(int[] arr, int n) {
        int tmp;
        for(int m = 0; m < n; m++) {
            for(int i = arr.length-2; i >= m; i--) {
                if(arr[i] > arr[i+1]) {
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
    }
}