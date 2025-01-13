import baekjoon.AdvancedLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new AdvancedLevel2().baekjoon20920();
    }
}

//    private static int count;
//    public static void main(String[] args) throws Exception {
//
//
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder sb = new StringBuilder();
//    int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//        count = 0;
//        sb.append(isPalindrome(br.readLine())).append(" ").append(count).append("\n");
//        }
//
//        System.out.print(sb);
//    }
//
//    private static int recursion(String str, int left, int right) {
//        count++;
//        if (left >= right) return 1;
//        else if (str.charAt(left) != str.charAt(right)) return 0;
//        else return recursion(str, left + 1, right - 1);
//    }
//
//    private static int isPalindrome(String str) {
//        return recursion(str, 0, str.length() - 1);
//    }


        // 정렬 알고리즘 풀이 다시 확인
        //  new Algorithm().baekjoon2751();
        //  new Algorithm().baekjoon11650();

        /* mergesort로 구현해서 시간 줄여보기 */
        //  new Algorithm().baekjoon18870();

        // 아래 다시 확인하기
        // new Algorithm1().baekjoon24267();

        // 아래 더 효율적으로 다시 풀기
        //  new Algorithm().baekjoon1436();

        // 약수, 배수, 소수 다시 풀기

        //  집합과 맵
        //  new SetAndMap().baekjoon11478();

        // 조합론 다시 풀기 (dp기초 nCr)

        // 시간개선 (arr[8001]로)
        // new AdvancedLevel2().baekjoon2108();
