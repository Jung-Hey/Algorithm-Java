import java.util.*;
class Main {
    public static double getDayPs(double hour, double minute){
        double PS = 0;
        PS += minute;
        PS += (hour*3600) / 60;
        //System.out.println(PS+" 분");
        return PS;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 달마다 날짜 , 월 세팅
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        HashMap<String,Integer> map = new HashMap<>();
        map.put("January",1);
        map.put("February",2);
        map.put("March",3);
        map.put("April",4);
        map.put("May",5);
        map.put("June",6);
        map.put("July",7);
        map.put("August",8);
        map.put("September",9);
        map.put("October",10);
        map.put("November",11);
        map.put("December",12);
        // 입력
        String m = sc.next();
        int month = map.get(m); // 달
        String d = sc.next();
        int day = Integer.parseInt(d.replace(",",""));// 일
        int year = sc.nextInt();
        String [] times = sc.next().split(":");
        // 시간, 분
        double hour = Integer.parseInt(times[0]);
        double minute = Integer.parseInt(times[1]);
        // 입력 테스트
        //System.out.println(year+" "+month+" "+day+" "+hour+" "+minite);

        // 윤년체크 후 윤년이면 2월에 하루 추가
        boolean yearCheck = year%400==0 || (year%4==0 && year%100!=0);
        if(yearCheck) days[2]++;

        // 달마다 누적날짜 누적합 배열
        int[] psum = new int[13]; // 1~ 12
        int tmp=0;
        for(int i=1; i<=12; i++){
            tmp += days[i];
            psum[i] = tmp; // 1월은 31 , 2월은 31+28 ...
        }
        double total = psum[12] * 1440;
        //System.out.println("total 일 분으로 환산 = "+ total);

        // 날짜 계산
        double now=0; // 일년 중 흐른시간을 전부 분으로 누적할 배열
        now += psum[month-1] * 1440; // 달 -> 분으로 환산
        now += (day-1) * 1440; // 일 -> 분으로 환산
        //System.out.println("달, 일자 분으로 환산 = "+now);
        // 시간 분 계산해 누적
        now += getDayPs(hour,minute);

        //output
        System.out.println(now/total*100);
    }
}