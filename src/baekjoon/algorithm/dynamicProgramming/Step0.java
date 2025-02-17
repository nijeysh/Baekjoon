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
    public void baekjoon9184() throws Exception {

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
