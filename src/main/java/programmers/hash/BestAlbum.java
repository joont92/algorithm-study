package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BestAlbum {
    public static void main(String[] args) {
    }

    public int[] solution(String[] genres, int[] plays) {
        var countMap = new HashMap<String, Integer>();
        var sortedMap = new HashMap<String, Map<Integer, Integer>>();

        for (int i = 0; i < genres.length; i++) {
            var key = genres[i];
            countMap.put(key, countMap.getOrDefault(key, 0) + plays[i]);

            var sortedMapElement = sortedMap.getOrDefault(key, new HashMap<>());
            sortedMapElement.put(i, plays[i]);
            sortedMap.put(key, sortedMapElement);
        }

        var result = new ArrayList<Integer>();
        
        countMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(m ->
                    sortedMap.get(m.getKey()).entrySet().stream()
                            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                            .limit(2)
                            .forEach(s ->
                                    result.add(s.getKey())
                            )
                );

        return result.stream().mapToInt(i -> i).toArray();
    }
}

/*
import java.util.*;

class Solution {
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

        return answer.stream().mapToInt(i -> i).toArray();
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
 */