package programmers.dfsbfs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 *
 * 전달받은 tickets 를 기반으로 dfs 탐색하면 된다
 * 첫번째로 찾은 항공권으로 갔다가 다음 항공권이 끊길수도 있기 때문에, check=false 로 모든 경우의 수를 다 돌아줘야 한다
 * 정답을 찾았을 때 더 이상 경우의 수를 탐색하지 않게 하기 위해 global flag를 설정한다
 */
public class 여행_경로 {
    public static void main(String[] args) {
        String[][] tickets = {
//                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
                {"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}
        };

        여행_경로 fn = new 여행_경로();
        Arrays.stream(fn.solution(tickets)).forEach(System.out::println);
    }

    String[] result;
    boolean[] check;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));

        check = new boolean[tickets.length];
        String[] transport = new String[tickets.length + 1];

        dfs("ICN", 0, tickets, transport);

        return result;
    }

    public void dfs(String airport, int depth, String[][] tickets, String[] transport) {
        transport[depth] = airport;
        if(depth == tickets.length - 1) {
            result = transport;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(check[i]) {
                continue;
            }

            if(airport.equals(tickets[i][0])) {
                check[i] = true;
                dfs(tickets[i][1], depth + 1, tickets, transport);
                // 결과를 찾았으면 더 이상 경우의 수를 체크하지 않아야 함
                if(result != null) {
                    break;
                }
                check[i] = false;
            }
        }
    }
//    boolean result = false;
//    boolean[] check;
//
//    public String[] solution(String[][] tickets) {
//        this.check = new boolean[tickets.length];
//        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));
//
//        List<String> answer = new ArrayList<>();
//        dfs("ICN", tickets, answer);
//
//        return answer.toArray(new String[answer.size()]);
//    }
//
//
//    public void dfs(String begin, String[][] tickets, List<String> answer) {
//        if(allTrue()) {
//            result = true;
//        }
//
//        answer.add(begin);
//
//        for (int i = 0; i < tickets.length; i++) {
//            String[] ticket = tickets[i];
//
//            if(!check[i] && ticket[0].equals(begin)) {
//                check[i] = true;
//                dfs(ticket[1], tickets, answer);
//                if(!result) {
//                    check[i] = false;
//                    answer.remove(answer.size() - 1);
//                }
//            }
//        }
//    }
//
//    private boolean allTrue() {
//        for (boolean ch : check) {
//            if(!ch) {
//                return false;
//            }
//        }
//        return true;
//    }
}
