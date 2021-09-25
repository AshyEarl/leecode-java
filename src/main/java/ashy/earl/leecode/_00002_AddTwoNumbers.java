package ashy.earl.leecode;

// https://leetcode.com/problems/add-two-numbers/
public class _00002_AddTwoNumbers implements MyTest {
    @Override
    public void test() {
//        ListNode l1 = makeNodes(2, 4, 3);
//        ListNode l2 = makeNodes(5, 6, 4);
        ListNode l1 = makeNodes(0);
        ListNode l2 = makeNodes(0);
        ListNode rst = addTwoNumbers(l1, l2);
        System.out.println("rst: " + toString(rst));
    }

    private ListNode makeNodes(int... nums) {
        ListNode last = null;
        ListNode rst = null;
        for (int n : nums) {
            ListNode node = new ListNode();
            node.val = n;
            if (last != null) last.next = node;
            else rst = node;
            last = node;
        }
        return rst;
    }

    private String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val).append(',');
            node = node.next;
        }
        if (sb.length() != 1) sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode last = new ListNode();
        ListNode rst = last;
        int added = 0;
        while (l1 != null || l2 != null || added != 0) {
            if (l1 != null) {
                added += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                added += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode();
            node.val = added % 10;
            last.next = node;
            last = node;

            added /= 10;
        }
        return rst.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
