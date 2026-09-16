class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;
        // dp[i][j][0] = ways using first i points, j segments, point i not covered as an endpoint continuing
        // dp[i][j][1] = ways using first i points, j segments, ending exactly at point i (segment ends here, can extend/merge)
        long[][][] dp = new long[n + 1][k + 1][2];
        dp[1][0][0] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i][0][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                dp[i][j][1] = (dp[i-1][j][1] + dp[i-1][j-1][0] + dp[i-1][j-1][1]) % MOD;
            }
        }
        
        return (int)((dp[n][k][0] + dp[n][k][1]) % MOD);
    }
}