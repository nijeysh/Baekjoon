package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class AdvancedLevel1 {
    public void baekjoon25083() {
        String str = "         ,r'\"7" + "\n"
                    + "r`-_   ,'  ,/" + "\n"
                    + " \\. \". L_r'" + "\n"
                    + "   `~\\/" + "\n"
                    + "      |" + "\n"
                    + "      |";

        System.out.print(str);
    }

    /**
     * 킹 1
     * 퀸 1
     * 룩 2
     * 비숍 2
     * 나이트 2
     * 폰 8
     */
    public void baekjoon3003() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] origin = {1, 1, 2, 2, 2, 8};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int count = Integer.parseInt(st.nextToken());
            sb.append(origin[i] - count).append(" ");
        }
        System.out.println(sb);
    }

    public void baekjoon2444() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int rhombus = (count * 2) - 1;
        int left = count - 2;
        int right = count;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rhombus; i++) {
            for (int j = 0; j < rhombus; j++) {
                if (j > left && right > j) {
                    sb.append("*");
                } else if (j < count) {
                    sb.append(" ");
                }
            }
            if (count -1 <= i) {
                left++;
                right--;
            } else {
                left--;
                right++;
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    /**
     * toCharArray 사용가능
     */
    public void baekjoon10988() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int rightIdx = str.length() - 1;
        int branch = str.length() / 2;
        Boolean isSame = true;

        for (int i = 0; i < branch; i++) {
            // 왼쪽
            char leftCh = str.charAt(i);

            // 오른쪽
            char rightCh = str.charAt(rightIdx - i);

            if (leftCh != rightCh) {
                isSame = false;
                break;
            }
        }

        System.out.print(isSame ? 1 : 0);
    }

    public void baekjoon1157() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toUpperCase().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        char maxCh = '\u0000';
        int secondMax = 0;

        for (int i = 0; i < arr.length; i++){
            int value = map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1;
            map.put(arr[i], value);

            if (max < value) {
                max = value;
                maxCh = arr[i];
            } else if (max == value) {
                secondMax = value;
            }
        }
        System.out.print((secondMax == max) ? "?" : maxCh);
    }

    public void baekjoon2941() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] croatiaAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (int i = 0; i < croatiaAlphabet.length; i++) {
            str = str.replaceAll(croatiaAlphabet[i], "A");
        }
        System.out.println(str.length());
    }

    public void baekjoon1316() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int group = 0;

        for (int i = 0; i < count; i++) {
            char[] alphabet = br.readLine().toCharArray();
            int pre = -1;
            int[] arr = new int[26];

            for (int j = 0; j < alphabet.length; j++) {
                int index = alphabet[j] - 97;
                if (arr[index] == 0) {
                    arr[index] = 1;
                } else if (pre != -1 && pre != index) {
                    group--;
                    break;
                }

                if (pre != index) {
                    pre = index;
                }
            }

            group++;
        }
        System.out.print(group);
    }

    /**
     * 20줄
     * 과목명, 학점, 등급
     * P/F의 P 과목 제외 (PASS OR FAIL)
     * 전공과목별(학점 x 과목평점) 합을 학점의 총합으로 나눈 값
     */
    public void baekjoon25206() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double subjectSum = 0.0;
        double scoreSum = 0.0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                double gradeScore = gradeScore(grade);
                subjectSum += (score * gradeScore);
                scoreSum += score;
            }

        }
        System.out.print(String.format("%.6f", subjectSum / scoreSum));
    }

    private double gradeScore(String grade) {
        double score = 0.0;
        switch (grade) {
            case "A+": score = 4.5; break;
            case "A0": score = 4.0; break;
            case "B+": score = 3.5; break;
            case "B0": score = 3.0; break;
            case "C+": score = 2.5; break;
            case "C0": score = 2.0; break;
            case "D+": score = 1.5; break;
            case "D0": score = 1.0; break;
            case "F": score = 0.0; break;
        }

        return score;
    }
}
