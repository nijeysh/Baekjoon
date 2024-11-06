package baekjoon.bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm {

    /**
     * 블랙잭
     */
    public void baekjoon2798() throws IOException {
        int n = read();
        int m = read();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        int max;
        int min;
        int middle;
        int sum = 0;
        // 10 20 30 40 !! 50 !! 60 70 80 90
        for (int i = 2; i < arr.length; i++) {
            max = arr[i];
            for (int j = 0; j < i - 1; j++) {
                min = arr[j];
                for (int k = j + 1; k < i; k++) {
                    middle = arr[k];
                    if (max + min + middle <= m) {
                        sum = Math.max(sum, (max + min + middle));
                    }
                }
            }
        }
        System.out.print(sum);
    }

    /**
     * 분해합
     * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
     * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
     * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
     *
     * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
     *
     * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
     */

    /**
     * 216의 분해합은 225
     * 216는 225의 생성자이다
     * 0 ~ 9
     * 1 + 9 + 8 + 198
     *
     * 모든 노드를 탐색하지 않고 최소 생성자를 구하는 방법 확인
     */
    public void baekjoon2231() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int number = Integer.parseInt(n);
        int answer = 0;
        /**
         * int i = (number - (n.length() * 9))
         * 각 자리수의 최대값은 9
         * 117 = 99 + 9 + 9
         */
        for (int i = (number - (n.length() * 9)); i <= number; i++) {
            int sum = i;
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                sum += str.charAt(j) - '0';
            }
            if (sum == number) {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }

    /*private static int number;
    private static int value = 0;
    public void baekjoon2231() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        number = Integer.parseInt(n);
        int arrays[] = new int[n.length()];

        collection(arrays, 0);

        System.out.print(value);
    }*/

    /*private static void collection(int[] arrays, int index) throws IOException {
        int sum = 0;
        int n = 0;
        if (index == arrays.length) {
            for (int i = 0; i < arrays.length; i++) {
                sum += arrays[i];
                n += Math.pow(10, arrays.length - 1 - i) * arrays[i];
            }
            sum += n;
            if (sum == number) {
                value = value == 0 ? n : Math.min(n, value);
                return;
            }
            return;
        }

        // 해당하는 인덱스는 index, depth는 9까지만
        for (int i = 0; i <= 9; i++) {
            arrays[index] = i;
            collection(arrays, index + 1);
        }
    }*/

    /*public void baekjoon19532() throws IOException {
        int a = read();
        int b = read();
        int c = read();
        int d = read();
        int e = read();
        int f = read();

        *//**
         * ax + by = c
         * -> by = c - ax -> y = (c - ax) / b
         * -> ax = c - by -> x = (c - by) / a
         *
         * dx + ey = f
         * -> ey = f - dx -> y = (f - dx) / e
         * -> dx = f - ey -> x = (f - ey) / d
         *
         * y = ((a * f) - (d * c)) / ((a * e) - (d * b));
         * x = (c - (b * y)) / a;
         *
         *//*
        StringBuilder sb = new StringBuilder();
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (((a * i) + (b * j) == c) && ((d * i) + (e * j) == f)) {
                    sb.append(i).append(" ").append(j);
                }
            }
        }
        System.out.println(sb);
    }*/

    /**
     * 크래머의 법칙
     */
    public void baekjoon19532() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = (c * e - b * f) / (a * e - b * d);
        int y = (a * f - c * d) / (a * e - b * d);

        System.out.println(x + " " + y);
    }

    /**
     * N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
     * B는 검은색이며, W는 흰색이다.
     * 8×8 크기의 체스판
     * 다시 칠해야 하는 정사각형의 최소 개수
     *
     * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
     * 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
     * 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다.
     * 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
     */

    private static int min = Integer.MAX_VALUE;
    private static int n;
    private static int m;
    private static int[][] matrix;
    public void baekjoon1018() throws IOException {
        n = read(); // 세로
        m = read(); // 가로
        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = readAlphabet();
            }
        }

        combination(0, 0);
        System.out.println("min: " + min);
    }

    private static void combination(int depthX, int depthY) {
        // W일때 B일때
        char[] color = {'W', 'B'};
        int[] count = new int[2];
        // 세로
        for (int i = depthY; i < n - 8; i++) {
            // 가로
            for (int j = depthX; j < m - 8; j++) {
                // 컬럼 번호가 홀수 / 짝수일 때
                if (j % 2 == 0) {
                    if (color[0] == matrix[i][j]) {
                        count[1]++;
                    } else {
                        count[0]++;
                    }
                } else {
                    if (color[0] == matrix[i][j]) {
                        count[0]++;
                    } else {
                        count[1]++;
                    }
                }
            }
            // 바꾸기
            char temp = color[0];
            color[0] = color[1];
            color[1] = temp;
            combination(depthX + 1, i + 1);
        }

        System.out.println("count[0] : " + count[0]);
        System.out.println("count[1] : " + count[1]);
        min = Math.min(min, Math.min(count[0], count[1]));
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

    private static int readAlphabet() throws IOException {
        int n;

        while (true) {
            n = System.in.read();
            if ((n >= 'A' && n <= 'Z') || (n >= 'a' && n <= 'z')) {
                return n;
            }
        }
    }
}
