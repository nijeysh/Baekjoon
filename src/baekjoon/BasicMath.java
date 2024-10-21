package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BasicMath {
    /**
     * 진법 변환
     * N: 수, B: 진법
     * 10진법으로 출력
     */
    public void baekjoon2745() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        char[] arr = str[0].toCharArray();
        int notation = Integer.parseInt(str[1]);
        long decimalNum = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[arr.length - 1 - i];
            num = num >= 65 && num <= 90 ? num - 55 : num - 48;
            decimalNum += (num * Math.pow(notation, i));
        }
        System.out.print(decimalNum);
    }

    /**
     * 진법 변환 2 (역순)
     * 1) sb.reverse();
     * 2) (char) ((N % B) + 'A' - 10) -> 10일 때 'A' , 11이면 1 + 'A' = 'B'
     * 3) Long.toString(N, B).toUpperCase();
     * 4) sb.insert(0, remain);
     */
    public void baekjoon11005() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(st.nextToken());
        int notation = Integer.parseInt(st.nextToken());

        while (num > 0) {
            if ((num % notation) >= 10) {
                sb.append((char) ((num % notation) + 55));
            } else {
                sb.append((num % notation));
            }

            num /= notation;
        }
        System.out.print(sb.reverse());
    }

    /**
     * 1달러 = 100센트
     * 쿼터(Quarter, $0.25)의 개수, 다임(Dime, $0.10)의 개수, 니켈(Nickel, $0.05)의 개수, 페니(Penny, $0.01)의 개수
     */
    public void baekjoon2720() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] money = {25, 10, 5};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int change = Integer.parseInt(br.readLine());
            for (int j = 0; j < money.length; j++) {
                sb.append(change / money[j]).append(" ");
                change = (change % money[j]);
            }

            sb.append(change).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 사각형이 늘어나는 개수
     * 2 * n
     * 점은 + 1
     * 더 이상의 입력이 없을 경우 br.close();
     */
    public void baekjoon2903() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int side = (int) (Math.pow(2, n) + 1);
        System.out.print(side * side);
    }

    /**
     * 최소 개수의 방
     *
     * long a = Integer.parseInt(br.readLine());
     * int count = 1;
     * int six = 6;
     * int cnt = 1;
     *
     * while (a > cnt) {
     *   cnt += six;
     *   six += 6;
     *   count++;
     * }
     *
     */
    public void baekjoon2292() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long count = 1;
        int i = 1;
        // 1은 가운데
        while (true) {
            long max = 6 * i;
            count = max + count;
            if (count >= n) {
                if (n == 1) {
                    i = 0;
                }
                break;
            }
            i++;
        }
        System.out.print(i + 1);
    }


    /**
     * 분수 찾기
     * 지그재그
     */
    public void baekjoon1193() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int num = 1;
        int row = 0;
        int column = 0;
        int repeat = 1;
        Boolean isContinue = true;
            // 1            // 2, 3             // 4, 5, 6               7,8,9
        // 1 -> (0,0) / 2-> (0,1) (1, 0) / 3-> (2,0) (1,1) (0, 2) / (0, 3) (1, 2) (2, 1) (3, 0) / (4, 0) ...
        while (isContinue) {
            row = 0;
            column = 0;
            // 반복횟수가 짝수일때 topdown
            for (int i = 0; i < repeat; i++) {
                if (repeat % 2 == 0) {
                    row = i;
                    column = (repeat - 1) - i;
                } else {
                    row = (repeat - 1) - i;
                    column = i;
                }

                if (num == count) {
                    isContinue = false;
                    break;
                }
                num++;
            }
            repeat++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(row + 1).append("/").append(column + 1);
        System.out.println(sb);
    }

    /**
     * A: 낮에 올라갈 수 있는 거리
     * V: 밤에 미끄러지는 거리
     * B: 총 높이
     */
    public void baekjoon2869() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 마지막날에는 미끄러지지 않으므로 총거리는 v - b만 계산하면 된다. / 하루 이동거리
        bw.write(String.valueOf((int) Math.ceil((double) (v - b) / (a - b))));
        bw.flush();
        bw.close();
    }
}
