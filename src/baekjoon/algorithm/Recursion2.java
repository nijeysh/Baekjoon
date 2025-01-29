package baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Recursion2 {

    /**
     * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
     *
     * 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
     * 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
     * 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.
     *
     */
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] tree;
    public void baekjoon1991() throws Exception {
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new char[26][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0); // root
            char left = st.nextToken().charAt(0);   // left
            char right = st.nextToken().charAt(0);  // right

            tree[parent - 'A'][0] = left;
            tree[parent - 'A'][1] = right;
        }

        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                System.out.print(tree[i][j]);
            }
            System.out.println();
        }

        // 전위, 중위, 후위
        preorder('A');
        bw.write("\n");
        inorder('A');
        bw.write("\n");
        postorder('A');

        bw.flush();
        bw.close();
    }

    // root - left - right
    private static void preorder(char node) throws Exception {
        if (node == '.') return; // 자식 노드가 없으면 종료

        // 현재 노드 방문
        bw.write(node);

        int idx = node - 'A';
        preorder(tree[idx][0]);   // 왼쪽
        preorder(tree[idx][1]);   // 오른쪽
    }

    // left - root - right
    private static void inorder(char node) throws Exception {
        if (node == '.') return;

        int idx = node - 'A';
        inorder(tree[idx][0]);
        bw.write(node);
        inorder(tree[idx][1]);
    }

    // left - right - root
    private static void postorder(char node) throws Exception {
        if (node == '.') return;

        int idx = node - 'A';
        postorder(tree[idx][0]);
        postorder(tree[idx][1]);
        bw.write(node);
    }

    /**
     * 색종이 만들기
     *
     * 여러 개의 정사각형칸들로 이루어진 정사각형 모양의 종이가 주어져 있고, 각 정사각형들은 하얀색으로 칠해져 있거나 파란색으로 칠해져 있다.
     * 주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 색종이를 만들려고 한다.
     *
     * 전체 종이의 크기가 N×N(N=2k, k는 1 이상 7 이하의 자연수) 이라면 종이를 자르는 규칙은 다음과 같다.
     * 전체 종이가 모두 같은 색으로 칠해져 있지 않으면 가로와 세로로 중간 부분을 잘라서 똑같은 크기의 네 개의 N/2 × N/2색종이로 나눈다.
     * 나누어진 종이 각각에 대해서도 앞에서와 마찬가지로 모두 같은 색으로 칠해져 있지 않으면 같은 방법으로 똑같은 크기의 네 개의 색종이로 나눈다.
     * 이와 같은 과정을 잘라진 종이가 모두 하얀색 또는 모두 파란색으로 칠해져 있거나, 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 반복한다.
     *
     * 첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다. N은 2, 4, 8, 16, 32, 64, 128 중 하나이다.
     * 색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다.
     * 하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다.
     *
     */
    static int[][] paper;
    static int blue = 0;
    static int white = 0;
    public void baekjoon2630() throws Exception {
        int N = read();
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = read();
            }
        }

        // N/2 x N/2로 나누기
        cut(0, 0, N);
        System.out.println(white);
        System.out.print(blue);
    }

    static void cut(int left, int right, int N) throws Exception {
        if (check(left, right, N)) {
            // 나눠진 부분 검사 후 같지 않으면 4등분으로 나누기
        } else {
            int size = N / 2;
            cut(left, right, size);
            cut(left + size, right, size);
            cut(left, right + size, size);
            cut(left + size, right + size, size);
        }
    }

    static boolean check(int left, int right, int size) throws Exception {
        int number = paper[left][right];
        for (int i = left; i < left + size; i++) {
            for (int j = right; j < right + size; j++) {
                if (number != paper[i][j]) {
                    return false;
                }
            }
        }
        if (number == 0) {
            white++;
        } else {
            blue++;
        }
        return true;
    }

    /**
     * Z
     *
     * 한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다.
     * 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
     *
     * N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.
     * N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
     *
     * 1 ≤ N ≤ 15
     * 0 ≤ r, c < 2N
     *
     */
//    static int[][] square;
    static int r;
    static int c;

    public void baekjoon1074() throws Exception {
        int N = (int) Math.pow(2, read());
        r = read();
        c = read();

//        square = new int[N][N];
        path(0, 0, 0, N);
//        System.out.println(Arrays.deepToString(square));
//        System.out.println(square[r][c]);
    }

    // 가장 작은 단위로 쪼개기 (2x2)
    static void path(int left, int right, int start, int N) throws Exception {
        int size = N / 2;
        if (N == 1) {
            System.out.println(start);
            return;
        }

//        if (N == 2) {
//            // 시간 줄이기
//            for (int i = left; i <= left + size; i++) {
//                for (int j = right; j <= right + size; j++) {
//                    if (r == i && c == j) {
//                        return;
//                    }
//                }
//            }
//            square[left][right] = num++;
//            square[left][right + 1] = num++;
//            square[left + 1][right] = num++;
//            square[left + 1][right + 1] = num++;
//            return;
//        }

        int volumn = size * size;
        if (r >= left && r < left + size && c >= right && c < right + size) {
            path(left, right, start, size);
        } else
        if (r >= left && r < left + size && c >= right + size && c < right + size + size) {
            path(left, right + size, start + volumn, size);
        } else
        if (r >= left + size && r < left + size + size && c >= right && c < right + size) {
            path(left + size, right, start + (volumn * 2), size);
        } else
        if (r >= left + size && r < left + size + size && c >= right + size && c < right + size + size) {
            path(left + size, right + size, start + (volumn * 3), size);
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}
