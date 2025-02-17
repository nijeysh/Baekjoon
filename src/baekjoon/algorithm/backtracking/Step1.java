package baekjoon.algorithm.backtracking;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Step1 {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    /**
     * N과 M (5)
     *
     * N개의 자연수 중에서 M개를 고른 수열
     */
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

    static int[] home;
    static int[] chicken;
    static int[] distance;
    static boolean[] restaurant;
    public void baekjoon15686() throws Exception {
        N = read();
        M = read();

        int homeIndex = 0;
        int chickenIndex = 0;
        home = new int[2 * N];
        chicken = new int[13];

        // 1 - 집, 2 - 치킨집
        for (int i = 0; i < N * N; i++) {
            int city = read();
            if (city == 0) {
                continue;
            }

            if (city == 1) {
                home[homeIndex++] = i;
                continue;
            }

            if (city == 2) {
                chicken[chickenIndex++] = i;
                continue;
            }
        }

        distance = new int[homeIndex];
        restaurant = new boolean[chickenIndex];

        closed(0, 0);
        System.out.print(min);
    }

    static void closed(int start, int depth) throws Exception {
        if (depth == M) {
            Arrays.fill(distance, 100);
            int diff = 0;
            // 치킨집과의 최소거리를 구함
            for (int i = 0; i < restaurant.length; i++) {
                if (!restaurant[i]) continue;

                int y1 = chicken[i] / N;
                int x1 = chicken[i] % N;

                // 집 마다 거리 차이
                // 합을 구해야함..
                for (int j = 0; j < distance.length; j++) {

                    int y2 = home[j] / N;
                    int x2 = home[j] % N;

                    int len = Math.abs(y1 - y2) + Math.abs(x1 - x2);
                    if (distance[j] > len) {
                        distance[j] = len;
                    }
                }
            }

            for (int i = 0; i < distance.length; i++) {
                diff += distance[i];
            }
            min = Math.min(min, diff);

            return;
        }

        for (int i = start; i < restaurant.length; i++) {
            restaurant[i] = true;
            closed(i + 1, depth + 1);
            restaurant[i] = false;
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
