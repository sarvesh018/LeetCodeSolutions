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
    static int lower_bound(ArrayList<Integer> arr, int ele){
        int low = 0, high = arr.size()-1;
        int res = -1;
        while(low <= high){
            int mid = (low+high)>>>1;
            if(arr.get(mid) >= ele){
                res = mid;
                high = mid-1;
            }
            else if(arr.get(mid) < ele){
                low = mid+1;
            }
        }
        return res;
    }
    static int longestSubsequence(int n, int arr[])
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int len = 0;
        list.add(arr[0]);
        for(int i=1; i<n; i++){
            if(list.get(list.size()-1) < arr[i]){
                list.add(arr[i]);
            }
            else{
                int ind = lower_bound(list, arr[i]);
                list.set(ind, arr[i]);
            }
        }
        return list.size();
    }
} 