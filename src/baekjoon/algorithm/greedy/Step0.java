package baekjoon.algorithm.greedy;

import java.util.Arrays;

public class Step0 {
    /**
     * 동전 0
     *
     * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
     * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
     * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
     */
    public void baekjoon11047() throws Exception {
        int N = read();
        int K = read();

        int[] arr = new int[N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = read();
            index = i;

            if ((K / arr[i]) <= 0) {
                System.out.println("index: " + index);
                index = i - 1;
                break;
            }
        }

        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += K / arr[i];
            K = K % arr[i];
            if (K == 0) {
                break;
            }
        }

        System.out.println(sum);
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
