package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(6, new ListNode(6, new ListNode(5)));
//        ListNode l2 = new ListNode(4, new ListNode(3, new ListNode(4)));
        ListNode l1 = new ListNode(1, new ListNode(8, new ListNode(5)));
        ListNode l2 = new ListNode(2);
        AddTwoNumbers fn = new AddTwoNumbers();
        ListNode result = fn.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        while(l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        StringBuilder s2 = new StringBuilder();
        while(l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }

        long sum = Long.parseLong(s1.reverse().toString()) + Long.parseLong(s2.reverse().toString());
        int[] sumSplit = Arrays.stream(new StringBuilder(String.valueOf(sum)).reverse().toString().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        ListNode result = new ListNode(sumSplit[0]);
        ListNode tempForResult = result;
        for (int i = 1; i < sumSplit.length; i++) {
            tempForResult.next = new ListNode();
            tempForResult = tempForResult.next;

            tempForResult.val = sumSplit[i];
        }

        return result;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
