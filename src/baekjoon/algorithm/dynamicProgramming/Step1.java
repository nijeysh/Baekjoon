package baekjoon.algorithm.dynamicProgramming;

import java.util.Arrays;

public class Step1 {

    /**
     * 1로 만들기
     *
     * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
     *
     * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
     * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
     * 3. 1을 뺀다.
     *
     * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
     *
     */
    static int N;
    static int[] arr;
    public void baekjoon1463() throws Exception {
        N = read();
        arr = new int[1000001];

        for (int i = 2; i <= N; i++) {
            // -1
            arr[i] = 1 + arr[i - 1];

            // / 2
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }

            // / 3
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
        }

        System.out.println(arr[N]);
    }

    static int read() throws Exception {
        int c, n = 0, sign = 1;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n * sign;
    }
}
