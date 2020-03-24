package dfs;

import java.util.*;

public class TravelPath {
    
    // static boolean[] visited;
    // static ArrayList<String> result;

    static List<String> list = new ArrayList<>();
    static String route = "";
    static boolean[] visit;

    private static void dfs(String[][] tickets, String end, int cnt) {
        route += end + ",";

        if (cnt == tickets.length) {
            list.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            String s = tickets[i][0], e = tickets[i][1];

            if (s.equals(end) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, e, cnt + 1);
                visit[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }

    // private static int findStringIndex(String target, String[][] tickets) {
    //     for (int i = 0; i < tickets.length; i++) {
    //         if (target.equals(tickets[i][0])) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // public static void pathToPath(int current, String[][] tickets) {
    //     if (visited[current]) {
    //         return;
    //     }

    //     visited[current] = true;
    //     String from = tickets[current][0];
    //     String to = tickets[current][1];
        
    //     result.add(from);
    //     int next = findStringIndex(to, tickets);
    //     if (next > -1) {
    //         pathToPath(next, tickets);
    //     } else {
    //         result.add(to);
    //     }
    // }

    public String[] solution(String[][] tickets) {
        
        for (int i = 0; i < tickets.length; i++) {
            visit = new boolean[tickets.length];
            String start = tickets[i][0], end = tickets[i][1];

            if (start.equals("ICN")) {
                route = start + ",";
                visit[i] = true;
                dfs(tickets, end, 1);
            }
        }

        Collections.sort(list);
        String[] answer = list.get(0).split(",");

        // visited = new boolean[tickets.length];
        // result = new ArrayList<>();

        // Arrays.sort(tickets, new Comparator<String[]>() {
        //     @Override
        //     public int compare(final String[] a1, final String[] a2) {
        //         final String s1 = a1[0];
        //         final String s2 = a2[0];
        //         if (s1.compareTo(s2) == 0) {
        //             return a1[1].compareTo(a2[1]);
        //         } else {
        //             return s1.compareTo(s2);
        //         }
                
        //     }
        // });
        
        // pathToPath(0, tickets);

        // String[] answer = new String[result.size()];
        // int idx = 0;
        // for (String a : result) {
        //     answer[idx++] = a;
        // }
        return answer;
    }

    public static void main(String[] args) {
        TravelPath tp = new TravelPath();

        String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
        String[] res = tp.solution(tickets);

        String[] expected = { "ICN", "JFK", "HND", "IAD" };

        boolean flag = false;
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
            if (!res[i].equals(expected[i])) {
                flag = false;
            } else {
                flag = true;
            }
        }
        System.out.println("Assertion=" + flag);

    }
}