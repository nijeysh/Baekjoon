package baekjoon.numbertheory;

import java.io.IOException;
import java.util.Arrays;

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

    /**
     * 한 줄에 두 정수 A와 B가 공백으로 분리되어 주어진다.
     *
     * 50%의 입력 중 A와 B는 1000(10^3)보다 작다. 다른 50%의 입력은 1000보다 크고 100000000(10^8)보다 작다.
     */
    public void baekjoon13241() throws IOException {
        int a = read();
        int b = read();
        long min = ((long) a * b / gcd(a, b));
        System.out.println(min);
    }

    /**
     * 분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.
     *
     * 두 분수의 합 또한 분수로 표현할 수 있다.
     * 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 기약분수란 더 이상 약분되지 않는 분수를 의미한다.
     */
    public void baekjoon1735() throws IOException {
        int a = read();
        int b = read();
        int c = read();
        int d = read();
        StringBuilder sb = new StringBuilder();
        int gcd = gcd(b, d);
//        int numerator = ((d / gcd) * a) + ((b / gcd) * c);
        int numerator = (a * d + c * b) / gcd;
        int denominator = b * d / gcd;
        int gcd2 = gcd(numerator, denominator);
        sb.append(numerator / gcd2).append(" ").append(denominator / gcd2);

        System.out.println(sb);
    }

    public void baekjoon2485() throws IOException {
        int n = read();
        int[] arr = new int[n];
        arr[0] = read();
        arr[1] = read();
        int gap = arr[1] - arr[0];
        int gcd = gcd(arr[1], arr[0]);
        int count = 0;

        for (int i = 2; i < n; i++) {
            arr[i] = read();
            gcd = gcd(arr[i], gcd);
            gap = arr[i] - arr[i - 1];
        }

        System.out.println(gcd);
        System.out.println((arr[n - 1] - arr[0]) / gcd);
        System.out.println(n - 1);
        System.out.print(((arr[n - 1] - arr[0]) / gcd) - (n - 1));

        // 이거 맞는데..
//        System.out.println(gcd(2, gcd(6, gcd(12, 18))));
//        int current = arr[0] + gcd;
//        int index = 1;
//        while (index < arr.length) {
//            if (arr[index] == current) {
//                index++;
//            } else {
//                count++;
//            }
//            current += gcd;
//        }
//        System.out.println(gcd);
//        System.out.println(count);
    }

    // 최대 공약수
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

    // 최소 공배수 = (두 자연수의 곱 / 최대공약수)
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
