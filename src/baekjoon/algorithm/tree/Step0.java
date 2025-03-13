package baekjoon.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Step0 {
    static ArrayList<Integer>[] list;
    static Deque<Integer> queue = new ArrayDeque();
    static boolean[] visited;
    static int[] parent;
    public void baekjoon11725() throws Exception {
        int N = read();

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList();
        }


        for (int i = 0; i < N - 1; i++) {
            int u = read();
            int v = read();

            list[u].add(v);
            list[v].add(u);
        }

        // System.out.println(Arrays.toString(list));

        // 1이 최상위 노드
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);

        // System.out.println(Arrays.toString(visited));
        // System.out.println(Arrays.toString(parent));
    }

    static void dfs(int node) throws Exception {
        visited[node] = true;

        for (int next : list[node]) {
            if (visited[next]) continue;
            parent[next] = node;
            dfs(next);
        }
    }

    static int read() throws Exception {
        int c, n = 0, sign = 1;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n * sign;
    }
}
