package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSS {

    /**
     * 네 번째 좌표 배열 활용
     */
    public void baekjoon3009() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            x[i] = Integer.parseInt(input[0]);
            y[i] = Integer.parseInt(input[1]);
        }

        int fourthX = (x[0] == x[1]) ? x[2] : (x[0] == x[2] ? x[1] : x[0]);
        int fourthY = (y[0] == y[1]) ? y[2] : (y[0] == y[2] ? y[1] : y[0]);

        System.out.println(fourthX + " " + fourthY);
    }
}
