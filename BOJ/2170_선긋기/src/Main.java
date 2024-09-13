import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static class Line implements Comparable<Line>{
        int x;
        int y;
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Line l){
            if(this.x == l.x){
                return this.y - l.y;
            }
            else{
                return this.x - l.x;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        ArrayList<Line> list = new ArrayList<>();
        //int n = sc.nextInt();
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            int a = Integer.parseInt(str.split(" ")[0]);
            int b = Integer.parseInt(str.split(" ")[1]);
            list.add(new Line(a,b));
        }
        Collections.sort(list);
        Line firstLine = list.get(0);
        int lt = firstLine.x;
        int rt = firstLine.y;
        int len = rt-lt;
        for(int i=1; i<n; i++){
            Line line = list.get(i);
            // 기존 선에 포함되면
            if( lt <= line.x && line.y <= rt){
                continue;
            }
            // 기존 선에 걸치면
            else if(line.x < rt ){
                len += line.y - rt;
            }
            // 안겹치는 경우
            else{
                len += line.y- line.x;
            }
            lt = line.x;
            rt = line.y;
        }
        System.out.println(len);
        br.close();
    }
}