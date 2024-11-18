package baekjoon.collections;

import java.io.IOException;

public class DataStructure {

    public void baekjoon10815() throws IOException {

    }

    private int read() throws IOException {
        int n;
        int result = 0;
        int operation = -1;

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
            result += n;
        }
    }
}
