package baekjoon.numbertheory;

import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;

public class DivisorMultiplierPrime1 {

    public void baekjoon5086() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            if (a == 0 && b == 0) {
                break;
            }

            if ((double) (a % b) == 0.0) {
                sb.append("multiple");
            } else if ((double) (b % a) == 0.0) {
                sb.append("factor");
            } else {
                sb.append("neither");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public void baekjoon2501() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int k = 0;
        int count = 0;

        for (int i = 1; i <= (a / 2); i++) {
            if (a % i == 0) {
                count++;
                if (count == b) {
                    k = i;
                    break;
                }
            }
        }
        if (++count == b) {
            k = a;
        }
        System.out.print(k);
    }

    /**
     * 완전수
     */
    public void baekjoon9506() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList();
        StringBuilder sb = new StringBuilder();

        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a == -1) break;

            int sum = 0;
            StringJoiner sj = new StringJoiner(" + ");
            for (int i = 1; i <= (a / 2); i++) {
                if (a % i == 0) {
                    list.add(i);
                    sum += i;
                    sj.add(String.valueOf(i));
                }
            }

            if (sum != a) {
                sb.append(a).append(" is NOT perfect.");
            } else {
                sb.append(a).append(" = ").append(sj);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public void baekjoon1978() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int noPrime = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            if (num == 1) {
                noPrime++;
                continue;
            }
            for (int j = 2; j <= (num / 2); j++) {
                if (num % j == 0) {
                    noPrime++;
                    break;
                }
            }
        }

        sb.append(count - noPrime);
        bw.write(sb.toString());
        bw.flush();
    }

    /**
     * 소수의 합
     * 소수 중 최솟값
     * min = n, min = Math.min(min, i); 로 min 찾을 수 있다.
     */
    public void baekjoon2581() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int min = 0;
        int sum = 0;
        Boolean isPrime;

        for (int i = m; i <= n; i++) {
            isPrime = true;
            if (i == 1) continue;
            for (int j = 2; j <= (i / 2); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                sum += i;
                if (min == 0 || min > i) min = i;
            }
        }

        if (sum == 0) {
            sb.append("-1");
        } else {
            sb.append(sum).append("\n").append(min);
        }
        System.out.print(sb);
    }

    /**
     * 소인수분해
     */
    public void baekjoon11653() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int sqrt = (int) Math.sqrt(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= sqrt; i++) {
            while (num % i == 0) {
                num = num / i;
                sb.append(i).append("\n");
            }
        }
        if (num != 1) {
            sb.append(num);
        }
        System.out.print(sb);
    }
}
