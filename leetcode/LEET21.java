public class LEET21 {
    
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
        ListNode node3= new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        ListNode node4= new ListNode(1);
        ListNode node5= new ListNode(3);
        ListNode node6= new ListNode(4);

        node4.next = node5;
        node5.next = node6;


        System.out.println(mergeTwoLists(node1, node4).value);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            int value = sum % 10;

            current.next = new ListNode(value);
            current = current.next;
        }

        return root.next;
    }

}