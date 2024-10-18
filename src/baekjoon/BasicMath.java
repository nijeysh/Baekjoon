package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
     * 1 -> 4개 4 * (1)
     * 2 -> 16개 4 * (4)
     * 3 -> 64개 4 * (4 * 4)
     */
    public void baekjoon2903() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    }
}
