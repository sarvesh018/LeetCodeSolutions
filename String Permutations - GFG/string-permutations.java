//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void permute(char arr[], int i, ArrayList<String> list){
        if(i == arr.length-1){
            StringBuilder s = new StringBuilder();
            for(char c: arr){
                s.append(c);
            }
            list.add(s.toString());
        }
        for(int j=i; j<arr.length; j++){
            swap(arr, j, i);
            permute(arr, i+1, list);
            swap(arr, j, i);
        }
    }
    
    public ArrayList<String> permutation(String S)
    {
        //Your code 
        ArrayList<String> list = new ArrayList<>();
        permute(S.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }
	   
}
