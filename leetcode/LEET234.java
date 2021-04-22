public class LEET234 {
    
    //   Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static void main(String[] args){
        ListNode node1= new ListNode(1);
        ListNode node2= new ListNode(2);
        ListNode node3= new ListNode(2);
        ListNode node4= new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(isPalindrome(node1));
    }
    public static boolean isPalindrome(ListNode head){
        ListNode rev = new ListNode(-1);
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode temp = slow.clone();
            slow = slow.next;
            rev.next = rev;
            rev = slow;
        }
        if(fast != null){
            slow = slow.next;
        }
        while (rev != null){
            System.out.println(rev.val);
            rev
        }
        return rev.val == -1;
    }

}