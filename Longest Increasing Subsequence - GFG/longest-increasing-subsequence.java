//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int lowerBound(ArrayList<Integer> list, int k){
        int low = 0, high = list.size()-1;
        int res = -1;
        while(low <= high){
            int mid = (low+high)>>>1;
            if(list.get(mid) >= k){
                high = mid-1;
                res = mid;
            }
            else{
                low = low+1;
            }
        }
        return res;
    }
    // 0 4 12 -> 2
    static int longestSubsequence(int size, int a[])
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a[0]);
        int res = 1;
        for(int i=1; i<size; i++){
            if(a[i] > list.get(list.size()-1)){
                list.add(a[i]);
                res++;
            }
            else{
                int ind = lowerBound(list, a[i]);
                list.set(ind, a[i]);
            }
        }
        return res;
    }
} 