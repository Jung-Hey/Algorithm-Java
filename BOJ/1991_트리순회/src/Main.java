import java.util.*;
class Main {
    static class node{
        char val;
        node lt;
        node rt;
        node(char val){
            this.val = val;
            lt=rt=null;
        }
    }
    //트리 추가
    public static void insertNode(node tmp, char root, char left, char right){
        if(tmp.val == root){
            if(left != '.') tmp.lt = new node(left);
            if(right != '.') tmp.rt = new node(right);
        }
        else{
            if(tmp.lt != null) insertNode(tmp.lt, root, left, right);
            if(tmp.rt != null) insertNode(tmp.rt, root, left, right);
        }
    }

    //트리의 루트
    static node head = new node('A');
    //전위순회
    public static void preOrder(node node) {
        if(node ==null) return;
        System.out.print(node.val);
        preOrder(node.lt);
        preOrder(node.rt);
    }
    public static void inOrder(node node) {
        if(node ==null) return;
        inOrder(node.lt);
        System.out.print(node.val);
        inOrder(node.rt);
    }
    public static void postOrder(node node) {
        if(node ==null) return;
        postOrder(node.lt);
        postOrder(node.rt);
        System.out.print(node.val);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            char root = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);
            insertNode(head, root,left,right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }
}
