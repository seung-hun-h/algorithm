from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def oddEvenList(head: ListNode) -> ListNode:
    if not head or not head.next:
        return head
    odd, even, even_front = head, head.next, head.next

    while even and even.next:
        odd.next, even.next = odd.next.next, even.next.next
        odd, even = odd.next, even.next

    odd.next = even_front

    return head


def solve():
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n4 = ListNode(4)
    n5 = ListNode(5)
    # n6 = ListNode(6)
    # n7 = ListNode(7)
    # n8 = ListNode(8)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    # n5.next = n6
    # n6.next = n7
    # n7.next = n8

    result = oddEvenList(n1)
    while result:
        print(result.val, end=" ")
        result = result.next

solve()