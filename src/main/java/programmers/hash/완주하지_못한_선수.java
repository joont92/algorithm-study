package programmers.hash;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 *
 * 후보자 이름과 명수를 map 에 넣고,
 * completion 에 있을 경우 1개씩 뺴주고,
 * map 에 count 가 1인 후보를 출력한다(탈락자)
 */
public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> participantMap = Arrays.stream(participant)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        for (String c : completion) {
            if(!participantMap.containsKey(c)) {
                return c;
            }

            participantMap.put(c, participantMap.get(c) - 1);
        }

        return participantMap.keySet().stream()
                .filter(k -> participantMap.get(k) > 0)
                .findFirst().get();
    }
}
