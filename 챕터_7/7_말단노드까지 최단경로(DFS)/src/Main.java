import java.util.*;
class Node{
    int data;
    Node lt;
    Node rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}

public class Main {
    Node root;
    //최단경로는 BFS하는 것이 맞으나 DFS학습을 위해 사용
    public int DFS(Node node, int l){
        if(node.lt == null && node.rt == null)return l;
        else return Math.min(DFS(node.lt,1), DFS(node.rt,1));
    }
    public static void main(String[] args) {
        Main tree = new Main();
        Scanner kb = new Scanner(System.in);
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.print(tree.DFS(tree.root,0));
        //tree.DFS(tree.root,0);
    }
}


