import java.util.*;
class Solution {
    public int findMinIdx(int[] fruits){
        int min = Arrays.stream(fruits).min().getAsInt();
        int idx=-1;
        for(int i=0; i<fruits.length;i++){
            if(min==fruits[i]) idx=i;
        }

        return idx;
    }
    public boolean isUnique(int[] fruits){
        int min = Arrays.stream(fruits).min().getAsInt();
        int cnt=0;
        for(int i=0; i<fruits.length;i++){
            if(min==fruits[i]) cnt++;
        }
        return  cnt==1;
    }
    public int solution(int[][] fruit){
        int answer = 0;
        int[] ch = new int[fruit.length];
        // 교환
        for(int i=0;i< fruit.length;i++){
            if(ch[i]==1)continue;
            if(!isUnique(fruit[i]))continue;
            for(int j=i+1;j<fruit.length;j++){
                if(ch[j]==1)continue;
                if(!isUnique(fruit[j]))continue;
                int min1Idx=findMinIdx(fruit[i]);
                int min2Idx=findMinIdx(fruit[j]);
                //교환할 인덱스가 다르고 감소시키는 과일은 최소 1개 이상이어야 함.
                if(min1Idx!=min2Idx && fruit[i][min2Idx]>0 && fruit[j][min1Idx]>0){
                    if(fruit[i][min1Idx] + 1 <= fruit[i][min2Idx] - 1 && fruit[j][min2Idx] + 1 <= fruit[j][min1Idx] - 1){
                        //교환
                        fruit[i][min1Idx]++;
                        fruit[i][min2Idx]--;
                        fruit[j][min2Idx]++;
                        fruit[j][min1Idx]--;
                        ch[i]=1;
                        ch[j]=1;
                        break;
                    }

                }
            }
        }

        for(int []x: fruit)answer+= Arrays.stream(x).min().getAsInt();
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}