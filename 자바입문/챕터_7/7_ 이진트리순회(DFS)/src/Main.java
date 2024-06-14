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
    public void DFS(Node root){
        if(root == null) return;
        else{
            //스택프레임에 대해 알아야 이해할 수 있다. 그림으로 그려보면 이해가 쉬움.
            //이 원리를 알아야 DFS할때 어려움없이 배울 수 있다.
            // System.out.print(root.data+" "); 이게 여기오면 전위순회
            DFS(root.lt);
            // System.out.print(root.data+" "); 이게 여기오면 중위순회
            DFS(root.rt);
            System.out.print(root.data+" ");//후위 순회
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);

    }
}


