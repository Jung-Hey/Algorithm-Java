import java.util.*;
public class Main {
        public int[] solution(String [] genres, int [] plays){
            ArrayList<Integer> answer = new ArrayList<>();
            //장르와 장르의 재생 수
            HashMap<String,Integer> total = new HashMap<>();
            //각 장르와 각 장르의 해당하는 곡번호,곡 조회수
            HashMap<String,HashMap<Integer,Integer>> all_gen = new HashMap<>();
            for(int i=0;i<genres.length;i++){
                total.put(genres[i], total.getOrDefault(genres[i],0)+plays[i]);
                //핵심코드 : 장르의 상세 조회수 put
                HashMap<Integer, Integer> map = all_gen.getOrDefault(genres[i], new HashMap<>());
                map.put(i, plays[i]);
                all_gen.put(genres[i],map);
            }
            //핵심코드 : total 전체조회수(value)대로 내림차순 정렬
            ArrayList<String> total_Keys = new ArrayList<>(total.keySet());
            Collections.sort(total_Keys, (v1, v2) -> (total.get(v2)-total.get(v1)));
            //핵심코드 : 장르의 포함된 곡들의 조회수별 내림차순 정렬 및 answer에 add
            for(String key:total_Keys){
                HashMap<Integer,Integer> map = all_gen.get(key);
                ArrayList<Integer> detail_Keys = new ArrayList<>(map.keySet());
                Collections.sort(detail_Keys, (v1,v2)->map.get(v2)-map.get(v1));
                answer.add(detail_Keys.get(0));
                if(detail_Keys.size()>1) answer.add(detail_Keys.get(1));
            }
            //배열로 리턴
            return answer.stream().mapToInt(i -> i).toArray();
        }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner kb = new Scanner(System.in);
        String [] genres = { "classic", "pop", "classic", "classic", "pop"};
        int [] plays= {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(M.solution(genres,plays)));
    }
}

