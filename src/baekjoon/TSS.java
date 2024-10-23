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

    /**
     * 하나라도 높은 점수가 있다면 ++ => continue;
     * 전부 다 점수가 낮다면
     */
    public void baekjoon1946() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최대 성적 개수
        int count = Integer.parseInt(br.readLine());
        int applicant = Integer.parseInt(br.readLine());
        String[] arr = new String[applicant];

        // 지원자 성적
        for (int i = 0; i < applicant; i++) {
            arr[i] = br.readLine();
        }

        // 제출한 성적 -> 값이 없을 경우도 고려
        // n번째 지원자의 성적
        // 자기자신과 비교하지 않는다
        for (int i = 0; i < applicant; i++) {
            String[] grade = arr[i].split(" ");
            // 가진 성적의 개수만큼
//            for (int ) {

//            }
        }
    }
}
