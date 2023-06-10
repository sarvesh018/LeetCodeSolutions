class Solution {

    public void dfs(char[][]board, int i, int j){
        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1){
            return;
        }
        if(board[i][j] == 'X' || board[i][j]=='N'){
            return;
        }
        board[i][j] = 'N';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);

    }
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j] == 'O'){
                        dfs(board, i, j);
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'N') board[i][j]='O';
                else if(board[i][j] == 'O') board[i][j]='X';
            }
        }

    }
}
// ["X","O","X","O","X","O"],
// ["O","X","O","X","O","X"],
// ["X","O","X","O","X","O"],
// ["O","X","O","X","O","X"]]

// ["X","O","X","O","X","O"],
// ["O","X","X","X","X","X"],
// ["X","X","X","X","X","O"],
// ["O","X","O","X","O","X"]]

// ["X","O","X","O","X","O"],
// ["O","X","X","X","X","X"],
// ["X","X","X","O","X","X"],
// ["O","X","O","X","O","X"]]







