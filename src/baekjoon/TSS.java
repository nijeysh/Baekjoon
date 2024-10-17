package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSS {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
