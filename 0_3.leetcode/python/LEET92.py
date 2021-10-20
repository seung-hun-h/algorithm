from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
def reverseBetween(head: ListNode, left: int, right: int) -> ListNode:
    if not head or left == right:
        return head
        
    root = start = ListNode(None)
    root.next = head
    for _ in range(left-1):
        start = start.next
    end = start.next

    for _ in range(right-left):
        start.next, end.next, temp = end.next, end.next.next, start.next
        start.next.next = temp

    return root.next

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

    result = reverseBetween(n1, left=2, right=4)
    while result:
        print(result.val, end=" ")
        result = result.next

solve()