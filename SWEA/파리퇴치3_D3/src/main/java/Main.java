import java.util.*;
class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
class A {}
        String [] arr = new String[] {"1","2","3"};
        sb.append(Arrays.toString(arr));
        System.out.println(sb);
        sb.delete(0,sb.length());
        sb.append( new StringBuilder(Arrays.toString(arr)).reverse());

        System.out.println(sb);


    }
}
