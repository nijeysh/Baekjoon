package baekjoon.cumsum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step0 {

    static int N;
    static int M;
    static int cumsum[];
    static int max = Integer.MIN_VALUE;
    /**
     * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
     * 둘째 줄에는 N개의 수가 주어진다.
     * 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
     *
     */
    public void baekjoon11659() throws Exception {
        N = read();
        M = read();
        int[] arr = new int[N + 1];
        int[] sumArr = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            arr[i] = read();
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            int start = read() - 1;
            int end = read();

            sb.append(sumArr[end] - sumArr[start]).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 매일 아침 9시에 학교에서 측정한 온도가 어떤 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 한다.
     *
     * 매일 측정한 온도가 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 계산하는 프로그램을 작성하시오.
     * 2 <= N <= 100,000
     * 1 <= K <= N
     *
     */
    public void baekjoon2559() throws Exception {
        N = read();
        M = read();

        cumsum = new int[N + 1];
        int period[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cumsum[i] = cumsum[i - 1] + read();
            if (i >= M) {
                period[i] = cumsum[i] - cumsum[i - M];
            }
        }

        for (int i = M; i < period.length; i++) {
            if (max < period[i]) {
                max = period[i];
            }
        }

        System.out.println(max);
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
