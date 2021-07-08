from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def mergeTwoLists(l1: ListNode, l2: ListNode) -> ListNode:
    root = current = ListNode()

    while l1 or l2:
        value = 0
        if l1 and l2:
            if l1.val <= l2.val:
                value = l1.val
                l1 = l1.next
            else:
                value = l2.val
                l2 = l2.next
        elif l1:
            value = l1.val
            l1 = l1.next
        else:
            value = l2.val
            l2 = l2.next
        
        current.next = ListNode(value)
        current = current.next
    return root.next
def mergeTwoLists2(l1: ListNode, l2: ListNode) -> ListNode:
    if not l1 or (l2 and l1.val > l2.val):
        l1, l2 = l2, l1
    
    if l1:
        l1.next = mergeTwoLists2(l1.next, l2)
    
    return l1
def solve():
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(4)
    n1.next = n2
    n2.next = n3

    m1 = ListNode(1)
    m2 = ListNode(3)
    m3 = ListNode(4)

    m1.next = m2
    m2.next = m3

    result = mergeTwoLists(n1, m1)
    print(result)

solve()