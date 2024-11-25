package baekjoon.numbertheory;

import java.io.IOException;

public class DivisorMultiplierPrime2 {
    public void baekjoon1934() throws IOException {
        int n = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = read();
            int b = read();
            for (int j = 2; j <= Math.sqrt(Math.max(a, b)); j++) {
                while (a % j != 0 && b % j != 0) {
                    if (a % j == 0) {
                        a = a / j;
                    }
                    if (b % j == 0) {
                        b = b / j;
                    }
                }
            }
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
            }
            if (n < '0' || n > '9') {
                return result * operation;
            }

            result *= 10;
            result += n - '0';
        }
    }
}
