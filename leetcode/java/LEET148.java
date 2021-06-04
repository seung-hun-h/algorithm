import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LEET148 {
    public static class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i=1;i<arr.length;i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = cur.next;
        }

    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode half = new ListNode(); 
        ListNode slow = head; 
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        half.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeTwoList(l1, l2);
    }
    
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || (l2 != null && l1.val > l2.val)) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        } 
        
        if (l1 != null) {
            l1.next = mergeTwoList(l1.next, l2);
        }

        return l1;
    }

    public static ListNode sortList2(ListNode head) {
        ListNode node = head;
        List<Integer> arr = new ArrayList<>();
        
        while(node != null) {
            arr.add(node.val);
            node = node.next;
        }

        Collections.sort(arr);
        
        node = head;
        for(int value : arr) {
            node.val = value;
            node = node.next;
        }

        return head;
    }
}