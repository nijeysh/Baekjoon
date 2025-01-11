package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AdvancedLevel2 {
    /**
     * 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다.
     * 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
     *
     */
    public void baekjoon1037() throws Exception {
        // 개수
        int n = read();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 진짜 약수
        for (int i = 0; i < n; i++) {
            int A = read();
            min = Math.min(min, A);
            max = Math.max(max, A);
        }
        System.out.print((long) min * max);
    }

    /**
     *
     * 알고리즘 입문방 오픈 채팅방에서는 새로운 분들이 입장을 할 때마다 곰곰티콘을 사용해 인사를 한다.
     * 이를 본 문자열 킬러 임스는 채팅방의 기록을 수집해 그 중 곰곰티콘이 사용된 횟수를 구해 보기로 했다.
     *
     * ENTER는 새로운 사람이 채팅방에 입장했음을 나타낸다.
     * 그 외는 채팅을 입력한 유저의 닉네임을 나타낸다.
     * 닉네임은 숫자 또는 영문 대소문자로 구성되어 있다.
     *
     * 새로운 사람이 입장한 이후 처음 채팅을 입력하는 사람은 반드시 곰곰티콘으로 인사를 한다.
     * 그 외의 기록은 곰곰티콘을 쓰지 않은 평범한 채팅 기록이다.
     *
     * 채팅 기록 중 곰곰티콘이 사용된 횟수를 구해보자!
     */
    public void baekjoon25192() throws Exception {
        // 나중에 ascii로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                count += set.size();
                set.clear();
            } else {
                set.add(str);
            }
        }
        count += set.size();
        System.out.print(count);
    }

    /**
     * 사람들이 만난 기록이 시간 순서대로 N개 주어진다.
     * 무지개 댄스를 추지 않고 있던 사람이 무지개 댄스를 추고 있던 사람을 만나게 된다면, 만난 시점 이후로 무지개 댄스를 추게 된다.
     * 기록이 시작되기 이전 무지개 댄스를 추고 있는 사람은 총총이 뿐이라고 할 때, 마지막 기록 이후 무지개 댄스를 추는 사람이 몇 명인지 구해보자!
     *
     */
    public void baekjoon26069() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");

        for (int i = 0; i < n; i++) {
            String[] person = br.readLine().split(" ");
            if (set.contains(person[0]) || set.contains(person[1])) {
                set.add(person[0]);
                set.add(person[1]);
            }
        }
        System.out.print(set.size());
    }

    /**
     *
     * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
     *
     * 산술평균 : N개의 수들의 합을 N으로 나눈 값
     * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
     * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
     * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
     *
     * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
     *
     */
    public void baekjoon2108() throws Exception {
        // n은 홀수
        int n = read();
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, TreeSet> setMap = new HashMap<>();

        int sum = 0;
        int mode = 0;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            sum += arr[i];
            int count = countMap.getOrDefault(arr[i], 0) + 1;
            countMap.put(arr[i], count);
            mode = Math.max(count, mode);

            TreeSet countSet = setMap.getOrDefault(count, new TreeSet());
            countSet.add(arr[i]);
            setMap.put(count, countSet);
        }
        Arrays.sort(arr);

        // div 음수일때, 0일때,
        double div = (double) sum / n;
        if (setMap.get(mode).size() > 1) {
            setMap.get(mode).pollFirst();
        }
        int min = arr[0];
        int max = arr[n - 1];
        sb.append(Math.round(div)).append("\n");
        sb.append(arr[mid]).append("\n");
        sb.append(setMap.get(mode).pollFirst()).append("\n");
        sb.append(max-min);

        System.out.print(sb);
    }

    private static int read() throws Exception {
        int n;
        int operation = 1;
        int result = 0;
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
