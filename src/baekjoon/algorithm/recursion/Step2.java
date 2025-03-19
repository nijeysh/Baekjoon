package baekjoon.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step2 {
    /**
     * 재귀함수가 뭔가요?
     *
     * JH 교수님이 만들 챗봇의 응답을 출력하는 프로그램을 만들어보자.
     * 재귀 횟수 N(1 ≤ N ≤ 50)이 주어진다.
     *
     */
    static StringBuilder sb = new StringBuilder();
    public void baekjoon17478() throws Exception {
        int N = read();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        chatBot(0, N, "");

        System.out.print(sb);
    }

    static void chatBot(int depth, int N, String hyphen) throws Exception {
        sb.append(hyphen).append("\"재귀함수가 뭔가요?\"").append("\n");
        if (depth >= N) {
            sb.append(hyphen).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
            sb.append(hyphen).append("라고 답변하였지.").append("\n");
            return;
        }

        sb.append(hyphen).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
        sb.append(hyphen).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
        sb.append(hyphen).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");

        chatBot(depth + 1, N, hyphen + "____");
        sb.append(hyphen).append("라고 답변하였지.").append("\n");
    }

    // 바꾸기
    static int w(int a, int b, int c) throws Exception {
        // 첫 번째 조건: a, b, c가 0 이하인 경우
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 두 번째 조건: a, b, c가 20보다 큰 경우
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 세 번째 조건: a < b < c인 경우
        if (a < b && b < c) {
            return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        // 나머지 경우
        return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    /**
     * 별 찍기 - 11
     *
     * 첫째 줄에 N이 주어진다. N은 항상 3×2k 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)
     *
     *    *
     *   * *
     *  *****
     *
     */
    public void baekjoon2448() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int size = N / 3;
        int x = N;
        int y = (size * 5) + (size - 1);

        int[][] arr = new int[x][y];

        // 5개씩
        // 사이 공백 1개
        // size를 준다. (2^k) -> 8
        // height -> N임
        // 뭔가.. y / 2 -> y의 index
        // 23, 11, 5
        star(x, y / 2, N, size);
    }

    static void star(int x, int y, int height, int size) throws Exception {
        if (height > 3) {
            int h = height / 2;
            int s = size / 2;
            // 두개로 나눠서 위에는 2개 밑에는 2개

            // x, y를 조정한다
            // 위에
            star(x, y, h, s);

            // 밑에
            int gap = (y - 1) / 2;
            star(x + h, gap, h, s);
            star(x + h, y + gap, h, s);
            return;
        }
        System.out.println("x: " + x + ", y: " + y + ", height: " + height + ", size: " + size);
    }

    static int read() throws Exception {
        int c, n = 0, sign = 1;
        if ((c = System.in.read()) == '-') sign = -1;
        else n = c & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n * sign;
    }
}
