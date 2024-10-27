package baekjoon.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm1 {

    /**
     *
     * MenOfPassion(A[], n) {
     *     i = ⌊n / 2⌋;
     *     return A[i]; # 코드1
     * }
     *
     */
    public void baekjoon24262() throws IOException {
        // 수행횟수
        StringBuilder sb = new StringBuilder();
        sb.append("1").append("\n").append("0");
        System.out.print(sb);
    }

    /**
     *
     * MenOfPassion(A[], n) {
     *     sum <- 0;
     *     for i <- 1 to n
     *         sum <- sum + A[i]; # 코드1
     *     return sum;
     * }
     *
     */
    public void baekjoon24263() throws IOException {
        // 수행횟수 - n만큼 반복
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(n).append("\n").append("1");
        System.out.print(sb);
    }

    /**
     *
     * MenOfPassion(A[], n) {
     *     sum <- 0;
     *     for i <- 1 to n
     *         for j <- 1 to n
     *             sum <- sum + A[i] × A[j]; # 코드1
     *     return sum;
     * }
     *
     * int로 받을 때 -> sb.append(String.format("%.0f", Math.pow(n, 2))).append("\n").append("2");
     * int 대신 long으로 받아서 제곱을 구한다
     */
    public void baekjoon24264() throws IOException {
        long n = read();
        // n^2
        StringBuilder sb = new StringBuilder();
        sb.append(n * n).append("\n").append("2");
        System.out.print(sb);
    }

    /**
     *
     * MenOfPassion(A[], n) {
     *     sum <- 0;
     *     for i <- 1 to n - 1
     *         for j <- i + 1 to n
     *             sum <- sum + A[i] × A[j]; # 코드1
     *     return sum;
     * }
     *
     * n, n - 1, n - 2, ... , 1의 합 : n(n + 1) / 2
     *
     * (n / 2) * (n + 1)
     */
    public void baekjoon24265() throws IOException {
        long n = read();
        // 1 to (n - 1)
        // (i + 1) to n
        // n, n - 1, n - 2, ...., 1
//        long sum = ((n * n) + n) / 2;
        StringBuilder sb = new StringBuilder();
        sb.append((n * (n - 1)) / 2).append("\n").append("2");
        System.out.print(sb);
    }

    /**
     *
     * MenOfPassion(A[], n) {
     *     sum <- 0;
     *     for i <- 1 to n
     *         for j <- 1 to n
     *             for k <- 1 to n
     *                 sum <- sum + A[i] × A[j] × A[k]; # 코드1
     *     return sum;
     * }
     *
     *
     */
    public void baekjoon24266() throws IOException {
        long n = read();
        // 1 ~ n
        // 1 ~ n까지
        // 1 ~ n까지
        // n의 3제곱
        StringBuilder sb = new StringBuilder();
        sb.append(n * n * n).append("\n").append("3");
        System.out.print(sb);
    }

    /**
     *
     * MenOfPassion(A[], n) {
     *     sum <- 0;
     *     for i <- 1 to n - 2
     *         for j <- i + 1 to n - 1
     *             for k <- j + 1 to n
     *                 sum <- sum + A[i] × A[j] × A[k]; # 코드1
     *     return sum;
     * }
     *
     */
    public void baekjoon24267() throws IOException {
        long n = read();
        // 1 ~ (n - 2)
        // (i + 1) ~ (n - 1)
        // (j + 1) ~ (n)

        StringBuilder sb = new StringBuilder();
        sb.append(((n - 2)* (n - 1) * n) / 6).append("\n").append("3");
        System.out.print(sb);
    }

    public void test() throws IOException {
        long n = read();
        long a = 0;
        long b = 0;
        long count = 0;
        for (int i = 1; i <= n - 2; i++) {
            a++;
            for (int j = i + 1; j <= n - 1; j++) {
                b++;
                for (int k = j + 1; k <= n; k++) {
                    count++;
                }
            }
        }
        System.out.println("count: " + count);
    }

    // 수정예정
    public void baekjoon24313() throws IOException {
        // f(n) = a1 * n + a2;
        // n => n >= n0,  f(n) <= c * g(n) 안에 c와 n0이 존재
        // n의 조건 ..
        int a1 = read();    // 7
        int a0 = read();    // 7
        int n;
        int c = read();     // 8
        int n0 = read();    // 1

        n = n0;
        boolean exist = check(a1, n, a0, c);
        System.out.print(exist ? 1 : 0);
    }
    private static boolean check(int a1, int n, int a0, int c) {
        for (int i = n; i <= 100; i++) {
            if ((a1 * i) + a0 > c * i) {
                return false;
            }
        }
        return true;
    }

    private static int read() throws IOException {
        int n;
        int result = 0;
        while (true) {
            n = System.in.read();
            if (n < '0' || n > '9') {
                return result;
            }

            result *= 10;
            result += n - '0';
        }
    }
}
