package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public void baekjoon10807() {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.next();
        }

        int target = scanner.nextInt();

        System.out.println(Arrays.stream(arr).filter(m -> Integer.parseInt(m) == target).count());
    }

    public void baekjoon10871() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int standard = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            if (num < standard) {
                System.out.print(num + " ");
            }
        }
    }

    public void baekjoon10818() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int max = 0;
        int min = 0;

        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            if (i == 0) {
                min = num;
                max = num;
                continue;
            }
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(min).append(" ").append(max));
    }
}
