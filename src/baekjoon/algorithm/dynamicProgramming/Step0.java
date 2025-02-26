package baekjoon.algorithm.dynamicProgramming;

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
    static int[][][] dp;
    public void baekjoon9184() throws Exception {
        StringBuilder sb = new StringBuilder();
        dp = new int[21][21][21];

        while (true) {
            int a = read();
            int b = read();
            int c = read();

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c)).append("\n");
//            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
        System.out.print(sb);
    }

    static int w(int a, int b, int c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
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
