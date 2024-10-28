package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm {

    /**
     * 블랙잭
     */
    public void baekjoon2798() throws IOException {
        int n = read();
        int m = read();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = read();
        }
    }

    private static int read() throws IOException {
        int n;
        int result = 0;
        int operation = 1;

        while (true) {
            n = System.in.read();
            if (n == '-') {
                operation = -1;
                continue;
            }

            if (n < '0' || n > '9') {
                return result * operation;
            }

            result *= 10;
            result += n - '0';
        }
    }
}
