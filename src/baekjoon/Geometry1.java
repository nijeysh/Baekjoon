package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
}
