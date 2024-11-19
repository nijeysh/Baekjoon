package baekjoon.collections;

import java.io.IOException;
import java.util.HashSet;

public class DataStructure {

    public void baekjoon10815() throws IOException {
        int n = read();
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            set.add(read());
        }

        int m = read();
        for (int i = 0; i < m; i++) {
            if (set.contains(read())) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }
        System.out.print(sb);
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
