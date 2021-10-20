from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverseList(head: ListNode) -> ListNode:
    def reverse(node: ListNode, prev: ListNode = None) -> ListNode:
        if not node:
            return prev
        
        _next, node.next = node.next, prev
        return reverse(_next, node)

    return reverse(head)


def reverseList2(head: ListNode) -> ListNode:
    current, prev = head, None

    while current:
        _next, current.next = current.next, prev
        prev, current = current, _next

    return prev

def solve():
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n4 = ListNode(4)
    n5 = ListNode(5)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    result = reverseList(n1)
    print(result.val)

solve()