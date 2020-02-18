package dp;

import java.util.Arrays;

class Triangle {

    static int max = 0;

    public static void solve(int idx, int j, int got, int[][] triangle) {

        if((idx + 1) == triangle.length) {
            max = max < got ? got : max;
            return;
        }

        int left = triangle[idx + 1][j];
        int right = triangle[idx + 1][j + 1];
        if (left > right) {
            solve(idx + 1, j, got + left, triangle);
        } else if (left == right) {
            solve(idx + 1, j, got + left, triangle);
            solve(idx + 1, j + 1, got + right, triangle);
        } else {
            solve(idx + 1, j + 1, got + right, triangle);
        }
    }

    public int solution2(int[][] triangle) {
        int answer = 0;

        for (int i = 0; i < triangle[0].length; i++) {
            int got = triangle[0][i];
            solve(0, i, got, triangle);
        }

        answer = max;
        
        return answer;
    }

    public int solution3(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        // dynamic
        for (int i = 2; i < triangle.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        // Max
        int max = 0;
        for (int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[dp.length - 1][i]);

        return max;
    }

    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
    public static void main(String[] args) {
        Triangle t = new Triangle();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int res = t.solution(triangle);
        System.out.println("res=" + res + ", assertion=" + ((res == 30)));
    }
}