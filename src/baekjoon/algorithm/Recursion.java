package baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Recursion {
    public void baekjoon27433() throws Exception {
        int n = read();
        System.out.print(factorial(n));
    }

    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * 피보나치 수 5
     *
     * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
     * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
     * n = 17일때 까지 피보나치 수를 써보면 다음과 같다.
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
     * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
     *
     */
    static int arr[];
    public void baekjoon10870() throws Exception {
        int n = read();
        arr = new int[n + 2];
        arr[1] = 1;
        System.out.print(fibonacci(2, n));
    }

    private static long fibonacci(int number, int end) throws Exception {
        arr[number] = arr[number - 1] + arr[number - 2];
        if (number <= end) {
            return arr[number];
        }

        return fibonacci(number + 1, end);
    }

    private static int count;
    public void baekjoon25501() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            sb.append(isPalindrome(br.readLine())).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    private static int recursion(String str, int left, int right) {
        count++;
        if (left >= right) return 1;
        else if (str.charAt(left) != str.charAt(right)) return 0;
        else return recursion(str, left + 1, right - 1);
    }

    /**
     * 알고리즘 수업 - 병합 정렬 1
     *
     * N개의 서로 다른 양의 정수가 저장된 배열 A가 있다.
     * 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.
     *
     * 첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 500,000), 저장 횟수 K(1 ≤ K ≤ 108)가 주어진다.
     * 다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
     *
     * 배열 A에 K 번째 저장 되는 수를 출력한다. 저장 횟수가 K 보다 작으면 -1을 출력한다.
     */
    static int sortedArr[];
    static int index;
    static int K;
    static int RESULT = -1;
    public void baekjoon24060() throws Exception {
        int N = read(); // 배열의 크기
        K = read(); // 저장 횟수

        int arr[] = new int[N];
        sortedArr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }

        merge_sort(arr, 0, arr.length - 1);
        System.out.print(RESULT);
    }

    private static void merge_sort(int[] arr, int left, int right) {
        int mid;

        if (left < right) {
            mid = (left + right) / 2;
            
            merge_sort(arr, left, mid);              // 왼쪽
            merge_sort(arr, mid + 1, right);    // 오른쪽
            
            merge(arr, left, mid, right);    // 병합 작업
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = left;

        while (i <= mid && j <= right) {
            // 왼쪽 arr[i]가 arr[j]보다 작거나 같을 경우 왼쪽 arr[i]를 sortedArr[t]에 넣는다 (t증가, i증가)
            if (arr[i] <= arr[j]) {
                sortedArr[t++] = arr[i++];
            } else {
                sortedArr[t++] = arr[j++];
            }
        }

        // 왼쪽 배열 부분이 남은 경우
        while (i <= mid) {
            sortedArr[t++] = arr[i++];
        }

        while (j <= right) {
            sortedArr[t++] = arr[j++];
        }

        // 정렬된 배열을 기존의 배열에 복사
        for (int p = left; p <= right; p++) {
            index++;
            arr[p] = sortedArr[p];
            if (index == K) {
                RESULT = arr[p];
                return;
            }
        }
    }

    /**
     * 칸토어 집합
     *
     */
    public void baekjoon4779() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            int n = (int) Math.pow(3, Integer.parseInt(line));
            boolean[] arr = new boolean[n];
            cantor(arr, 0, arr.length);

            for (int i = 0; i < arr.length; i++) {
                if (arr[i]) {
                    sb.append(" ");
                } else {
                    sb.append("-");
                }
            }
            sb.append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.close();
    }

    private static void cantor(boolean[] arr, int left, int right) {
        int mid;
        int midL;
        int midR;

        // 3등분하기
        // true는 공백으로
        // 왼쪽과 오른쪽
        if (left < right) {
            mid = (right - left) / 3;
            midL = left + mid;
            midR = right - mid;
            if (mid >= 1) {
                for (int i = midL; i < midR; i++) {
                    arr[i] = true;
                }

                cantor(arr, left, midL);      // 왼쪽
                cantor(arr, midR, right);    // 오른쪽
            }
        }
    }

    private static int read() throws Exception {
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
}
