package baekjoon.datastructure;

import java.io.*;
import java.util.*;

public class SetAndMap {

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

    public void baekjoon14425() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 106)
     * 다음 n개의 줄에는 출입 기록이 순서대로 주어지며, 각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다.
     * "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.
     *
     * 회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다. 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
     *
     * 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
     *
     * TreeSet은 자동 오름차순 정렬이다
     */
    public void baekjoon7785() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
//        TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder()); // 더 느림
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        String name = "";
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            if (st.nextToken().equals("leave")) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }
        for (String str : set) {
            sb.append(str).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져. N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수인데, 자연수가 뭔지는 알지? 모르면 물어봐도 괜찮아. 나는 언제든지 질문에 답해줄 준비가 되어있어.
     *
     * 둘째 줄부터 N개의 줄에 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력으로 들어와.
     * 포켓몬의 이름은 모두 영어로만 이루어져있고, 또, 음... 첫 글자만 대문자이고, 나머지 문자는 소문자로만 이루어져 있어.
     * 아참! 일부 포켓몬은 마지막 문자만 대문자일 수도 있어.
     * 포켓몬 이름의 최대 길이는 20, 최소 길이는 2야.
     * 그 다음 줄부터 총 M개의 줄에 내가 맞춰야하는 문제가 입력으로 들어와.
     * 문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고, 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력해야해.
     * 입력으로 들어오는 숫자는 반드시 1보다 크거나 같고, N보다 작거나 같고, 입력으로 들어오는 문자는 반드시 도감에 있는 포켓몬의 이름만 주어져. 그럼 화이팅!!!

     *
     * 첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 말해줬으면 좋겠어!!!
     * 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력하면 돼. 그럼 땡큐~
     */
    public void baekjoon1620() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 순서, 문자열.. 두개 말고 하나만으로 하는 방법
        String[] arr = new String[n];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }

        String str;
        for (int i = 0; i < m; i++) {
            // 문자와 숫자를 구별할 수 있는 방법
            str = br.readLine();
//            if (str.matches("[0-9]+")) {
            // 숫자 아니면 알파벳이기 때문에 charAt으로 첫문자만 확인해도 됨.. 속도 훨씬 빠름
            if (Character.isDigit(str.charAt(0))) {
                // 숫자면 문자열 찾기
                sb.append(arr[Integer.parseInt(str) - 1]);
            } else {
                // 문자면 번호 찾기
                sb.append(map.get(str) + 1);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    /**
     * 숫자 카드는 정수 하나가 적혀져 있는 카드이다.
     * 상근이는 숫자 카드 N개를 가지고 있다.
     * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
     *
     *
     * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
     * 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
     * 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
     *
     * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
     * 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
     * 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
     */
    public void baekjoon10816() throws IOException {
        int n = read();
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = read();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int m = read();
        for (int i = 0; i < m; i++) {
            sb.append(map.getOrDefault(read(), 0)).append(" ");
        }
        System.out.println(sb);
    }

    /**
     * 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
     *
     * 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
     * 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다.
     *  N, M은 500,000 이하의 자연수이다.
     *
     *  듣보잡의 수와 그 명단을 사전순으로 출력한다.
     *
     *  String[]에 담아서 한번에 넣은 후 정렬 -> 이전 값이 현재 값이랑 같으면 count + 1과 동시에 sb에 append
     *
     *  StringBuilder sb = new StringBuilder();
     * 	String person = people[0];
     * 	int cnt = 0;
     * 	for (int i = 1; i < N+M; i++) {
     * 	  if(people[i].equals(person)) {
     * 	    cnt++;
     * 	    sb.append(person).append("\n");
     *    }else {
     * 	    person = people[i];
     *    }*
     *  }
     *
     */
    public void baekjoon1764() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        TreeSet<String> newSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        String name = "";
        for (int i = 0; i < m; i++) {
            name = br.readLine();
            if (set.contains(name)) {
                newSet.add(name);
            }
        }
        sb.append(newSet.size()).append("\n");
        for (String nm : newSet) {
            sb.append(nm).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다.
     * 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오.
     * 두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.
     *
     * 예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.
     */

    public void baekjoon1269() throws IOException {
        int a = read();
        int b = read();
        HashSet<Integer> set = new HashSet<>();
        int num;
        for (int i = 0; i < a + b; i++) {
            num = read();
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        System.out.print(set.size());
    }

    /**
     * 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
     *
     * 부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
     */
    public void baekjoon11478() throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();
        int start = 0;
        while (start < str.length()) {
            for (int i = start + 1; i <= str.length(); i++) {
                set.add(str.substring(start, i));
            }
            start++;
        }
        System.out.print(set.size());
    }

//    public static void baekjoon11478() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        int length = str.length();
//
//        String[] suffix = new String[length];
//        for(int i = 0; i < length; i++) {
//            suffix[i] = str.substring(i);
//        }
//
//        Arrays.sort(suffix);
//        int dupl = 0;
//
//        for(int i = 1; i < length; i++) {
//            for(int j = 0; j < Math.min(suffix[i].length(), suffix[i - 1].length()); j++) {
//                if(suffix[i].charAt(j) == suffix[i - 1].charAt(j)) {
//                    dupl++;
//                } else break;
//            }
//        }
//
//        System.out.println((1 + length) * length / 2 - dupl);
//    }

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
