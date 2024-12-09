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

    /**
     * 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
     *
     * 짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다.
     * 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.
     *
     * 첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다.
     * 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.
     *
     */
    private static boolean notPrime[] = new boolean[1_000_001];
    private static int[] prime;
    private static int[] partitionCount;

    public void baekjoon17103() throws IOException {
        int n = read();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        /* 1,000,000 루프 */
//        for (int i = 2; i * i < notPrime.length; i++) {
//            if (!notPrime[i]) {
//                for (int j = i * i; j < notPrime.length; j += i) {
//                    notPrime[j] = true;
//                }
//            }
//        }

        for (int i = 2; i < notPrime.length; i++) {
            if (notPrime[i]) continue;
            for (int j = i + i; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }

            // 소수 개수
            if (!notPrime[i]) {
                count++;
            }
        }
        // 소수의 집합
        prime = new int[count];
        int index = 0;
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) prime[index++] = i;
        }

        partitionCount = new int[n];
        for (int i = 0; i < n; i++) {
            sb.append(countPartition(read())).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 첫 번째 줄에는 창문의 개수와 사람의 수 N(1 ≤ N ≤ 2,100,000,000)이 주어진다.
     *
     * 1번째 사람은 1의 배수인 1,2,3번 창문을 연다. (1, 1, 1)
     * 2번째 사람은 2의 배수인 2번 창문을 닫는다. (1, 0, 1)
     * 3번째 사람은 3의 배수인 3번 창문을 닫는다. (1, 0, 0)
     *
     * 단, 처음에 모든 창문은 닫혀 있다.
     */
    public void baekjoon13909() throws IOException {
        int n = read();
        int count = 0;
        // n번째 창문이 열려있는지 확인하기
        // 약수의 개수가 홀수인 경우는 오직 제곱수에서만 발생한다.
        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        System.out.println(count);
    }

    /* 이중 포인터 O(n) */
    private static int countPartition(int num) {
        int count = 0;
        int left = 0;
        int right = prime.length - 1;

        while (left <= right) {
            int sum = prime[left] + prime[right];
            if (sum == num) {
                count++;
                left++;
                right--;
            } else if (sum < num) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    private static int getPartitionCount(int n) {
        int count = 0;
        // n / 2 이상으로 넘어가면 중복 숫자 발생
        for (int i = 2; i <= n / 2; i++) {
            if (!notPrime[i] && !notPrime[n- i]) {
                count++;
            }
        }
        return count;
    }

//    private static void countPartition(int num, int index, int start, int depth) {
//        if (depth > 1) return;
//        if (start > prime.length - 2) return;
//        for (int i = start; i < prime.length; i++) {
//            if (prime[i] > (num - 2)) break;
//            if (prime[start] + prime[i] == num) partitionCount[index]++;
//            countPartition(num, index, i + 1, depth + 1);
//        }
//    }

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
