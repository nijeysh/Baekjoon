package baekjoon.algorithm.graph;

public class Step0Lv2 {

    private static int N;
    private static int K;
    static int limit;
    private static int count = 0;
    static int min = Integer.MAX_VALUE;
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
        N = read();
        K = read();

        int temp = N * 2;
        limit = (K / temp) + (K % temp);
        limit = Math.min(limit, (K / temp) + 1 + temp - (K % temp));
        seek(N, 0, 0);
        System.out.println(min);
    }

    static void seek(int node, int prev, int depth) throws Exception {
        if (limit == depth || node >= K) {
            int num = count;
            if (node > K) {
                num += (node - K);
            }
            if (min > num) {
                min = num;
            }
            return;
        }

        int minus = node - 1;
        int plus = node + 1;
        int multiple = node * 2;

        if (node == 0 && prev != -1) {
            count++;
            seek(plus, 1, depth + 1);
            return;
        }

        if (prev != -1) {
            count++;
            seek(plus, 1, depth + 1);
            count--;
        }

        if (prev != 1) {
            count++;
            seek(minus, -1, depth + 1);
            count--;
        }

        count++;
        seek(multiple, 2, depth + 1);
        count--;
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
