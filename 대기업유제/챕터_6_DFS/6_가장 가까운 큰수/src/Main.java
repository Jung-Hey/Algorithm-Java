import java.util.*;
class Solution {
    boolean flag;
    static int[] ch;
    static int m, target, answer;
    ArrayList<Integer> nums;
    void dfs(int l, int num){
        if(flag) return;
        if(l==m){
            System.out.println(num);
            if(num>target){
                flag=true;
                answer=num;
            }
        }
        else{
            for(int i=0;i<m;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    dfs(l+1, num*10 + nums.get(i));
                    ch[i]=0;
                }
            }
        }
    }

    public int solution(int n){
        answer = -1;
        flag=false;
        nums = new ArrayList<>();
        int tmp = target = n;
        while (tmp > 0){
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }
        Collections.sort(nums);
        m = nums.size();
        ch=new int[m];
        dfs(0,0);


        if(flag == false) return -1;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
//        System.out.println(T.solution(123));
//        System.out.println(T.solution(321));
//        System.out.println(T.solution(20573));
//        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
//        System.out.println(T.solution(9999989));
    }
}