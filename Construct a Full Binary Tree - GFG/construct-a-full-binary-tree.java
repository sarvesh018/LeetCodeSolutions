//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        ArrayDeque<Node> dq = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        
        Node root = new Node(pre[0]);
        dq.addLast(root);
        
        while(!dq.isEmpty()){
            int count = dq.size();
            for(int i=0;i<count;i++){
                Node cur = dq.removeFirst();
                find(pre,preM,cur,dq,visited);
            }
        }
        
        return root;
    }
    
    public void find(int[] pre, int[] preM, Node cur, ArrayDeque<Node> dq, HashSet<Integer> visited){
        int i = -1, j = -1;
        int val = cur.data;
        
        for(int a=0;a<pre.length;a++){
            if(pre[a]==val){
                i=a;
                break;
                
            }
        }
        
        for(int a=0;a<preM.length;a++){
            if(preM[a]==val){
                j=a;
                break;
            }
        }
        
        if(i==pre.length-1||j==preM.length-1){
            visited.add(val);
            return;
        }
        
        if(visited.contains(preM[j+1])){
            visited.add(val);
            return;
        }
        
        else{
            Node left = new Node(pre[i+1]);
            Node right = new Node(preM[j+1]);
            cur.left = left;
            cur.right = right;
            dq.addLast(left);
            dq.addLast(right);
            visited.add(val);
        }
        
    }
    
}