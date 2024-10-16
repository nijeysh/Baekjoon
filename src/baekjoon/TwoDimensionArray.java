package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoDimensionArray {

    /**
     * N * M 행렬
     */
    public void baekjoon2738() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] matrix = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(matrix[0]);
        int m = Integer.parseInt(matrix[1]);

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr1[i][j] = Integer.parseInt(arr[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr2[i][j] = Integer.parseInt(arr[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr1[i][j] + arr2[i][j]);
                sb.append(j == m - 1 ? "" : " ");
            }
            sb.append(i == n - 1 ? "" : "\n");
        }

        System.out.print(sb);
    }

    public void baekjoon2566() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                int num = Integer.parseInt(arr[j]);
                if (max <= num) {
                    max = num;
                    sb.setLength(0);
                    sb.append(max).append("\n");
                    sb.append(i + 1).append(" ").append(j + 1);
                }
            }
        }
        System.out.print(sb);
    }

    public void baekjoon10798() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] words = new char[5][15];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            char[] arr = br.readLine().toCharArray();
            if (maxLen < arr.length) {
                maxLen = arr.length;
            }
            for (int j = 0; j < arr.length; j++) {
                words[i][j] = arr[j];
            }
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < words.length; j++) {
                char ch = words[j][i];
                if (ch != '\u0000') {
                    sb.append(ch);
                }
            }
        }
        System.out.print(sb);
    }

    /**
     *  100 x 100
     *  차지하는 공간을 1로 놓기
     */
    public void baekjoon2563() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] square = new int[100][100];
        int occupancy = 0;
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            // 1로 채우기
            for (int j = row; j < row + 10; j++) {
                for (int k = column; k < column + 10; k++) {
                    if (square[j][k] == 1) continue;
                    square[j][k] = 1;
                    occupancy++;
                }
            }
        }

        System.out.print(occupancy);
    }
}
