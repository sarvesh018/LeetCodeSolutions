//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	    // Your code here	
	    int rowS=0, rowE=n-1, colS=0, colE=m-1;
	    ArrayList<Integer> list = new ArrayList<>();
	    while(rowS<n && rowE>=0 && colS<m && colE>=0){
	        for(int i=colS; i<=colE; i++){
	            list.add(A[rowS][i]);
	        }
	        rowS++;
	        for(int i=rowS; i<=rowE; i++){
	            list.add(A[i][colE]);
	        }
	        colE--;
	        if(rowS<n && rowE>=0){
	            for(int i=colE; i>=colS; i--){
	                list.add(A[rowE][i]);
	            }
	            rowE--;
	        }
	        if(colS<m && colE>=0){
	            for(int i=rowE; i>=rowS; i--){
	                list.add(A[i][colS]);
	            }
	            colS++;
	        }
	    }
	   // System.out.println(list);
	    return list.get(k-1);
    }
}