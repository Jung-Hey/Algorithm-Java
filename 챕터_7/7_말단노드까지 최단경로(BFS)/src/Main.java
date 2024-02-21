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
    public int BFS(Node node){
        int level = 0;
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);
        while (!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                Node x = Q.poll();
                if(x.lt == null && x.rt==null) {
                    return level;
                }
                if(x.lt != null) Q.offer(x.lt);
                if(x.rt != null) Q.offer(x.rt);
            }
            level++;
        }


        return level;
    }
    public static void main(String[] args) {
        Main tree = new Main();
        Scanner kb = new Scanner(System.in);
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.print(tree.BFS(tree.root));
        //tree.DFS(tree.root,0);
    }
}


