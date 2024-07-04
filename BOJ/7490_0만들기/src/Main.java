import java.util.*;
class Main {
    static int[] pm;
    static String[] op = {"+"," ","-"};
    static StringBuilder sb;
    static ArrayList<String> list;
    static boolean isZero(String exp){
        // 연산자도 필요하기 떄문에 StringTokenizer returnDelims ==  true
        StringTokenizer st = new StringTokenizer(exp, "-|+", true);
        int sum = Integer.parseInt(st.nextToken());
        while(st.hasMoreElements()) {
            String s = st.nextToken();
            if(s.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            }else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        //System.out.println("계산결과 = " + sum);
        if(sum==0) return true;
        else{
            return false;
        }
    }
    static void dfs(int l , int n, int m){
        if(l==m){
            int pmIdx = 0;
            String express = "";
            // 식 생성
            for(int i=1; i<=n; i++){
                // 식에 숫자 추가
                express+=String.valueOf(i);
                // 식에 연산자 추가
                if(pmIdx< pm.length){
                    express+=op[pm[pmIdx++]];
                }
            }
            // 계산 후 0이면 식 넣음
           if( isZero(express.replaceAll(" ",""))) {
               list.add(express);
           }
        }
        else{
            for(int i=0; i<=2; i++){
                pm[l]=i;
                dfs(l+1,n,m);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        list = new ArrayList<>();
        int t= sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            pm = new int[n-1];
            dfs(0,n,n-1);
            Collections.sort(list);
            for(String s : list){
                sb.append(s+"\n");
            }
            list.clear();
            sb.append("\n");
        }
        System.out.println(sb);
    }
}