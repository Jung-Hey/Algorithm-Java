import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        /**
         * V1 : 메모리 초과
         * 스택으로 풀려고했지만 인덱스 접근이 안되는 줄 알고 ArrayList로 풀었지만 실패
         */
        /*
        ArrayList<Character> list = new ArrayList<>();
        for(char c : str.toCharArray()) list.add(c);
        int len = str.length();
        int i;
        for (i = 0; i < len ; i++) {
            char tmp = list.get(i);
            // 폭탄과 첫 째 자리가 같으면
            if(tmp == bomb.charAt(0)){
                if(i+bomb.length()-1 < len){
                    String cps = "";
                    int j=i, k=0;
                    while (i + bomb.length()-1 < len && k++ < bomb.length()){
                        cps += list.get(j++);
                    }
                    // 비교
                    if(cps.equals(bomb)){
                        for (int l = 0; l < bomb.length(); l++) {
                            list.remove(i);// 폭탄 발견지점에서 삭제
                        }
                        len -= bomb.length();
                        i=-1;
                    }
                }
            }
        }
        // output
        if(list.isEmpty()) System.out.println("FRULA");
        else {
            for (Character c : list) System.out.print(c);
        }
        */

        /**
         * 스택 버전
         */
        int idx=0;
        int len = str.length();
        Stack<Character> stk = new Stack<>();
        for (char c : str.toCharArray()) {
            stk.push(c);
            int bomb_startAt = idx-(bomb.length()-1);
            // 스택의 사이즈가 폭발문자열 크기 이상이고 시작지점이 폭발물의 첫 문자와 같으면 검사
            if( stk.size() >= bomb.length()  && stk.get(bomb_startAt) == bomb.charAt(0) ){
                String cps = "";
                for (int j = bomb_startAt ; j <= idx; j++) {
                    cps += stk.get(j);
                }
                // 폭발물이면
                if(cps.equals(bomb)){
                    for (int j = 0; j < bomb.length(); j++) {
                        stk.remove(bomb_startAt);
                    }
                    idx -= bomb.length()-1;
                    len -= bomb.length();
                }
                else{
                    idx++;
                }
            }
            else idx++;
        }
        //out
        StringBuilder sb = new StringBuilder();
        for(Character c : stk) {
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());

    }
}