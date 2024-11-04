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

    /**
     * 숫자를 읽어서 정수로 변환하는 로직
     */
    public int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

    /**
     * 옥구슬(baekjoon9063) 아래 참조
     */
    private static int inputInt() throws Exception{
        int temp;
        int result = 0;
        int negative = 1;
        while(true){
            temp = System.in.read();
            if(temp == '-') {
                negative = -1;
                continue;
            }else if(temp < '0' || temp  > '9'){
                return result*negative;
            }
            result *= 10;
            result += temp - '0';
        }
    }
    public static void square() throws Exception{
        int min_x = 10000;
        int max_x = -10000;
        int min_y = 10000;
        int max_y = -10000;
        int temp_x;
        int temp_y;
        int n = inputInt();
        for(int i = 0; i < n; i++){
            temp_x = inputInt();
            temp_y = inputInt();
            if(max_x < temp_x) max_x = temp_x;
            if(min_x > temp_x) min_x = temp_x;
            if(max_y < temp_y) max_y = temp_y;
            if(min_y > temp_y) min_y = temp_y;
        }
        System.out.print((max_x-min_x)*(max_y-min_y));
    }

    /**
     * 백준 2798, 블랙잭, dfs 예시코드
     *
     */
    private static int n; // 숫자의 개수
    private static int m; // m을 넘지 않으면서 m에 최대한 가까운 수
    private static int[] numbers; // 입력 받는 숫자 배열
    private static int answer; // 정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n]; // 숫자 배열 초기화.

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        dfs(0, 0, 0);

        System.out.println(answer);

    }

    private static void dfs(int index, int num, int depth) {
        if (depth == 3) { // 숫자 3개를 선택했다면..
            if (num <= m) { // 그 합이 m 이하라면
                answer = Math.max(answer, num); // 현재까지의 최적값을 갱신
            }
            return;
        }

        for (int i = index; i < n; i++) {
            dfs(i + 1, num + numbers[i], depth + 1); // i+1로 인덱스 갱신
        }
    }
}
