package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        for (int i = 0; i < n; i++) {
            ps = br.readLine();
            char ch[] = ps.toCharArray();
            sb.append(vps(ch)).append("\n");
        }
        System.out.print(sb);
    }

    private static final char leftRound = '(';
    private static final char leftSquare = '[';
    private static final char rightRound = ')';
    private static final char rightSquare = ']';

    public void baekjoon4949() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        while (!str.equals(".")) {
            sb.append(balance(str.toCharArray())).append("\n");
            str = br.readLine();
        }
        System.out.print(sb);
    }

    /**
     * 사람들은 현재 1열로 줄을 서있고, 맨 앞의 사람만 이동이 가능하다.
     * 인규는 번호표 순서대로만 통과할 수 있는 라인을 만들어 두었다.
     *
     * 이 라인과 대기열의 맨 앞 사람 사이에는 한 사람씩 1열이 들어갈 수 있는 공간이 있다.
     * 현재 대기열의 사람들은 이 공간으로 올 수 있지만 반대는 불가능하다.
     *
     */
    public void baekjoon12789() throws IOException {
        int n = read();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 1;
        // 1부터~N까지 주는건지 중간숫자부터 주는것도 포함하는 건지..
        for (int i = 0; i < n; i++) {
            queue.add(read());
        }

        // queue 검사
        while (!queue.isEmpty()) {
            if (count == queue.peek()) {
                queue.poll();
                count++;
            } else if (!stack.isEmpty() && count == stack.peek()) {
                stack.pop();
                count++;
            } else {
                stack.push(queue.poll());
            }
        }

        // stack
        while (!stack.isEmpty()) {
            if (count == stack.peek()) {
                stack.pop();
                count++;
            } else {
                break;
            }
        }

        System.out.print(stack.isEmpty() ? "Nice" : "Sad");
    }

    /**
     *
     * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
     *
     * 명령은 총 여섯 가지이다.
     *
     * push X: 정수 X를 큐에 넣는 연산이다.
     * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * size: 큐에 들어있는 정수의 개수를 출력한다.
     * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
     * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     *
     * int[]로 시간초 줄이기
     */
    private static Deque<Integer> queue = new LinkedList<>();
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public void baekjoon18258() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
            queueProgram(st.nextToken());
        }
        System.out.print(sb);
    }

    /**
     * N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
     *
     * 이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다.
     * 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
     *
     * 예를 들어 N=4인 경우를 생각해 보자.
     * 카드는 제일 위에서부터 1234 의 순서로 놓여있다.
     * 1을 버리면 234가 남는다.
     * 여기서 2를 제일 아래로 옮기면 342가 된다.
     * 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다.
     * 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
     *
     * !규칙 찾기 (2의 제곱수)
     */
    public void baekjoon2164() throws IOException {
        int n = read();
        Queue<Integer> queue = new LinkedList<>();
        int temp = n;
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        // 자리를 바꾸는게 아니라.. 그냥 맨 밑으로 가는거였다..
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.print(queue.poll());
    }

    /**
     * 비트 연산으로 구현
     *
     * 1. N이 2의 거듭제곱 수일 경우 : 마지막에 N이 남는다
     * 2. 아닐 경우(2^(m-1) < N < 2^m일 경우)
     *    N을 2배 한다. 이후 2^m - 1과 & 비트연산을 한 수가 남는다.
     *
     */
