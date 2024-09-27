package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
}
