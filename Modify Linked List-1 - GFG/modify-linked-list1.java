//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
        if(head==null || head.next==null) return head;
        
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = head;
        int count = 0;
        while(curr != null){
            list.add(curr.data);
            curr = curr.next;
        }
        // System.out.println(list);
        int [] arr = list.stream().mapToInt(i -> i).toArray();
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            int temp = arr[n-i-1] - arr[i];
            arr[n-i-1] = arr[i];
            arr[i] = temp;
        }
        Node node = head;
        while(node != null){
            node.data = arr[count++];
            
            node = node.next;
        }
        return head;
    }
}