public class LEET147 {
    
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public static ListNode insertionSortList(ListNode head) {
    ListNode parent = new ListNode(0);
    ListNode cur = parent;

    while(head != null) {
        while(cur.next != null && cur.next.val < head.val) {
            cur = cur.next;
        }

        ListNode next = head.next;
        head.next = cur.next;
        cur.next = head;
        head = next;

        if(head != null && cur.val > head.val) {
            cur = parent;
        }
    }

    return parent.next;
  }
}
