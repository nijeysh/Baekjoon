package baekjoon.algorithm.bisearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Step0 {
    /**
     * 수 찾기
     */
    public void baekjoon1920() throws Exception {
        // 백준 제출완료
    }

    /**
     * 랜선 자르기
     *
     * K개의 랜선을 잘라서 모두 N개의 같은 길이의 랜선으로 만들어야 한다.
     *
     * 1 ≦ K ≦ 10,000
     * 1 ≦ N ≦ 1,000,000
     * K ≦ N
     *
     * 첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.
     */
    static int K;
    static int N;
    static int[] arr;
    public void baekjoon1654() throws Exception {
        K = read(); // 이미 가지고 있는 랜선 개수
        N = read(); // 최종적으로 필요한 랜선 개수

        arr = new int[K];

        long start = 1;
        long end = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            arr[i] = read();
            if (arr[i] > end) {
                end = arr[i];
            }
        }

        parametricSearch(start, end);
    }

    static void parametricSearch(long start, long end) {
        while (start < end) {
            long mid = (start + end + 1) / 2;

            if (isPossible(mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

    static boolean isPossible(long x) {
        long cur = 0;
        for (int i = 0; i < K; i++) {
            cur += arr[i] / x;
        }
        return cur >= N;
    }

    static ArrayList<Integer> twoSum = new ArrayList<>();
    public void baekjoon2295() throws Exception {
        int N = read();
        int[] arr = new int[N];

        // x + y + z = k -> k가 집합에 있는 경우
        for (int  i = 0; i < N; i++) {
            arr[i] = read();
        }

        Arrays.sort(arr);
        // 두 수의 합
        // x + y
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                twoSum.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(twoSum);

        // k - z
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int target = arr[i] - arr[j];

                // 인덱스 값 리턴
//                Collections.binarySearch(twoSum, target) >= 0
                if (binarySearch(target)) {
                    // 정렬된 리스트의 N - 1부터 하나씩 검사하기 때문에 가장 첫 번째로 나온 값이 가장 큰 값
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    static boolean binarySearch(int target) {
        int left = 0;
        int right = twoSum.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (twoSum.get(mid) == target) {
                return true;
            } else if (twoSum.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    static int read() throws Exception {
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
