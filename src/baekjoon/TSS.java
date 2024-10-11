package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSS {

    /**
     *
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

        for (int i = 0; i < arr.length; i++){

        }
    }
}
