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
        // 최대 n
        int n;
        int m;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = read();
            m = read();
            long sum = 1;
            long denom = 1;
            int num = 2;
            for (int j = m; j > m - n; j--) {
                sum *= j;
                if (sum % num == 0 && num <= n) sum /= num++;
            }
            for (int j = num; j <= n; j++) {
                denom *= j;
            }
            sb.append(sum / denom).append("\n");
        }
        System.out.print(sb);
    }

    // 메모이제이션
//    static int[][] combinations = new int[30][30];
//    public void baekjoon1010() throws Exception {
//        int tc = read();
//        StringBuilder sb = new StringBuilder();
//
//        while (tc-- > 0) {
//            int n = read(), m = read();
//            sb.append(comb(m, n)).append("\n");
//        }
//
//        System.out.println(sb);
//    }
//
//    private static int comb(int n, int r) {
//        if (combinations[n][r] > 0) return combinations[n][r];
//        if (r == 0 || r == n) return combinations[n][r] = 1;
//        return combinations[n][r] = comb(n - 1, r) + comb(n - 1, r - 1);
//    }

    private static long factorial(long n) throws Exception {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
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
