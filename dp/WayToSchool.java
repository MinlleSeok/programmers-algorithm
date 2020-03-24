package dp;

public class WayToSchool {

    static int answer;
    static int[][] dp;

    public void findPath(int m, int n, int M, int N, int[][] puddles) {
        if (m > M || n > N) {
            return;
        }
        if (m == M && n == N) {
            answer++;
            return;
        }
        for (int i = 0; i < puddles.length; i++) {
            if (m == puddles[i][0] && n == puddles[i][1]){
                return;
            }
        }
        findPath(m + 1, n, M, N, puddles);
        findPath(m, n + 1, M, N, puddles);
    }

    public int solution(int m, int n, int[][] puddles) {
        answer = 0;
        dp = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++)
            dp[puddles[i][1]][puddles[i][0]] = -1;
        
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1)
                    continue;
                if (i - 1 > 0 && dp[i - 1][j] != -1)
                    dp[i][j] += dp[i - 1][j];
                if (j - 1 > 0 && dp[i][j - 1] != -1)
                    dp[i][j] += dp[i][j - 1];
            }
        }
        
        
        // findPath(1, 1, m, n, puddles);

        answer = dp[n][m] % 1000000007;
        
        return answer;
    }

    public static void main(String[] args) {
        WayToSchool w = new WayToSchool();
    
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int res = w.solution(m, n, puddles);

        System.out.println("res=" + res + ", assertion=" + (res == 4));

    }
}