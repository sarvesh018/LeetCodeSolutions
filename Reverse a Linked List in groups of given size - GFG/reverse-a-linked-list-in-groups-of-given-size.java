//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
1 2 3 4 5 7 8 9  
0 1 2 3 4 5 6 7 

*/

class Solution
{
    public static void reverse(ArrayList<Integer> list, int strt, int end){
        while(strt <= end){
            int a = list.get(strt), b = list.get(end);
            list.set(end, a);
            list.set(strt, b);
            strt++; end--;
        }
    }
    public static Node reverse(Node node, int k)
    {
        //Your code here
        Node curr = node;
        ArrayList<Integer> list = new ArrayList<>();
        while(curr != null){
            list.add(curr.data);
            curr = curr.next;
        }
        
        int n = list.size();
        int i=0;
        while((i+k) < n){
            reverse(list, i, i+k-1);
            i += k;
        }
        if(i != n){
            reverse(list, i, n-1);
        }
        
        i = 0;
        Node head = node;
        while(head != null){
            head.data = list.get(i);
            i++;
            head = head.next;
        }
        
        return node;
    }
}




