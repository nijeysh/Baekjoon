package baekjoon.priority;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Step0 {
    /**
     * 널리 잘 알려진 자료구조 중 최대 힙이 있다. 최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
     *
     * 배열에 자연수 x를 넣는다.
     * 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
     * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
     */
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void baekjoon11279() throws Exception {
        int N = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int number = read();
            if (number == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
                continue;
            }
            priorityQueue.offer(number);
        }

        System.out.print(sb);
    }


    public void baekjoon1927() throws Exception {
        int N = read();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int number = read();
            if (number == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
                continue;
            }
            priorityQueue.offer(number);
        }
        System.out.print(sb);
    }

    public void baekjoon11286() throws Exception {
        int N = read();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 == abs2) {
                    return o1 - o2;
                } else {
                    return abs1 - abs2;
                }
            }
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int number = read();
            if (number == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
                continue;
            }
            priorityQueue.offer(number);
        }
        System.out.print(sb);
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
