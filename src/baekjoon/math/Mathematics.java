package baekjoon.math;


public class Mathematics {
    public void baekjoon1110() throws Exception {
        int N = read();

        int curr = N;
        int count = 0;

        while (true) {
            int a = curr / 10;
            int b = curr % 10;

            curr = (b * 10) + ((a + b) % 10);
            count++;
            if (curr == N) break;
        }
        System.out.print(count);
    }

    public void baekjoon2577() throws Exception {
        int A = read();
        int B = read();
        int C = read();
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[10];
        int number = A * B * C;
        char[] characters = String.valueOf(number).toCharArray();

        for (int i = 0; i < characters.length; i++) {
            int num = characters[i] - '0';
            arr[num]++;
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}
