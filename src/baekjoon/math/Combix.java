package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Combix {
    public void baekjoon15439() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n * (n - 1));
    }

    /**
     * 녹색 거탑
     *
     */
    public void baekjoon24723() throws Exception {
        
    }

    /**
     * 팩토리얼
     * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
     */
    public void baekjoon10872() throws Exception {
        int n = read();
        long result = 1;
        for (int i = n; i > 1; i--) {
            result *= i;
        }
        System.out.print(result);
    }

    /**
     * 이항계수1
     *
     */
    static int[][] dp;
    public void baekjoon11050() throws Exception {
        int n = read();
        int k = read();

        System.out.print(factorial(n) / (factorial(k) * factorial(n - k)));
    }

    private static int factorial(int n) throws Exception {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

//    public void baekjoon11050() throws Exception {
//        int n = read();
//        int k = read();
//        dp = new int[n + 1][k + 1];
//
//        System.out.println(bc(n, k));
//    }

    /**
     * 다리 놓기
     *
     */
    public void baekjoon1010() throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = read();
            int m = read();
            int min = Math.min(n, m);

        }

    }

    private static int bc(int n, int k) throws Exception {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (n == k || k == 0) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = bc(n - 1, k - 1) + bc(n - 1, k);
    }

    private static int read() throws Exception {
        int n;
        int operation = 1;
        int result = 0;
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
