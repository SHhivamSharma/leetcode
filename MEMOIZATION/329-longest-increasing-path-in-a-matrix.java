class Solution {
    int[][] dp;
    int n, m;
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    
    public boolean isValid(int x, int y){
        if(x==n || x<0 || y==m || y<0)
            return false;
        return true;
    }
    public void dfs(int x, int y, int[][] matrix){
        dp[x][y] = 1;
        int curMaxm = 0;
        for(int i=0; i<4; i++){
            if(isValid(x+dx[i], y+dy[i])){
                if(matrix[x+dx[i]][y+dy[i]] > matrix[x][y]){
                    if(dp[x+dx[i]][y+dy[i]] == 0)
                        dfs(x+dx[i], y+dy[i], matrix);
                    curMaxm = Math.max(curMaxm, dp[x+dx[i]][y+dy[i]]);
                }    
            }
        }
        dp[x][y] += curMaxm;
        return;
    }
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];
        int maxm = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j] == 0){
                    dfs(i, j, matrix);
                    maxm = Math.max(maxm, dp[i][j]);
                }
            }
        }
        return maxm;
    }
}