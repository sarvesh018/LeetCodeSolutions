//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
                if(n==0 ) return res;

        for(int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int remainingSum = k - arr[i];

            List<List<Integer>> threeSumSolutions = threeSum(arr, i + 1, remainingSum);

            for (List<Integer> solution : threeSumSolutions) {
                ArrayList<Integer> quadruple = new ArrayList<>();
                quadruple.add(arr[i]);
                quadruple.addAll(solution);
                res.add(quadruple);
            }
        }
        return res;
    }

    private List<List<Integer>> threeSum(int[] arr, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = start; i < arr.length - 2; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            int remainingSum = target - arr[i];

            List<List<Integer>> twoSumSolutions = twoSum(arr, i + 1, remainingSum);

            for (List<Integer> solution : twoSumSolutions) {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(arr[i]);
                triple.addAll(solution);
                res.add(triple);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] arr, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                res.add(pair);
                while (left < right && arr[left] == arr[left + 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right - 1]) {
                    right--;
                }

                left++;
                right--;
            }
        }
        return res;
    }
}


