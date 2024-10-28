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
    /**
     *
     * O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다.}
     * f(n) = a1n + a0,
     * (0 ≤ |ai| ≤ 100) => 음수가 가능하다
     * (1 ≤ c ≤ 100)
     * (1 ≤ n0 ≤ 100)
     * f(n), c, n0가 O(n) 정의를 만족하면 1, 아니면 0을 출력한다.
     *
     *
     * 7 7
     * 8
     * 1
     * => 0
     * f(n) = 7n + 7, g(n) = n, c = 8, n0 = 1이다. f(1) = 14, c × g(1) = 8이므로 O(n) 정의를 만족하지 못한다.
     *
     *
     * 7 7
     * 8
     * 10
     * => 1
     * f(n) = 7n + 7, g(n) = n, c = 8, n0 = 10이다. 모든 n ≥ 10에 대하여 7n + 7 ≤ 8n 이므로 O(n) 정의를 만족한다.
     *
     * if (c-a1 < 0 || (c-a1)* n0 < a0 ) System.out.println("0");
     * else System.out.println("1");
     */
    public void baekjoon24313() throws IOException {
        // f(n) = a1 * n + a0;
        // n => n >= n0,  f(n) <= c * g(n) 안에 c와 n0이 존재
        // n의 조건 ..
        int a1 = read();    // 4
        int a0 = read();    // -2
        int c = read();     // 4
        int n0 = read();    // 2
        boolean bigO = true;

        // (c - a1)n >= a0
        // 음수일때
        if (c < a1) {
            bigO = false;

        // 0일 때
        } else if (c == a1) {
            // a0는 음수가 가능하기 때문에
            if (a0 > 0) {
                bigO = false;
            }

        // 양수일 때: if (c > a1)
        } else {
            if ((c - a1) * n0 < a0) {
                bigO = false;
            }
        }
        System.out.print(bigO ? 1 : 0);
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
}
