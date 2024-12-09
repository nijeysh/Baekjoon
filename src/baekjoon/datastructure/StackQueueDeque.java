package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    /**
     * 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
     *
     * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
     * 이후 K개의 줄에 정수가 1개씩 주어진다.
     * 정수는 0에서 1,000,000 사이의 값을 가지며, 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다
     *
     * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
     * 재민이가 최종적으로 적어 낸 수의 합을 출력한다. 최종적으로 적어낸 수의 합은 231-1보다 작거나 같은 정수이다.
     *
     */
    public void baekjoon10773() throws IOException {
        int k = read();
        int num;
        long result = 0;
        for (int i = 0; i < k; i++) {
            num = read();
            if (num == 0) {
                int pop = stack.pop();
                result -= pop;
            } else {
                stack.push(num);
                result += num;
            }
        }

        System.out.println(result);
    }

    /**
     * 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
     * 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
     *
     * 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
     * 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
     * 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
     * 예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
     *
     * 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
     *
     * 입력은 T개의 테스트 데이터로 주어진다.
     * 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
     * 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
     *
     */
    public void baekjoon9012() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String ps;
        // ( -> 40 , ) -> 41
        // ( 이게 먼저 나와야함. 0이 안됐는데 41이 나오면 탈락
        for (int i = 0; i < n; i++) {
            ps = br.readLine();
            char ch[] = ps.toCharArray();
            sb.append(vps(ch));
        }
    }

    private static boolean vps(char[] ch) throws IOException {
        boolean result = true;
        int sumLeft = 0;
        int sumRight = 0;
        int n;
        for (int i = 0; i < ch.length; i++) {

        }

        return result;
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
