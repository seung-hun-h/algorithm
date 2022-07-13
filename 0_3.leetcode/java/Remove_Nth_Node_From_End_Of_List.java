public class Remove_Nth_Node_From_End_Of_List {
    static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        ListNode slow = start;
        ListNode fast = start;
        start.next = head;

        // go
        for (int i=0;i<=n;i++) {
            if (fast == null) break;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //remove
        slow.next = slow.next.next;

        return start.next;
    }
}
