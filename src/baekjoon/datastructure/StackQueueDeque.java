package baekjoon.datastructure;

import java.io.IOException;
import java.util.Stack;

public class StackQueueDeque {

    /**
     *
     * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
     *
     * 명령은 총 다섯 가지이다.
     *
     * 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
     * 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
     * 3: 스택에 들어있는 정수의 개수를 출력한다.
     * 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
     * 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
     *
     */
    private static Stack<Integer> stack = new Stack<>();
    public void baekjoon28278() throws IOException {
        int n = read();
        StringBuilder sb = new StringBuilder();
        int num;
        int result;
        for (int i = 0; i < n; i++) {
            num = read();
            result = program(num);
            if (num != 1) {
                sb.append(result).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static int program(int num) throws IOException {
        // 후입선출
        int result = 0;
        switch (num) {
            case 1:
                stack.push(read());
                break;
            case 2:
                result = stack.isEmpty() ? -1 : stack.pop();
                break;
            case 3:
                result = stack.size();
                break;
            case 4:
                result = stack.isEmpty() ? 1 : 0;
                break;
            case 5:
                result = stack.isEmpty() ? -1 : stack.peek();
                break;
        }
        return result;
    }

    private static int read() throws IOException {
        int n;
        int result = 0;
        int operation = 1;

        while (true) {
            n = System.in.read();

            if (n == '-') {
                operation = -1;
                continue;
            }

            if (n < '0' || n > '9') {
                return result * operation;
            }

            result *= 10;
            result += n - '0';
        }
    }
}