//    public static void main(String[] args) throws Exception {
//        int N = nextInt();
//        int i = 1;
//        while(i < N) i <<= 1;
//        System.out.println(i == 1 ? 1 : (N - (i >> 1)) << 1);
//    }
//
//    static int nextInt() throws Exception {
//        int n = 0;
//        int c = System.in.read();
//        do n = (n << 3) + (n << 1) + (c & 15);
//        while ((c = System.in.read()) > 47 && c < 58);
//        return n;
//    }
//    private static int solve(int N) {
//        int n = 1;
//        while (n < N) {
//            n <<= 1;
//        }
//
//        return n - ((n-N) << 1);
//    }

    /**
     * 요세푸스 순열
     *
     */
    public void baekjoon11866() throws IOException {
        int n = read();
        int k = read();

        Queue<Integer> queue = new LinkedList<>();
        String[] arr = new String[n];
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int count = 0;
        int i = 0;
        while (!queue.isEmpty()) {
            ++count;
            if (count == k) {
                arr[i++] = queue.poll().toString();
                count = 0;
            } else {
                queue.add(queue.poll());
            }
        }
        System.out.println("<" + String.join(", ", arr) + ">");
    }

    /**
     *
     * 정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
     *
     * 명령은 총 여덟 가지이다.
     *
     * 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
     * 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
     * 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
     * 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
     * 5: 덱에 들어있는 정수의 개수를 출력한다.
     * 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
     * 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
     * 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
     */
    private static Deque<Integer> deque = new LinkedList<>();
    private static StringBuilder result = new StringBuilder();
    public void baekjoon28279() throws IOException {
        int n = read();
        for (int i = 0; i < n; i++) {
            dequeProgram(read());
        }
        System.out.print(result);
    }

    /**
     * 우선, 제일 처음에는 1번 풍선을 터뜨린다.
     * 다음에는 풍선 안에 있는 종이를 꺼내어 그 종이에 적혀있는 값만큼 이동하여 다음 풍선을 터뜨린다.
     * 양수가 적혀 있을 경우에는 오른쪽으로, 음수가 적혀 있을 때는 왼쪽으로 이동한다.
     * 이동할 때에는 이미 터진 풍선은 빼고 이동한다.
     *
     * 첫째 줄에 터진 풍선의 번호를 차례로 나열한다.
     *
     */
    public void baekjoon2346() throws IOException {
        int n = read();
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] step = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
            list.add(i);
            step[i] = read();
        }

        int number;
        int count;
        int index = 0;

        while (true) {
            number = list.get(index);
            list.remove(index);

            if (list.isEmpty()) {
                sb.append(number);
                break;
            }
            sb.append(number).append(" ");

            count = step[number];

            if (count > 0) {
                index = (index + (count - 1)) % list.size();
            } else {
                index = (index + count + list.size()) % list.size();
            }
        }
        System.out.print(sb);
    }

    /**
     *
     * 첫째 줄에 queuestack을 구성하는 자료구조의 개수 N이 주어진다. (1 <= N <= 100,000)
     * 둘째 줄에 길이 N의 수열 A가 주어진다. i번 자료구조가 큐라면 Ai = 0, 스택이라면 Ai = 1이다.
     * 셋째 줄에 길이 N의 수열 B가 주어진다. Bi는 i번 자료구조에 들어 있는 원소이다. (1 <= Bi <= 1,000,000,000)
     * 넷째 줄에 삽입할 수열의 길이 M이 주어진다. (1 <= M <= 100,000)
     * 다섯째 줄에 queuestack에 삽입할 원소를 담고 있는 길이 M의 수열 C가 주어진다. (1 <= Ci <= 1,000,000,000)
     *
     */
    public void baekjoon24511() throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        int n = read();
        boolean isQueue[] = new boolean[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 큐, 스택 구분 (0은 큐, 1은 스택)
            if (read() == 0) isQueue[i] = true;
        }

        for (int i = 0; i < n; i++) {
            int k = read();
            if (isQueue[i]) queue.add(k);
        }

        int m = read();
        // 숫자가 한칸씩 밀린다
        for (int i = 0; i < m; i++) {
            queue.push(read());
            sb.append(queue.pollLast()).append(" ");
        }

        System.out.print(sb);
    }

    private static void dequeProgram(int x) throws IOException {
        switch (x) {
            case 1:
                deque.push(read());
                break;
            case 2:
                deque.add(read());
                break;
            case 3:
                result.append(deque.isEmpty() ? -1 : deque.poll()).append("\n");
                break;
            case 4:
                result.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                break;
            case 5:
                result.append(deque.size()).append("\n");
                break;
            case 6:
                result.append(deque.isEmpty() ? 1 : 0).append("\n");
                break;
            case 7:
                result.append(deque.isEmpty() ? -1 : deque.peek()).append("\n");
                break;
            case 8:
                result.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                break;
        }
    }

    private static void queueProgram(String str) throws IOException {
        switch (str) {
            case "push":
                queue.add(Integer.parseInt(st.nextToken()));
                break;
            case "pop":
                sb.append(queue.isEmpty() ? -1 : queue.pop()).append("\n");
                break;
            case "size":
                sb.append(queue.size()).append("\n");
                break;
            case "empty":
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                break;
            case "front":
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                break;
            case "back":
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                break;
        }
    }

    private static String balance(char[] ch) throws IOException {
        Stack<Character> stack = new Stack<>();

        // 짝을 맞추는 지 확인
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == leftRound) {
                stack.push(rightRound);
            } else if (ch[i] == leftSquare) {
                stack.push(rightSquare);
            } else if (ch[i] == rightRound || ch[i] == rightSquare) {
                if (stack.size() == 0) return "no";
                if (stack.pop() != ch[i]) return "no";
            }
        }
        if (stack.size() > 0) return "no";
        return "yes";
    }

    private static String vps(char[] ch) throws IOException {
        String value = "NO";
        int count = 0;
        if (ch[0] == ')') return value;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return value;
                }
            }
        }

        if (count > 0) return value;
        return value = "YES";
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
