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

    /**
     * 직선으로 되어있는 도로의 한 편에 가로수가 임의의 간격으로 심어져있다. KOI 시에서는 가로수들이 모두 같은 간격이 되도록 가로수를 추가로 심는 사업을 추진하고 있다. KOI 시에서는 예산문제로 가능한 한 가장 적은 수의 나무를 심고 싶다.
     *
     * 편의상 가로수의 위치는 기준점으로 부터 떨어져 있는 거리로 표현되며, 가로수의 위치는 모두 양의 정수이다.
     * 예를 들어, 가로수가 (1, 3, 7, 13)의 위치에 있다면 (5, 9, 11)의 위치에 가로수를 더 심으면 모든 가로수들의 간격이 같게 된다.
     * 또한, 가로수가 (2, 6, 12, 18)에 있다면 (4, 8, 10, 14, 16)에 가로수를 더 심어야 한다.
     *
     * 심어져 있는 가로수의 위치가 주어질 때, 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 구하는 프로그램을 작성하라.
     * 단, 추가되는 나무는 기존의 나무들 사이에만 심을 수 있다.
     */
    public void baekjoon2485() throws IOException {
        int n = read();
        int[] arr = new int[n];
        arr[0] = read();
        arr[1] = read();
        int gcd = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            arr[i] = read();
            gcd = gcd(arr[i] - arr[i - 1], gcd);
        }
        System.out.print(((arr[n - 1] - arr[0]) / gcd) - (n - 1));
    }

    /**
     * 정수 n(0 ≤ n ≤ 4 * 10^9)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.
     * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.
     */
    public void baekjoon4134() throws IOException {
        int n = (int) readLong();
        long arr[] = new long[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(prime(readLong())).append("\n");
        }

        System.out.print(sb);
    }

    /**
     * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
     *
     */
    public void baekjoon1929() throws IOException {
        int m = read();
        int n = read();
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (isPrime(m)) {
                sb.append(m).append("\n");
            }
            if (m < n) {
                m++;
            } else {
                break;
            }
        }
        System.out.print(sb);
    }


    // 가장 작은 소수 찾기
    private static long prime(long num) {
        boolean isPrime;
        while (true) {
            // 0과 1은 소수가 아님
            isPrime = num < 2 ? false : true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                break;
            } else {
                num++;
            }
        }
        return num;
    }

    public void baekjoon4948() throws IOException {
//        int n = read();
//        StringBuilder sb = new StringBuilder();
//        while (n != 0) {
//            sb.append(countPrime(n)).append("\n");
//            n = read();
//        }
//        System.out.print(sb);

        // false: 소수, true: 소수가 아님
        boolean arr[] = new boolean[246_913];
        for (int i = 2; i <= 246_912; i++) {
            if (arr[i]) continue;
            for (int j = i + i; j <= 246_912; j += i) {
                arr[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        int n = read();
        int start;
        int end;
        int count;
        while (n != 0) {
            start = n + 1;
            end = n * 2;
            count = 0;
            for (int i = start; i <= end; i++) {
                if (!arr[i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
            n = read();
        }
        System.out.print(sb);
    }

    private static int countPrime(int num) {
        int count = 0;
        int start = num + 1;
        for (int i = start; i <= num * 2; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    // 소수 판별
    private static boolean isPrime(int num) {
        boolean isPrime = num < 2 ? false : true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

/*
    // 소수 판별
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true; // 2는 소수
        if (num % 2 == 0) return false; // 짝수는 소수가 아님

        // 홀수만 검사 (3부터 시작, 2씩 증가)
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
*/

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
                continue;
            }
            if (n < '0' || n > '9') {
                return result * operation;
            }

            result *= 10;
            result += n - '0';
        }
    }

    private static long readLong() throws IOException {
        int n;
        long result = 0;
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
