package baekjoon.algorithm.backtracking;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Step1 {

    /**
     * N과 M (5)
     *
     * N개의 자연수 중에서 M개를 고른 수열
     */
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static char[] result;
    public void baekjoon15654() throws Exception {
        int N = read();
        int M = read();

        result = new char[2 * M - 1];
        arr = new int[N];
        for (int i = 1; i < M; i++) {
            result[2 * i - 1] = ' ';
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        permutation(-1, M, 0);
        bw.flush();
        bw.close();
    }

    static void permutation(int curr, int M, int depth) throws Exception {
        if (depth == M) {
            bw.write(result);
            bw.newLine();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != curr) {
                result[2 * depth] = (char) (arr[i] + '0');
                permutation(i, M, depth + 1);
            }
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
