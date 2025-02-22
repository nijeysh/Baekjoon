package baekjoon.algorithm.dynamicProgramming;

import java.util.Arrays;

public class Step0 {

    /**
     * 알고리즘 수업 - 피보나치 수 1
     *
     */
    static int[] f = new int[41];
    static int count = 0;
    public void baekjoon24416() throws Exception {
        int n = read();
        f[1] = f[2] = 1;

        System.out.print(fibonacci(n) + " " + (n - 2));
    }

    static int fib(long n) {
        if (n == 1 || n == 2) {
            count++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    /**
     * 신나는 함수 실행
     *
     */
    public void baekjoon9184() throws Exception {

    }

    /**
     * 정수 삼각형
     */
    static int[][] triangle;
    static int N;
    public void baekjoon1932() throws Exception {
        N = read();
        triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = read();
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        System.out.println(triangle[0][0]);
    }

    static void triangle(int parent, int depth) throws Exception {
//        if (depth == N) {
//            int val = dp[parent];
//            if (val > max) {
//                max = val;
//            }
////            System.out.println(dp[parent]);
////            System.out.println(Arrays.toString(dp));
//            return;
//        }
//        dp[0] = arr[0];
//
//        dp[1] = arr[0] + arr[1];
//        dp[2] = arr[0] + arr[2];
//
//        dp[3] = arr[0] + arr[1] + arr[3];
//        dp[4] = arr[0] + arr[1] + arr[4];
//        dp[4] = arr[0] + arr[2] + arr[4];
//        dp[5] = arr[0] + arr[2] + arr[5];

        // parent = 0, start = 1, end = 2
        // parent = 1, start = 3, end = 4
//        int start = parent + depth;
//        int end = start + 1;
//        for (int i = start; i <= end; i++) {
//            dp[i] = dp[parent] + arr[i];
//            System.out.println("dp[" + i + "] = dp[" + parent + "] + arr[" + i + "];");
////            System.out.println(Arrays.toString(dp));
//            triangle(i, depth + 1);
//        }
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
