package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    }
}
