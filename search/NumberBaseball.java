package search;

import java.util.HashSet;
import java.util.Stack;

class NumberBaseball {
    public static int getStrike(String chk, String num) {
        int cnt = 0;
        for (int i = 0; i < 3; i++)
            cnt += chk.charAt(i) == num.charAt(i) ? 1 : 0;
        return cnt;
    }

    public static int getBall(String chk, String num) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (chk.contains(String.valueOf(num.charAt(i))))
                cnt += chk.indexOf(num.charAt(i)) == i ? 0 : 1;
        }
        return cnt;
    }

    public int solution2(int[][] baseball) {
        int answer = 0, cnt;
        // HashSet<Integer> out = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i != j && j != k && i != k) {
                        stack.add(String.valueOf(i * 100 + j * 10 + k));
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            String chNum = stack.pop();
            cnt = 0;

            for (int i = 0; i < baseball.length && cnt < baseball.length; i++) {
                int strike = getStrike(chNum, String.valueOf(baseball[i][0]));
                int ball = getBall(chNum, String.valueOf(baseball[i][0]));

                if (strike == baseball[i][1] && ball == baseball[i][2])
                    cnt++;
            }
                if (cnt == baseball.length) answer++;
        }

        // for (int i = 123; i <= 987; i++) {
            
        //     for (int j = 0; j < baseball.length; j++) {
        //         int number = baseball[j][0];
        //         int strike = baseball[j][1];
        //         int ball = baseball[j][2];

        //         // out
        //         if (strike == 0 && ball == 0) {
        //             // out.add(number / 100);
        //             // out.add((number % 100) / 10);
        //             // out.add(number % 10);
        //             continue;
        //         }

        //         // strike
        //         if (strike > 0) {

        //         }

        //         // ball
        //         if (ball > 0) {

        //         }
        //     }
        // }
        return answer;
    }

    public int solution(int[][] baseball) {
        int result = 0;
        boolean data[] = new boolean[1000];

        for (int i = 0; i < data.length; i++) {
            String n = Integer.toString(i);
            if (n.length() < 3) { data[i] = true; }
            else if (n.charAt(0) == '0' || n.charAt(1) == '0' || n.charAt(2) == '0') { data[i] = true; }
            else if (n.charAt(0) == n.charAt(1) || n.charAt(0) == n.charAt(2) || n.charAt(1) == n.charAt(2)) { data[i] = true; }
        }

        for (int i = 0; i < baseball.length; i++) {
            int answer = baseball[i][0];
            int s = baseball[i][1];
            int b = baseball[i][2];

            for (int j = 123; j <= 987; j++) {
                if (!data[j]) {
                    int[] sbData = judge(Integer.toString(j), Integer.toString(answer));
                    if (sbData[0] != s || sbData[1] != b) { data[j] = true; }
                }
            }
        }
        
        for(int i = 0; i < data.length; i++) {
            if (!data[i]) { result++; }
        }
        return result;
    }
    
    int[] judge(String n1, String n2) {
        int s = 0;
        int b = 0;
        char[] c = n2.toCharArray();
        for (int i = 0; i < 3; i++) {
            if (n1.indexOf(c[i]) >= 0) {
                if (n1.charAt(i) == c[i]) { s++; }
                else { b++; }
            }
        }
        return new int[] {s, b};
    }
    public static void main(String[] args) {
        NumberBaseball a = new NumberBaseball();
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        int b = a.solution(baseball);
        System.out.println(b + ", assertion=" + (b == 2));
        
    }
}