import java.util.*;
//Comparable가 인터페이스로 정의되어 있기에 implements 사용.
// Point는 Comparable 인터페이스의 구현 클래스.
class Point implements Comparable<Point>{
    public  int x,y;
    public Point(int x,int y){
        this.x= x;
        this.y= y;
    }
    // 아래 Collections.sort를 쓰면 내부에서 내가 재정의한 compareTo 메소드를 사용해서 리스트 정렬해줌.
    @Override
    public int compareTo(Point o){
        //외우는게 맞음
        //오름차순
        if(this.x == o.x) return this.y - o.y;
        else return  this.x - o.x;
        //내림차순
        /*
        if(this.x == o.x) return  o.y- this.y;
        else return o.x- this.x ;
        */
    }
}

public class Main {
    public static void main(String[] args) {
        //Main M = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Point(x,y) );
        }
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x+" "+o.y);
    }
}


