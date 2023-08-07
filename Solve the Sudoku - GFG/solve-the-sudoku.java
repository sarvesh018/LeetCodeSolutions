//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku.
    
    static boolean isSafe(int grid[][], int row, int col, int num){
        for(int i=0; i<9; i++){
            if(grid[row][i]==num || grid[i][col]==num){
                return false;
            }
            int x = 3*(row/3) + i/3;
            int y = 3*(col/3) + i%3;
            if(grid[x][y] == num) return false;
        }
        return true;
    }
    
    
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(grid[i][j] == 0){
                    for(int k=1; k<=9; k++){
                        if(isSafe(grid, i, j, k)){
                            grid[i][j] = k;
                            if(SolveSudoku(grid)){
                                return true;
                            }
                            else{
                                grid[i][j] = 0;
                            }
                            
                        }
                    }
                    return false;
                }
            }
        }
        return true;
        
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}