package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class 여행_경로 {
    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}
        };

        여행_경로 fn = new 여행_경로();
        Arrays.stream(fn.solution(tickets)).forEach(System.out::println);
    }

    boolean result = false;
    boolean[] check;

    public String[] solution(String[][] tickets) {
        this.check = new boolean[tickets.length];
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));

        List<String> answer = new ArrayList<>();
        dfs("ICN", tickets, answer);

        return answer.toArray(new String[answer.size()]);
    }


    public void dfs(String begin, String[][] tickets, List<String> answer) {
        if(allTrue()) {
            result = true;
        }

        answer.add(begin);

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            if(!check[i] && ticket[0].equals(begin)) {
                check[i] = true;
                dfs(ticket[1], tickets, answer);
                if(!result) {
                    check[i] = false;
                    answer.remove(answer.size() - 1);
                }
            }
        }
    }

    private boolean allTrue() {
        for (boolean ch : check) {
            if(!ch) {
                return false;
            }
        }
        return true;
    }
}
