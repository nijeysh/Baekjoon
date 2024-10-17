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

    public void baekjoon2720() throws IOException {

    }
}
