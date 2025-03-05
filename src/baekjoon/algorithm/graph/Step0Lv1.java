package baekjoon.algorithm.graph;

import java.util.*;

public class Step0Lv1 {

    /**
     * 숨바꼭질
     *
     * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
     * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
     * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
     *
     * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
     */
    public void baekjoon1697() throws Exception {
        int n = read();
        int k = read();

        System.out.println(bfs(n, k));
    }

    static int bfs(int n, int k) {
        if (n >= k) {
            return n - k;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == k) {
                return visited[x];
            }

            int[] next = {x - 1, x + 1, 2 * x};
            for (int nx : next) {
                if (nx >= 0 && nx <= 100000 && visited[nx] == -1) {
                    visited[nx] = visited[x] + 1;
                    queue.offer(nx);
                }
            }
        }

        return -1;
    }

    static int[][] visited;
    static Queue<Knight> knightQueue = new LinkedList<>();
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static StringBuilder sb = new StringBuilder();
    static class Knight {
        int x;
        int y;
        Knight(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void baekjoon7562() throws Exception {
        int N = read();

        for (int i = 0; i < N; i++) {
            // L x L
            int L = read();
            visited = new int[L][L];
            // 현재 칸
            int x1 = read();
            int y1 = read();

            // 이동하려는 칸
            int x2 = read();
            int y2 = read();

            bfs(x1, y1, x2, y2, L);
        }

        System.out.print(sb);
    }

    static void bfs(int startX, int startY, int endX, int endY, int L) throws Exception {
        for (int i = 0; i < L; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[startX][startY] = 0;
        knightQueue.clear();
        knightQueue.offer(new Knight(startX, startY));

        while (!knightQueue.isEmpty()) {
            Knight current = knightQueue.poll();
            if (current.x == endX && current.y == endY) {
                sb.append(visited[current.x][current.y]).append("\n");
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < L && nextY >= 0 && nextY < L && visited[nextX][nextY] == -1) {
                    visited[nextX][nextY] = visited[current.x][current.y] + 1;
                    knightQueue.offer(new Knight(nextX, nextY));
                }
            }
        }
    }

    /**
     * 토마토
     *
     * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
     * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
     * 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
     * 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
     *
     * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
     * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     */
    static int M;
    static int N;
    static int[][] box;
    static Queue<Tomato> tomatoQueue = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int count = 0;
    static int tomato = 0;
    static int period = 0;
    static class Tomato {
        int row;
        int col;
        int day;
        Tomato(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }
    public void baekjoon7576() throws Exception {
        M = read();
        N = read();

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = read();
                if (box[i][j] == 1) {
                    tomatoQueue.offer(new Tomato(i, j, 0));
                }
                if (box[i][j] != -1) {
                    tomato++;
                }
            }
        }

        System.out.println(ripen());
    }

    static int ripen() throws Exception {
        while (!tomatoQueue.isEmpty()) {
            Tomato current = tomatoQueue.poll();
            period = current.day;   // 가장 마지막 기간
            count++;
            for (int i = 0; i < 4; i++) {
                int nr = current.row + dr[i];
                int nc = current.col + dc[i];

                // 익지 않은 곳을 방문한다
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && box[nr][nc] == 0) {
                    // 기간 +1
                    tomatoQueue.offer(new Tomato(nr, nc, current.day + 1));
                    box[nr][nc] = 1;
                }
            }
        }
        return tomato == count ? period : -1;
    }

    /**
     * 토마토 (3차원)
     *
     * 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100
     */
    static Queue<Node> queue = new LinkedList<>();
    static TomatoMap tomatoMap = new TomatoMap();
    static int[] nx = {0, 0, -1, 1, 0, 0};
    static int[] ny = {0, 0, 0, 0, -1, 1};
    static int[] nz = {-1, 1, 0, 0, 0, 0};
    static int total = 0;
    static int ripeTomato = 0;
    static class Node {
        int x;
        int y;
        int z;
        int value;
        int period;
        Node(int x, int y, int z, int value, int period) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.value = value;
            this.period = period;
        }

        Node(int x, int y, int z, int period) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.period = period;
        }
    }

    static class TomatoMap {
        private HashMap<String, Node> map = new HashMap<>();

        private void put(int x, int y, int z, Node node) {
            map.put((x + "," + y + "," + z), node);
        }
        private Node get(int x, int y, int z) {
            return map.get((x + "," + y + "," + z));
        }
    }

//    public void baekjoon7569() throws Exception {
//        int M = read(); // 가로
//        int N = read(); // 세로
//        int H = read(); // 상자의 층 수
//
//        int end = N * H;
//        for (int i = 0; i < end; i++) {
//            int row = i % N;
//            int layer = i / N;
//            for (int j = 0; j < M; j++) {
//                Node tomato = new Node(row, j, layer, read(), 0);
//                tomatoMap.put(row, j, layer, tomato);
//
//                if (tomato.value == 1) {
//                    queue.offer(tomato);
//                }
//
//                if (tomato.value != -1) {
//                    total++;
//                }
//            }
//        }
//
//        ripen(M, N, H);
//    }

//    static void ripen(int M, int N, int H) throws Exception {
//        int period = 0;
//        while (!queue.isEmpty()) {
//            Node current = queue.poll();
//            ripeTomato++;
//
//            int x = current.x;
//            int y = current.y;
//            int z = current.z;
//
//            for (int i = 0; i < 6; i++) {
//                int nextX = x + nx[i];
//                int nextY = y + ny[i];
//                int nextZ = z + nz[i];
//
//                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && nextZ >= 0 && nextZ < H) {
//                    Node tomato = tomatoMap.get(nextX, nextY, nextZ);
//                    if (tomato.value == 0) {
//                        tomato.value = 1;
//                        tomato.period = current.period + 1;
//                        period = tomato.period;
//
//                        queue.offer(tomato);
//                    }
//                }
//            }
//        }
//
//        System.out.println(ripeTomato == total ? period : -1);
//    }

    static int[][][] boxes;
    public void baekjoon7569() throws Exception {
        int M = read(); // 가로
        int N = read(); // 세로
        int H = read(); // 상자의 층 수

        int end = N * H;
        boxes = new int[N][M][H];
        for (int i = 0; i < end; i++) {
            int row = i % N;
            int layer = i / N;
            for (int j = 0; j < M; j++) {
                boxes[row][j][layer] = read();

                if (boxes[row][j][layer] == 1) {
                    queue.offer(new Node(row, j, layer, 0));
                }

                if (boxes[row][j][layer] != -1) {
                    total++;
                }
            }
        }

//        System.out.println(Arrays.deepToString(boxes));
        ripen(M, N, H);
    }

    static void ripen(int M, int N, int H) throws Exception {
        int period = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            ripeTomato++;

            for (int i = 0; i < 6; i++) {
                int nextX = current.x + nx[i];
                int nextY = current.y + ny[i];
                int nextZ = current.z + nz[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && nextZ >= 0 && nextZ < H && boxes[nextX][nextY][nextZ] == 0) {
                    boxes[nextX][nextY][nextZ] = 1;
                    period = current.period + 1;
                    queue.offer(new Node(nextX, nextY, nextZ, period));
                }
            }
        }

        System.out.println(total == ripeTomato ? period : -1);
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
