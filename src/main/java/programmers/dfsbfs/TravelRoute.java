package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.Stack;

// 모든 경로를 돌아야하고(알파벳 우선만 X), 티켓이 모두 소진되었는지 체크해야함
public class TravelRoute {
    public static void main(String[] args) {
        var result1 = new TravelRoute().solution(new String[][] {
            {"ICN", "JFK"},
            {"HND", "IAD"},
            {"JFK", "HND"}
        });
        for (String s : result1) {
            System.out.print(s + "-");
        }
        System.out.println();

        var result2 = new TravelRoute().solution(new String[][] {
            {"ICN", "SFO"},
            {"ICN", "ATL"},
            {"SFO", "ATL"},
            {"ATL", "ICN"},
            {"ATL", "SFO"}
        });
        for (String s : result2) {
            System.out.print(s + "-");
        }
        System.out.println();

        var result3 = new TravelRoute().solution(new String[][] {
            {"ICN", "AAA"},
            {"ICN", "AAA"},
            {"ICN", "AAA"},
            {"AAA", "ICN"},
            {"AAA", "ICN"}
        });
        for (String s : result3) {
            System.out.print(s + "-");
        }
        System.out.println();

        var result4 = new TravelRoute().solution(new String[][] {
            {"ICN", "AAA"},
            {"AAA", "BBB"},
            {"AAA", "CCC"},
            {"CCC", "AAA"},
            {"BBB", "DDD"}
        });
        for (String s : result4) {
            System.out.print(s + "-");
        }
        System.out.println();
    }

    public String[] solution(String[][] tickets) {
        var temp = new ArrayList<Route>();

        var stack = new Stack<Route>();
        var check = new boolean[tickets.length];
        addAvailableRoute(tickets, stack, check, "ICN");

        while (!stack.isEmpty()) {
            var route = stack.pop();
            check[route.index] = true;
            temp.add(route);

            var added = addAvailableRoute(tickets, stack, check, route.dest);

            if (temp.size() == tickets.length || added == 0) {
                temp.forEach(r -> check[r.index] = false);
            }
        }

        var result = new ArrayList<String>();
        for (int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i).src);

            if (i == temp.size() - 1) {
                result.add(temp.get(i).dest);
            }
        }

        return result.toArray(new String[0]);
    }

    private int addAvailableRoute(String[][] tickets, Stack<Route> stack, boolean[] check, String src) {
        int added = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (!check[i] && src.equals(tickets[i][0])) {
                stack.push(new Route(tickets[i][0], tickets[i][1], i));
                added++;
            }
        }
        return added;
    }

    class Route {
        String src;
        String dest;
        int index;

        public Route(String src, String dest, int index) {
            this.src = src;
            this.dest = dest;
            this.index = index;
        }
    }
}
