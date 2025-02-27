package baekjoon.algorithm.graph;

import java.util.*;

public class Step0 {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int order = 1;

    /**
     * 알고리즘 수업 - 깊이 우선 탐색 1
     *
     * N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
     * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다.
     * 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
     *
     * 인접 정점은 오름차순으로 방문한다.
     */
    public void baekjoon24479() throws Exception {
        int N = read();
        int M = read();
        int R = read();

        visited = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();

            // 양방향 그래프
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    public void baekjoon24480() throws Exception {
        int N = read();
        int M = read();
        int R = read();

        visited = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();

            // 양방향 그래프
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
//            Collections.sort(graph[i], (a, b) -> b - a);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int node) {
        visited[node] = order++;

        for (int next : graph[node]) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }

    public void baekjoon24444() throws Exception {
        int N = read();
        int M = read();
        int R = read();

        visited = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    public void baekjoon24445() throws Exception {
        int N = read();
        int M = read();
        int R = read();

        visited = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int node) {
        queue.offer(node);
        visited[node] = order++;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (visited[next] == 0) {
                    visited[next] = order++;
                    queue.offer(next);
                }
            }
        }
    }

    static int count = 0;
    public void baekjoon2606() throws Exception {
        int N = read();
        int M = read();

        visited = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int u = read();
            int v = read();

            graph[u].add(v);
            graph[v].add(u);
        }

        worm(1);
        // 1번 빼고
        System.out.println(count - 1);
    }

    static void worm(int node) throws Exception {
        queue.offer(node);
        visited[node] = ++count;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (visited[next] == 0) {
                    visited[next] = ++count;
                    queue.offer(next);
                }
            }
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
