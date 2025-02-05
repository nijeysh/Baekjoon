package baekjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

        sequence(N, M, 1, 0);
        System.out.print(sb);
    }

    static void sequence(int N, int M, int start, int depth) throws Exception {
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
            sequence(N, M, i, depth + 1);

            numbers[i] = false;
        }
    }

    /**
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *
     * 1부터 N까지 자연수 중에서 M개를 고른 수열
     * 같은 수를 여러 번 골라도 된다.
     *
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
     *
     */
    public void baekjoon15651() throws Exception {
        int N = read();
        int M = read();

        result = new char[2 * M];
        for (int i = 1; i < M; i++) {
            result[2 * i - 1] = ' ';
        }
        result[2 * M - 1] = '\n';

        permutation(N, M, 0);
        System.out.print(sb);
    }

    static void permutation(int N, int M, int depth) throws Exception {
        if (M == depth) {
            sb.append(result);
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[2 * depth] = (char) (i + '0');
            permutation(N, M, depth + 1);
        }
    }

    /**
     *
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *
     * 1부터 N까지 자연수 중에서 M개를 고른 수열
     * 같은 수를 여러 번 골라도 된다.
     * 고른 수열은 비내림차순이어야 한다.
     * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     *
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     */
    public void baekjoon15652() throws Exception {
        int N = read();
        int M = read();

        result = new char[2 * M];
        for (int i = 1; i < M; i++) {
            result[2 * i - 1] = ' ';
        }
        result[2 * M - 1] = '\n';

        permutation(N, M, 1, 0);
        System.out.print(sb);
    }

    static void permutation(int N, int M, int start, int depth) throws Exception {
        if (M == depth) {
            sb.append(result);
            return;
        }

        for (int i = start; i <= N; i++) {
            result[2 * depth] = (char) (i + '0');
            permutation(N, M, i, depth + 1);
        }
    }

    /**
     *
     * N-Queen
     *
     * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
     *
     * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
     *
     */
    // 규칙
//    퀸은 같은 행(row)에 있으면 안 됨
//    퀸은 같은 열(column)에 있으면 안 됨
//    퀸은 대각선에 있으면 안 됨
    static boolean[][] chess;
    static int N;
    static int count;
    public void baekjoon9663() throws Exception {
        N = read();
        chess = new boolean[N][N];

        chessboard(0, 0, 0);
        System.out.println(count);
    }

    static void chessboard(int r, int c, int depth) throws Exception {
        System.out.println("r: " + r + ", c: " + c + ", depth: " + depth);
        System.out.println(Arrays.deepToString(chess));
        if (N == depth) {
            count++;
            return;
        }

        for (int i = r; i < N; i++) {
            for (int j = c; j < N; j++) {
                if (!chess[i][j]) {
                    NQueen(i, j, true);
                    chessboard(i + 1, j + 1, depth + 1);
                    NQueen(i, j, false);
                } else {
                    chessboard(i + 1, j + 1, depth);
                }
//                if (chess[i][j]) continue;
//                    NQueen(i, j, true);
//                    chessboard(i + 1, j + 1, depth + 1);
//                    NQueen(i, j, false);
            }
        }
    }

    static void NQueen(int r, int c, boolean path) throws Exception {
        for (int i = r; i < N; i++) {
            chess[i][c] = path;
        }
        for (int i = c; i < N; i++) {
            chess[r][i] = path;
        }
        int num = 0;
        for (int i = r; i < N; i++) {
            if ((c + num) >= N) {
                break;
            }
            chess[i][c + num++] = path;
        }

        num = -1;
        if (r > 0) {
            for (int i = r; i >= 0; i--) {
                if ((c + num) < 0) {
                    break;
                }
                chess[i][c + num--] = path;
            }
        }
    }

    /*static void chessboard(int x, int y, int depth) throws Exception {
        System.out.println("x: " + x + ", y: " + y);
        System.out.println("depth: " + depth);
        if (N == depth) {
            System.out.println(Arrays.deepToString(chess));
            count++;
            return;
        }
        if (x >= N) {
            return;
        }
        if (y >= N) {
            chessboard(x + 1, 0, depth);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = y; j < N; j++) {
                if (checkNeighbors(i, j)) {
                    chess[i][j] = true;
                    chessboard(i, j + 1, depth + 1);
                } else {
                    chessboard(i, j + 1, depth);
                }

//                System.out.println("depth: " + depth);

                chess[i][j] = false;
            }
        }
    }*/

    /*static boolean checkNeighbors(int x, int y) throws Exception {
        if (x > 0) {
            if (chess[x - 1][y]) return false;
        }
        if (y > 0) {
            if (chess[x][y - 1]) return false;
        }
        if (x < N - 1) {
            if (chess[x + 1][y]) return false;
        }
        if (y < N - 1) {
            if (chess[x][y + 1]) return false;
        }
        if (x > 0 && y > 0) {
            if (chess[x - 1][y - 1]) return false;
        }
        if (x < N - 1 && y < N - 1) {
            if (chess[x + 1][y + 1]) return false;
        }
        if (x > 0 && y < N - 1) {
            if (chess[x - 1][y + 1]) return false;
        }
        if (x < N - 1 && y > 0 ) {
            if (chess[x + 1][y - 1]) return false;
        }

        return true;
    }*/

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
