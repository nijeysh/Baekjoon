package baekjoon.sort;

import java.io.IOException;
import java.util.Arrays;

public class Algorithm {

    /**
     * 시간 복잡도가 O(n²)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 삽입 정렬, 거품 정렬 등이 있습니다.
     *
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
     */

    public void baekjoon2750() throws IOException {
        int n = read();
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }

     public void baekjoon2587() throws IOException {
         int arr[] = new int[5];
         int sum = 0;
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < arr.length; i++) {
            arr[i] = read();
             sum += arr[i];
         }
         Arrays.sort(arr);
         sb.append(sum / 5).append("\n").append(arr[2]);
         System.out.print(sb);
     }

    private static int read() throws IOException {
        int n;
        int result = 0;
        int operation = 1;

        while (true) {
            n = System.in.read();
            if (n == '-') {
                operation = -1;
                continue;
            }

            if (n < '0' || n > '9') {
                return result * operation;
            }

            result *= 10;
            result += n - '0';
        }
    }

    /* 정렬 */
    // merge sort
    private static int[] sortedArr;
    public void sort1() throws IOException {
        // 음수도 있음
        // 선택, 삽입, 버블 등
        // 퀵 혹은 병합
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        sortedArr = new int[n];
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("arr : " + Arrays.toString(sortedArr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int m = mid + 1;
        int idx = left;

        while (l <= mid && m <= right) {
            if (arr[l] < arr[m]) {
                sortedArr[idx] = arr[l];
                l++;
            } else {
                sortedArr[idx] = arr[m];
                m++;
            }
            idx++;
        }

        if (l > mid) {
            for (int i = m; i <= right; i++) {
                sortedArr[idx] = arr[i];
                idx++;
            }
        } else {
            for (int i = l; i <= mid; i++) {
                sortedArr[idx] = arr[i];
                idx++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sortedArr[i];
        }
    }

    // left pivot sort (quick sort)
    public void sort2() throws IOException {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        leftQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void leftQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);
        leftQuickSort(arr, left, pivot - 1);
        leftQuickSort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int low = left;
        int high = right;
        int pivot = arr[left];

        while (low < high) {
            while (arr[high] > pivot && low < high) {
                high--;
            }

            while (arr[low] <= pivot && low < high) {
                low++;
            }

            swap(arr, low, high);
        }

        swap(arr, left, low);

        return low;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
