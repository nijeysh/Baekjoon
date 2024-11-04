package baekjoon.bruteforce;

import java.io.*;
import java.util.Arrays;

public class Algorithm {

    /**
     * 블랙잭
     */
    public void baekjoon2798() throws IOException {
        int n = read();
        int m = read();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        int max;
        int min;
        int middle;
        int sum = 0;
        // 10 20 30 40 !! 50 !! 60 70 80 90
        for (int i = 2; i < arr.length; i++) {
            max = arr[i];
            for (int j = 0; j < i - 1; j++) {
                min = arr[j];
                for (int k = j + 1; k < i; k++) {
                    middle = arr[k];
                    if (max + min + middle <= m) {
                        sum = Math.max(sum, (max + min + middle));
                    }
                }
            }
        }
        System.out.print(sum);
    }

    /**
     * 분해합
     * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
     * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
     * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
     *
     * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
     *
     * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
     */

    /**
     * 216의 분해합은 225
     * 216는 225의 생성자이다
     * 0 ~ 9
     * 1 + 9 + 8 + 198
     *
     * 모든 노드를 탐색하지 않고 최소 생성자를 구하는 방법 확인
     */
    public void baekjoon2231() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int number = Integer.parseInt(n);
        int answer = 0;
        /**
         * int i = (number - (n.length() * 9))
         * 각 자리수의 최대값은 9
         * 117 = 99 + 9 + 9
         */
        for (int i = (number - (n.length() * 9)); i <= number; i++) {
            int sum = i;
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                sum += str.charAt(j) - '0';
            }
            if (sum == number) {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }

    /*private static int number;
    private static int value = 0;
    public void baekjoon2231() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        number = Integer.parseInt(n);
        int arrays[] = new int[n.length()];

        collection(arrays, 0);

        System.out.print(value);
    }*/

    /*private static void collection(int[] arrays, int index) throws IOException {
        int sum = 0;
        int n = 0;
        if (index == arrays.length) {
            for (int i = 0; i < arrays.length; i++) {
                sum += arrays[i];
                n += Math.pow(10, arrays.length - 1 - i) * arrays[i];
            }
            sum += n;
            if (sum == number) {
                value = value == 0 ? n : Math.min(n, value);
                return;
            }
            return;
        }

        // 해당하는 인덱스는 index, depth는 9까지만
        for (int i = 0; i <= 9; i++) {
            arrays[index] = i;
            collection(arrays, index + 1);
        }
    }*/

    public void baekjoon19532() throws IOException {

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
