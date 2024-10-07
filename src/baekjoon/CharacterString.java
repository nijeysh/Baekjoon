package baekjoon;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class CharacterString {
//    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void baekjoon27866() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = Integer.parseInt(br.readLine()) - 1;

        System.out.print(str.charAt(index));
    }

    public void baekjoon2743() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(str.length());
    }

    public void baekjoon9086() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String str = br.readLine();
            sb.append(str.charAt(0)).append(str.charAt(str.length() - 1));
            if (i != count - 1) sb.append("\n");
        }
        System.out.print(sb);
    }

    public void baekjoon11654() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alphabet = br.readLine();
        System.out.println(alphabet.charAt(0) + 0);
    }

    /**
     * 문자열 합
     * ADD) charAt(i) - '0'
     */
    public void baekjoon11720() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < count; i++) {
            String num = String.valueOf(str.charAt(i));
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);
    }

    /**
     * 알파벳 위치 찾기
     * char s
     * (int) 's'
     */
    public void baekjoon10809() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int index = 97 + i;
            for (int j = 0; j < str.length(); j++) {
                if (index == (int) str.charAt(j)) {
                    arr[i] = j;
                    break;
                }
            }
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(" ");
            }
        }
        System.out.print(sb);
    }

    /**
     * case1)
     * StringBuilder sb = new StringBuilder()
     * sb.append
     * System.out.println(sb)
     */
    public void baekjoon2675() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());


        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < repeat; k++) {
                    sb.append(str.charAt(j));
                }
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public void baekjoon1152() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(st.countTokens());
    }

    /**
     * 두 수의 비교
     * Math.max(A, B)
     * reverse()
     */
    public void baekjoon2908() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sbA.append(a.charAt(i));
            sbB.append(b.charAt(i));
        }

        System.out.print(Math.max(Integer.parseInt(sbA.toString()), Integer.parseInt(sbB.toString())));
//        System.out.print(sbA.compareTo(sbB) > 0 ? sbA : sbB);
    }

    public void baekjoon5622() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alphabet = br.readLine();
        int time = 0;

        for (int i = 0; i < alphabet.length(); i++) {
            int ch = alphabet.charAt(i) * 1;
            int num = ch < 'S' ? ch - 65 : ch - 66;

            if (num == 0) {
                time += 3;
            } else if (ch == 'Z') {
                time += (num / 3) + 2;
            } else {
                time += (num / 3) + 3;
            }
        }
        System.out.print(time);
    }

    /**
     *
     * 입력 받은 대로 출력하는 프로그램을 작성하시오.
     *
     * 입력이 주어진다.
     * 입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다.
     * 각 줄은 100글자를 넘지 않으며, 빈 줄은 주어지지 않는다.
     * 또, 각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.
     *
     * StringJoiner보다 StringBuilder가 더 빠르다.
     */
    public void baekjoon11718() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int count = 0;
//        Boolean isStop = false;
//        StringBuilder sb = new StringBuilder();
//        while (true) {
//            String str = br.readLine();
//            count++;
//            if (str == null || count > 100 || str.length() > 100 || str.length() == 0) {
//                break;
//            }
//            if (count != 1) {
//                sb.append("\n");
//            }
//            for (int i = 0; i < str.length(); i++) {
//                char ch = str.toUpperCase().charAt(i);
//                if (str.charAt(0) == ' ' || str.charAt(str.length() - 1) == ' ') {
//                    isStop = true;
//                    break;
//                }
//
//                if (Character.isDigit(ch) || ch == ' ' || (65 <= ch && 90 >= ch)) {
//                } else {
//                    isStop = true;
//                    break;
//                }
//            }
//            if (isStop) break;
//            sb.append(str);
//        }
//
//        System.out.print(sb);

        // 아래 코드로 해결가능
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
