package baekjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Step0 {

    /**
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     *
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     */
    static StringBuilder sb = new StringBuilder();
    public void baekjoon15649() throws Exception {
        int N = read(); // 1부터 N까지 자연수
        int M = read(); // 개수
        boolean[] numbers = new boolean[N + 1];
        String str = "";

        sequence(N, M, 0, numbers, str);
        System.out.print(sb);
    }

    private static void sequence(int N, int M, int depth, boolean[] numbers, String str) throws Exception {
        if (depth >= M) {
            sb.append(str).append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (numbers[i]) continue;
            numbers[i] = true;

            if (M - 1 == depth) {
                sequence(N, M, depth + 1, numbers, str + i);
            } else {
                sequence(N, M, depth + 1, numbers, str + i + " ");
            }
            numbers[i] = false;
        }
    }

    // 속도 개선 참고용
//    static char[] answer;
//    static boolean[] c;
//    static StringBuilder sb = new StringBuilder();
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] st = br.readLine().split(" ");
//        int n=Integer.parseInt(st[0]), r=Integer.parseInt(st[1]);
//
//        answer = new char[2 * r];
//        for (int i=1;i<r;i++) answer[2*i-1] = ' ';
//        answer[2*r -1] = '\n';
//        c = new boolean[n+1];
//
//        permutations(n,r,0);
//        System.out.println(sb);
//    }
//
//    public static void permutations(int n, int r, int m) {
//        if (r==m) {sb.append(answer); return;}
//
//        for (int i=1; i<=n; i++) {
//            if (!c[i]) {
//                c[i] = true;
//                answer[2*m] = (char) (i+'0');
//                permutations(n,r,m+1);
//                c[i] = false;
//            }
//        }
//    }

    /**
     *
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     * 고른 수열은 오름차순이어야 한다.
     *
     */

    static boolean numbers[];
    static char result[];
    public void baekjoon15650() throws Exception {
        int N = read();
        int M = read();

        numbers = new boolean[N + 1];
        result = new char[M * 2];
        for (int i = 1; i < M; i++) {
            result[2 * i - 1] = ' ';
        }

        // 마지막은 개행
        result[2 * M - 1] = '\n';

        sequence2(N, M, 1, 0);
        System.out.print(sb);
    }

    static void sequence2(int N, int M, int start, int depth) throws Exception {
        if (M == depth) {
            sb.append(result);
            return;
        }

        for (int i = start; i <= N; i++) {
            if (numbers[i]) {
                continue;
            }
            numbers[i] = true;
            result[2 * depth] = (char) (i + '0');
            sequence2(N, M, i, depth + 1);

            numbers[i] = false;
        }
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
