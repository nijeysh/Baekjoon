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
     * 체스판
     *
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

        // 9인데 1까지 가능
        // 0,0 // 0, 1 // 0,2 부터
        // 1,1 // 1,2 // 1, 3
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                combination(i, j);
            }
        }
        System.out.println(min);
    }

    private static void combination(int depthY, int depthX) {
        // W일때 B일때
        char[] color = {'W', 'B'};
        int[] count = new int[2];
        // 세로
        for (int i = depthY; i < depthY + 8; i++) {
            // 9인데 2일경우
            // 가로
            for (int j = depthX; j < depthX + 8; j++) {
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
        }

        min = Math.min(min, Math.min(count[0], count[1]));
    }

    /**
     * 666 시리즈 만들기
     *
     * 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다.
     * 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다.
     *
     * 따라서, 숌은 첫 번째 영화의 제목은 "세상의 종말 666", 두 번째 영화의 제목은 "세상의 종말 1666"와 같이 이름을 지을 것이다.
     * 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 수) 와 같다.
     *
     * 숌이 만든 N번째 영화의 제목에 들어간 수를 출력하는 프로그램을 작성하시오.
     */
    public void baekjoon1436() throws IOException {
        // 666은 앞 혹은 뒤에
        // 자리수 생각
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 1;
        int num = 666;
        int seq = 0;

        // 세 자리수부터 시작, 네 자리수, 다섯 자리수
        // 666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662 ..., 7666
        // 10666, 11666, 12666, 13666, 14666, 15666
        // 100666, 111666, .. 106661, 106662
        // 666 앞과 뒤에 숫자가 존재할 수 있다.
        // 666앞에 6이 나오면 666 뒤의 수를 증가
        // 위와 같이 생각한 방법으로 코드를 다시 짜보기
        while (count < number) {
            num++;
            int temp = num;
            while (temp > 0) {
                int remainder = temp % 10;
                temp = temp / 10;
                if (remainder == 6) {
                    seq++;
                } else {
                    seq = 0;
                }
                if (seq == 3) break;
            }
            if (seq == 3) {
                count++;
            }
            seq = 0;
        }

        System.out.print(num);
    }

    /**
     * 설탕배달
     *
     * 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
     * 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
     *
     * 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
     * 예를 들어, 18킬로그램 설탕을 배달해야 할 때,
     * 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
     *
     * 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
     */
    public void baekjoon2839() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kilogram = Integer.parseInt(br.readLine());
        int n = kilogram;

        // 1) 5로 전부 나눈 후 3으로 나누는 방법
        // 2) 1에서 나눠지지 않으면 5를 한개씩 줄이면서 3으로 나눌 수 있는지 계산한다.
        int q5 = n / 5;
        n = n % 5;

        int q3 = n / 3;
        n = n % 3;

        while (true) {
            if (n != 0) {
                // 전부 다 3으로 나눠도 0이 되지 않을 경우 -1
                if (q5 == 0) {
                    q3 = -1;
                    break;
                }

                n = kilogram;
                q5--;
                q3 = 0;

                n = n - (q5 * 5);
                while (n >= 3) {
                    q3 = n / 3;
                    n = n % 3;
                }
            } else {
                break;
            }
        }

        System.out.print(q5 + q3);


        // 코드 줄이기
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        while(n > 0){
            // n이 전부 5로 나눠지면 끝
            if(n % 5 == 0){
                result += n / 5;
                break;
            } else {
            // n을 3으로 한번씩 나눈다
                n -= 3;
                result++;
            }

            // 3으로 뺀 n이 0보다 작으면 (0으로 떨어지지 않았을 때) 5와 3으로 나눌 수 없는 값이므로 -1을 리턴한다.
            if(n < 0){
                result = -1;
            }
        }
        System.out.print(result);
*/
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
