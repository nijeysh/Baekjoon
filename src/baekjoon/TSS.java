package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    /**
     * 확인필요
     */
    public void baekjoon1946() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCount; i++) {
            int applicantCount = Integer.parseInt(br.readLine());
            int chosen = 0;
            List<int[]> applicants = new ArrayList<>();

            // 지원자 점수와 순위 입력
            for (int j = 0; j < applicantCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int rank = Integer.parseInt(st.nextToken());
                applicants.add(new int[] { score, rank });
            }

            // 점수를 기준으로 정렬
            applicants.sort(Comparator.comparingInt(a -> a[0]));

            int minRank = Integer.MAX_VALUE;
            for (int[] applicant : applicants) {
                if (applicant[1] < minRank) {
                    chosen++;
                    minRank = applicant[1]; // 현재까지 가장 낮은 순위를 업데이트
                }
            }

            sb.append(chosen).append("\n");
        }
        System.out.print(sb);
    }
}
