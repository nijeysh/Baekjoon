package baekjoon.algorithm.bisearch;

import java.util.Arrays;

public class Step0 {
    /**
     * 수 찾기
     */
    public void baekjoon1920() throws Exception {
        // 백준 제출완료
    }

    /**
     * 랜선 자르기
     *
     * K개의 랜선을 잘라서 모두 N개의 같은 길이의 랜선으로 만들어야 한다.
     *
     * 1 ≦ K ≦ 10,000
     * 1 ≦ N ≦ 1,000,000
     * K ≦ N
     *
     * 첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.
     */
    public void baekjoon1654() throws Exception {
        int K = read(); // 이미 가지고 있는 랜선 개수
        int N = read(); // 최종적으로 필요한 랜선 개수

        int[] arr = new int[K];
        // 이미 가지고 있는 각 랜선의 길이
        for (int i = 0; i < K; i++) {
            arr[i] = read();
        }

        Arrays.sort(arr);
        // 1. 가장 긴 랜선을 기준으로 동일하게 나눈다.
        // -> 개수를 하나씩 증가시킨다.
        // 2. sum을 기준으로 비율을 찾는다.
        // 너무 짧은 건 버려도 된다..
        for (int i = 0; i < arr.length; i++) {

        }
    }

    static int read() throws Exception {
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
