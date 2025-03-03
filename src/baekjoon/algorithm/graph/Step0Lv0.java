package baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Step0Lv0 {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int order = 1;
    static int count = 0;

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

    /**
     * DFS와 BFS
     *
     * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
     *
     */
    static StringBuilder sb = new StringBuilder();
    static boolean visit[];
    public void baekjoon1260() throws Exception {
        int N = read(); // 정점
        int M = read(); // 간선
        int V = read(); // 시작 번호

        // 정점을 먼저 할당
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 간선
        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();

            graph[u].add(v);
            graph[v].add(u);
        }

        // 작은 것을 먼저 방문
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visit = new boolean[N + 1];
        dfs_(V);
        Arrays.fill(visit, false);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");

        bfs_(V);
        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }

    static void dfs_(int node) throws Exception {
        sb.append(node).append(" ");
        visit[node] = true;

        for (int next : graph[node]) {
            if (!visit[next]) {
                dfs_(next);
            }
        }
    }

    static void bfs_(int node) throws Exception {
        queue.offer(node);
        visit[node] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");
            for (int next : graph[current]) {
                if (!visit[next]) {
                    queue.offer(next);
                    visit[next] = true;
                }
            }
        }
    }

    /**
     * 단지번호붙이기
     *
     * 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
     * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
     * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
     * 대각선상에 집이 있는 경우는 연결된 것이 아니다.
     *
     * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
     */
    static int N;
    static int[][] square;
    static boolean[][] check;
    static ArrayList<Integer> complex = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public void baekjoon2667() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        square = new int[N][N];
        check = new boolean[N][N];

        // N x N
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                square[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (square[i][j] == 1 && !check[i][j]) {
                    count = 0;
                    dfs(i, j);
                    complex.add(count);
                }
            }
        }

        Collections.sort(complex);
        StringBuilder sb = new StringBuilder();
        sb.append(complex.size()).append("\n");
        for (int c : complex) {
            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y) throws Exception {
        check[x][y] = true;
        count++;

        //상하좌우
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (square[nx][ny] == 1 && !check[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    /**
     * 유기농 배추
     */
    static int M;
    static int K;
    static int[][] garden;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public void baekjoon1012() throws Exception {
        int T = read();

        for (int t = 0; t < T; t++) {
            M = read();
            N = read();
            K = read();

            check = new boolean[N][M];
            garden = new int[N][M];
            for (int i = 0; i < K; i++) {
                int X = read();
                int Y = read();
                garden[Y][X] = 1;
            }

            // 인접노드찾기
            int count = 0;
            for (int i = 0; i < garden.length; i++) {
                for (int j = 0; j < garden[i].length; j++) {
                    if (garden[i][j] == 1 && !check[i][j]) {
                        count++;
                        cabbage(i, j);
                    }
                }
            }
            sb.append(count).append("\n");

        }
        System.out.print(sb);
    }

    static void cabbage(int row, int col) throws Exception {
        check[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (garden[nr][nc] == 1 && !check[nr][nc]) {
                    cabbage(nr, nc);
                }
            }
        }
    }

    /**
     * 미로 탐색
     */
    static int[][] maze;
    static Queue<Point> pointQueue = new LinkedList<>();
    static int[][] path;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void baekjoon2178() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        maze = new int[N][M];
        path = new int[N][M];
        for (int i = 0; i < N; i++) {
            String cells = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = cells.charAt(j) - '0';
            }
        }

        // (0, 0) 시작
        path[0][0] = 1;
        path(0, 0);

        System.out.println(path[N - 1][M - 1]);
    }

    static void path(int x, int y) throws Exception {
        pointQueue.offer(new Point(x, y));

        while (!pointQueue.isEmpty()) {
            Point current = pointQueue.poll();

            if (current.x == (N - 1) && current.y == (M - 1)) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1 && path[nx][ny] == 0) {
                    pointQueue.offer(new Point(nx, ny));
                    path[nx][ny] = path[current.x][current.y] + 1;
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
