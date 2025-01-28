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
//
//        for (int i = 0; i < tree.length; i++) {
//            for (int j = 0; j < tree[i].length; j++) {
//                System.out.print(tree[i][j]);
//            }
//            System.out.println();
//        }

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
}
