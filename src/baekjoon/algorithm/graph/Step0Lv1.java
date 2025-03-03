package baekjoon.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
