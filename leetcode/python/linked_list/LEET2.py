from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    root = current = ListNode()
    carry = 0

    while l1 or l2 or carry:
        _sum = 0
        if l1:
            _sum += l1.val
            l1 = l1.next

        if l2:
            _sum += l2.val
            l2 = l2.next

        carry, value = divmod(_sum + carry, 10)

        current.next = ListNode(value)
        current = current.next


def solve():
    n1 = ListNode(2)
    n2 = ListNode(4)
    n3 = ListNode(3)
    
    n4 = ListNode(5)
    n5 = ListNode(6)
    n6 = ListNode(4)

    n1.next = n2
    n2.next = n3

    n4.next = n5
    n5.next = n6

    result = addTwoNumbers(n1, n4)

solve()