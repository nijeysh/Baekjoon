package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Geometry1 {
    public void baekjoon27323() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.print(a * b);
    }

    /**
     * 최단거리
     */
    public void baekjoon1085() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int minX = Math.min(x, w - x);
        int minY = Math.min(y, h - y);
        System.out.print(Math.min(minX, minY));
    }

    /**
     * 네 번재 좌표
     * 배열에 할당
     */
    public void baekjoon3009() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;
        int sumX = 0;
        int sumY = 0;

        for (int i = 0; i < 3; i++) {
            String[] arr = br.readLine().split(" ");
            int x= Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);

            sumX += x;
            sumY += y;
            minX = minX == 0 ? x : Math.min(minX, x);
            minY = minY == 0 ? y : Math.min(minY, y);
            maxX = maxX == 0 ? x : Math.max(maxX, x);
            maxY = maxY == 0 ? y : Math.max(maxY, y);
        }
        sb.append((2 * (minX + maxX)) - sumX).append(" ").append((2 * (minY + maxY)) - sumY);
        System.out.println(sb);
    }

    public void baekjoon15894() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        System.out.println(num * 4);
    }

    /**
     * 옥구슬이 나오는 모든 지점을 포함하는 가장 작은 평행한 변을 갖는 직사각형
     */
    public void baekjoon9063() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // x, y 중에 가장 큰 좌표가 있다면 그걸로 선택 (위, 아래, 왼, 오른)
        int[] square = new int[4];
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        square[0] = x;
        square[1] = x;
        square[2] = y;
        square[3] = y;

        for (int i = 0; i < count - 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            square[0] = Math.min(square[0], x);
            square[1] = Math.max(square[1], x);
            square[2] = Math.min(square[2], y);
            square[3] = Math.max(square[3], y);
        }

        System.out.print((square[1] - square[0]) * (square[3] - square[2]));
    }

    /**
     * 삼각형 외우기
     * 이 문제는 BufferedReader가 더 빠름
     */
    public void baekjoon10101() throws IOException {
        int a = read10101();
        int b = read10101();
        int c = read10101();
        StringBuilder sb = new StringBuilder();

        if (180 != (a + b + c)) {
            sb.append("Error");
        } else if (a == b && a == c) {
            sb.append("Equilateral");
        } else if (a == b || a == c || b == c) {
            sb.append("Isosceles");
        } else {
            sb.append("Scalene");
        }
        System.out.print(sb);
    }

    // 자연수
    private int read10101() throws IOException {
        int n = 0;
        int result = 0;

        while (true) {
            n = System.in.read();
            if (n < '0' || n > '9') {
                return result;
            }

            result *= 10;   // 하나를 더 입력받았으므로 기존 값은 단위가 * 10
            result += n - '0';   // ASCII 정수로 만들기 (48 ~ 57)
        }
    }

    /**
     * 삼각형과 세 변
     * Math.max 대신 큰 순서대로 정렬 후 비교하는 방법도 있다.
     */
    public void baekjoon5073() throws IOException {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int sum = 0;

        while (true) {
            int a = read5073();
            int b = read5073();
            int c = read5073();
            max = Math.max(a, Math.max(b, c));
            sum = (a + b + c) - max;

            if ((a == 0 && b == 0 && c == 0)) {
                break;
            } else if (max >= sum) {
                sb.append("Invalid");
            } else if (a == b && a == c) {
                sb.append("Equilateral");
            } else if (a == b || a == c || b == c) {
                sb.append("Isosceles");
            } else {
                sb.append("Scalene");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 자연수 조건 추가
    public static int read5073() throws IOException {
        int n = 0;
        int result = 0;

        while (true) {
            n = System.in.read();
            if (n < '0' || n > '9') {
                return result;
            }

            result *= 10;
            result += n - '0';
        }
    }

    /**
     * 세 막대
     * 삼각형의 조건: 삼각형의 나머지 두 변의 합은 가장 긴 변의 길이보다 커야한다.
     * (a, b, c가 자연수이고 c가 제일 큰 수일 때 : a + b > c)
     */
    public void baekjoon14215() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        // 가장 큰 둘레
        if (arr[2] >= (arr[0] + arr[1])) {
            arr[2] = (arr[0] + arr[1]) - 1;
        }
        System.out.print(arr[0] + arr[1] + arr[2]);
    }
}
