package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdvancedLevel2 {
    /**
     * 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다.
     * 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
     *
     */
    public void baekjoon1037() throws Exception {
        // 개수
        int n = read();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 진짜 약수
        for (int i = 0; i < n; i++) {
            int A = read();
            min = Math.min(min, A);
            max = Math.max(max, A);
        }
        System.out.print((long) min * max);
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
