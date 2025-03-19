import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];
        for(int i=1; i<=n; i++) nums[i]=sc.nextInt();
        int[][] board = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                //System.out.println(i+" "+(i+j));
                if(nums[j]==nums[j+i]){
                    // ex) 1231 양 끝자리 11로 같으면 23관련 팰린드롬 수를 구함
                    board[j][j+i] = board[j+1][j+i-1];
                }
                else{
                    // ex)1342 라면 134나 342중 최소 팰린드롬 수 + 1
                    board[j][j+i]= Math.min(board[j][j+i-1],board[j+1][j+i])+1;
                }
            }
        }
        System.out.println(board[1][n]);

    }
}

