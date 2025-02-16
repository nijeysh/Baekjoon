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
    static int M;
    static int[] arr;
    static boolean[] bfs;
    public void baekjoon15654() throws Exception {
        int N = read();
        M = read();

        bfs = new boolean[N];
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        permutation(-1, 0, "");
        bw.flush();
        bw.close();
    }

    static void permutation(int curr, int depth, String str) throws Exception {
        if (depth == M) {
            bw.write(str.trim());
            bw.newLine();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!bfs[i]) {
                bfs[i] = true;
                permutation(i, depth + 1, str + " " + arr[i]);
                bfs[i] = false;
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
