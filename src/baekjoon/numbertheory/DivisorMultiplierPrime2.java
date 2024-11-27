package baekjoon.numbertheory;

import java.io.IOException;

public class DivisorMultiplierPrime2 {
    public void baekjoon1934() throws IOException {
/*
        int n = read();
        int result;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = read();
            int b = read();
            int max = Math.max(a, b);
            result = 1;
            for (int j = 2; j <= max; j++) {
                while (a % j == 0 || b % j == 0) {
                    if (a % j == 0) {
                        a = a / j;
                    }
                    if (b % j == 0) {
                        b = b / j;
                    }
                    result *= j;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
*/
        // 유클리드 호제법
        int n = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = read();
            int b = read();

            sb.append(a * b / gcd(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    // 최소 공배수
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
        // 재귀 형식
//        if (b == 0) return a;
//        return gcd(b, a % b);
    }

    // 최대 공약수
    private static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return a * b / gcd;
    }

    private static int read() throws IOException {
        int n;
        int result = 0;
        int operation = 1;

        while (true) {
            n = System.in.read();
            if (n == '-') {
                operation = -1;
            }
            if (n < '0' || n > '9') {
                return result * operation;
            }

            result *= 10;
            result += n - '0';
        }
    }
}
