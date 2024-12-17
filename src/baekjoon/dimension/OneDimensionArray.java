package baekjoon.dimension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OneDimensionArray {
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

    public void baekjoon2562() {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int order = 0;
        for (int i = 1; i < 10; i++) {
            int num = scanner.nextInt();
            if (i == 1 || num > max) {
                max = num;
                order = i;
            }
        }

        System.out.print(max + "\n" + order);
    }

    /**
     * n : 바구니 개수
     * m : 반복 횟수
     * 결과 : 반복 횟수가 끝났을 때 바구니에 있는 번호
     */
    public void baekjoon10810() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int iteration = Integer.parseInt(st.nextToken());
        int[] arr = new int[count];

        for (int i = 0; i < iteration; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                arr[j - 1] = num;
            }
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (int ball : arr) {
            joiner.add(String.valueOf(ball));
        }
        System.out.print(joiner);
    }

    /**
     * n : 바구니 개수
     * m : 바꿀 횟수
     * 두 개의 바구니를 서로 바꿈
     *
     * memo : StringBuilder가 더 빠른듯
     */
    public void baekjoon10813() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int iteration = Integer.parseInt(st.nextToken());
        int[] arr = new int[count];

        for (int i = 0; i < iteration; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int arrA = arr[a - 1] == 0 ? a : arr[a - 1];
            int arrB = arr[b - 1] == 0 ? b : arr[b - 1];

            int temp = arrA;
            arr[a - 1] = arrB;
            arr[b - 1] = arrA;
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? i + 1 : arr[i];
            joiner.add(Integer.toString(arr[i]));
        }

        System.out.print(joiner);
    }

    /**
     *
     */
    public void baekjoon5597() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[31];
        int min = 0;
        int next = 0;

        for (int i = 0; i < 28; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()); // 1 ~ 30

            arr[number] = number;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i] == 0) {
                min = min == 0 ? i : min > i ? i : min;
                next = next == 0 ? i : next < i ? i : next;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append("\n").append(next);
        System.out.print(sb);
    }

    /**
     * 한 줄에 하나의 문자
     * br.readLine()
     *
     * 서로 다른 나머지의 개수
     */
    public void baekjoon3052() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set arr = new HashSet();
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            arr.add(number % 42);
        }
        System.out.print(arr.size());
    }

    /**
     *  바구니 역순으로 위치시키기
     */
    public void baekjoon10811() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int basket = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[basket + 1];

        for (int i = 1; i <= basket; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int diff = (end - start);
            if (diff == 0) continue;

            int midPoint =  + start + (diff / 2) + 1;
            int step = (diff % 2) == 0 ? 2 : 1;
            for (int j = midPoint; j <= end; j++) {
                int temp = arr[j];
                arr[j] = arr[j - step];
                arr[j - step] = temp;

                step += 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            if (num == 0) continue;
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    /**
     * 점수 조작.. 나쁜 세준이..
     * 최대값 <
     *
     */
    public void baekjoon1546() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        double[] arr = new double[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < count; i++) {
            int score = Integer.parseInt(st.nextToken());
            arr[i] = score;
            max = score > max ? score : max;
        }

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] / max) * 100;
        }

        System.out.println(sum / count);
    }
}
