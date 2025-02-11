package baekjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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
//    static boolean chess[];
//    static boolean left[];
//    static boolean right[];
//    static int N;
//    static int count;
//    public void baekjoon9663() throws Exception {
//        N = read();
//        int size = N * N;
//        chess = new boolean[size];
//        left = new boolean[size];
//        right = new boolean[size];
//
//        chessboard(0);
//        System.out.print(count);
//    }
//
//    static void chessboard(int depth) throws Exception {
//        if (N == depth) {
//            count++;
//            return;
//        }
//        int start = depth * N;
//        int end = start + N;
//
//        for (int i = start; i < end; i++) {
//            if (!chess[i] && !left[i] && !right[i]) {
//                NQueen(i, true);
//                chessboard(depth + 1);
//                NQueen(i, false);
//            }
//        }
//    }
//
//    static void NQueen(int k, boolean path) throws Exception {
//        int l = k % N;
//        int r = N - l;
//        int step = 0;
//        for (int i = k; i < N * N; i+=N) {
//            chess[i] = path;
//            if (step <= l) left[i - step] = path;
//            if (step < r) right[i + step] = path;
//            step++;
//        }
//    }

    // 예시) 개선 1
//    public class Main {
//        static int max;
//        static int count;
//        public static void main(String[] args) throws Exception {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int n = Integer.parseInt(br.readLine());
//            max = (1 << n) - 1;
//            backtracking(0, 0, 0);
//            System.out.println(count);
//        }
//
//        private static void backtracking(int col, int dia, int adia) {
//            if (col == max) {
//                count++;
//                return;
//            }
//            int flag = max & ~(col | dia | adia);
//            while (flag > 0) {
//                int curr = flag & (-flag);
//                flag -= curr;
//                backtracking(col | curr, (dia | curr) >> 1, (adia | curr) << 1);
//            }
//        }
//    }

    // 예시) 개선 2
//    public class Main {
//        static int totalCount; // 총 퀸 배치 방법 수
//
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//
//            totalCount = 0;
//
//            // 비트마스킹 기반 DFS 탐색
//            dfs(0, N, 0, 0, 0);
//
//            // 결과 출력
//            System.out.println(totalCount);
//        }
//
//        static void dfs(int row, int N, int cols, int d1, int d2) {
//            // 모든 퀸을 배치한 경우
//            if (row == N) {
//                totalCount++;
//                return;
//            }
//
//            // 가능한 위치 계산
//            int availablePositions = (~(cols | d1 | d2)) & ((1 << N) - 1);
//
//            while (availablePositions != 0) {
//                // 가장 오른쪽 비트를 선택
//                int position = availablePositions & -availablePositions;
//
//                // 해당 위치에 퀸 배치
//                dfs(row + 1, N, cols | position, (d1 | position) << 1, (d2 | position) >> 1);
//
//                // 상태 복원
//                availablePositions &= (availablePositions - 1);
//            }
//        }
//    }

    // 가지치기 예시
    static int N, count;
    static boolean[] col, leftDiag, rightDiag;

    public void baekjoonTest() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        leftDiag = new boolean[2 * N - 1];  // 왼쪽 대각선 (row - col)
        rightDiag = new boolean[2 * N - 1]; // 오른쪽 대각선 (row + col)


        solve(0); // N-Queen 실행

        System.out.println(count);
    }

    static void solve(int row) {
        if (row == N) {  // 모든 행에 퀸을 배치하면 해결
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (col[c] || leftDiag[row - c + N - 1] || rightDiag[row + c])
                continue;  // 가지치기: 퀸을 놓을 수 없는 경우

            col[c] = leftDiag[row - c + N - 1] = rightDiag[row + c] = true;
            solve(row + 1);
            col[c] = leftDiag[row - c + N - 1] = rightDiag[row + c] = false;  // 백트래킹
        }
    }

    /**
     * 연산자 끼워넣기
     *
     * N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다.
     * 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다.
     * 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
     *
     * 우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.
     *
     * 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다.
     * 또, 나눗셈은 정수 나눗셈으로 몫만 취한다.
     * 음수를 양수로 나눌 때는 C++14의 기준을 따른다.
     * 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다.
     *
     * 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다.
     * 둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100)
     * 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
     *
     */
    static int[] arr1;
    static int[] arr2;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public void baekjoon14888() throws Exception {
        N = read();
        arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = read();
        }

        // +, -, x, /
        arr2 = new int[4];
        for (int i = 0; i < 4; i++) {
            arr2[i] = read();
        }

        combinations(0, arr1[0], 0);
        System.out.println(max);
        System.out.print(min);
    }

    static void combinations(int index, int value, int depth) throws Exception {
        if (N - 1 == depth) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (arr2[i] > 0) {
                arr2[i] -= 1;
                combinations(index + 1, calculation(index + 1, i, value), depth + 1);
                arr2[i] += 1;
            }
        }
    }

    static int calculation(int index, int i, int value) {
        switch (i) {
            case 0:
                return value + arr1[index];
            case 1:
                return value - arr1[index];
            case 2:
                return value * arr1[index];
            default:
                return value / arr1[index];
        }
    }

    static int[][] capacity;
    static boolean[] team;
    static int size;

    static int sum_A = 0;
    static int sum_B = 0;
    public void baekjoon14889() throws Exception {
        N = read(); // N은 짝수
        size = N / 2;

        // 0, 1, 2, 3
        capacity = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                capacity[i][j] = read();
            }
        }

        team = new boolean[N];
        divide(0, size, 0);
    }

    static void divide(int start, int end, int depth) {
        if (depth == size) {
            System.out.println("team: " + Arrays.toString(team));
//            synergy();
            sum_A = 0;
            return;
        }

        // 두 팀으로 나눈다.
        for (int i = start; i < N - end; i++) {
            team[i] = true;
            divide(i + 1, end - 1, depth + 1);
            team[i] = false;
        }
    }

    static void synergy(int left, int right, int depth) throws Exception {
        if (depth == 2) {

            return;
        }

        // 0, 1, 2 -> 0,1 / 0,2 / 1,2
        for (int i = left; i < N; i++) {
            // true
            if (team[i]) {

            }
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
