package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    /**
     * 5개의 수의 평균과 중앙값을 구하는 문제
     *
     */
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

    /**
     * 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.
     *
     * 이들 중 점수가 가장 높은 k명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
     * 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
     *
     */
    public void baekjoon25305() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(arr[n - k]);
    }

    /**
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
     * 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
     *
     */
    public void baekjoon2751() throws IOException {
    }

    /**
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
     *
     */
    public void baekjoon10989() throws IOException {
    }

    /**
     * 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
     * N은 1,000,000,000보다 작거나 같은 자연수이다.
     *
     * char[] arr = s.toCharArray();
     * String result = new StringBuilder(new String(arr)).reverse().toString();
     *
     * 혹은
     *
     * Arrays.sort(arr, Collections.reverseOrder());
     */
    public void baekjoon1427() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] arr = new int[n.length()];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i) - '0';
        }
        Arrays.sort(arr);

        for (int i = (arr.length - 1); i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.print(sb);
    }

    /**
     * 2차원 평면 위의 점 N개가 주어진다.
     * 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
     *
     * (확인 예시)
     * 5
     * -1 5
     * 1 5
     * -1 0
     * 1 4
     * 2 3
     */
    public void baekjoon11650() throws IOException {
        int n = read();
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[n][2];

        // (0, 0) (1, 0) (2, 0) (3, 0) (4, 0)
        for (int i = 0; i < n; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }

        // 1) thenComparingInt
        // Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] b) -> b[1]));

        // 2) new Comparator
        /*Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int cmp = Integer.compare(o1[0], o2[0]);
                if (cmp != 0) {
                    return cmp;
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });*/

        // 3) x[0], y[0] -> x[1], y[1]
        Arrays.sort(arr, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }
        });

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 2차원 평면 위의 점 N개가 주어진다.
     * 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
     *
     */
    public void baekjoon11651() throws IOException {
        int n = read();
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt((int[] b) -> b[0]));

        /*Arrays.sort(arr, (x, y) -> {
            if (x[1] == y[1]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });*/

        /*Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });*/

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
     *
     * 길이가 짧은 것부터
     * 길이가 같으면 사전 순으로
     * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
     *
     * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
     * 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
     *
     */
    public void baekjoon1181() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set set = new HashSet();
        StringBuilder sb = new StringBuilder();

        // 중복 제거하기
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        Object[] arr = set.toArray();
        // 1) Comparator.comparing
//        Arrays.sort(arr, Comparator.comparingInt(x -> x.toString().length()).thenComparing(x -> x.toString()));

        // 2) new Comparator
        Arrays.sort(arr, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.toString().length() == o2.toString().length()) {
                    return o1.toString().compareTo(o2.toString());
                } else {
                    return o1.toString().length() - o2.toString().length();
                }
            }
        });


        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
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
    /* merge sort */


    /* left pivot sort (quick sort) */
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
