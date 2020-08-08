package programmers.hash;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 *
 * { totalPlayCount : [{id, playCount}, {id, playCount}...] } 의 형태로 정의함
 * totalPlayCount 와 song list 는 정렬되어 있음(TreeMap, List sort 사용)
 * > totalPlayCount 의 경우 내림차순 정렬을 위해 음수로 변환
 *
 * map 의 key, map 의 value 들을 순서대로 돌면서 2개씩 묶어주면 된다
 */
public class 베스트_앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "classic", "pop"};
        int[] plays = {500, 800, 2500};

        베스트_앨범 fn = new 베스트_앨범();
        int[] result = fn.solution(genres, plays);
        for (int value : result) {
            System.out.println(value);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> init = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            init.put(genres[i], init.getOrDefault(genres[i], 0) + plays[i]);
        }

        Map<Integer, List<Song>> totalMap = new TreeMap<>();
        for (String genre : init.keySet()) {
            Integer count = init.get(genre);
            List<Song> playList = totalMap.containsKey(count) ? totalMap.get(count) : new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if(genres[i].equals(genre)) {
                    playList.add(new Song(i, plays[i]));
                }
            }
            Collections.sort(playList);
            totalMap.put(-count, playList);
        }

        List<Integer> answer = new ArrayList<>();
        for (Integer count : totalMap.keySet()) {
            int i = 0;
            for (Song song : totalMap.get(count)) {
                answer.add(song.id);
                i++;

                if(i == 2) {
                    break;
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    class Song implements Comparable<Song> {
        int id;
        int playCount;

        public Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Song o) {
            return Integer.compare(o.playCount, playCount);
        }
    }
}
