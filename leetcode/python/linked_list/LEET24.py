from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def swapPairs(head: ListNode) -> ListNode:
    current = head 
    
    while current and current.next:
        current.val, current.next.val = current.next.val, current.val
        current = current.next.next
    
    return head

def swapPairs2(head: ListNode) -> ListNode:
    root = prev = ListNode(None)
    current = head
    prev.next = current

    while current and current.next:
        
        _next = current.next
        current.next = _next.next

        _next.next = current
        prev.next = _next

        prev = current   
        current = current.next
    
    return root.next

def swapPairs3(head: ListNode) -> ListNode:
    if head and head.next:
        _next = head.next

        head.next = swapPairs3(_next.next)
        _next.next= head
    
        return _next
        
    return head

def solve():
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n4 = ListNode(4)
    # n5 = ListNode(5)
    # n6 = ListNode(6)
    # n7 = ListNode(7)
    # n8 = ListNode(8)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    # n4.next = n5
    # n5.next = n6
    # n6.next = n7
    # n7.next = n8

    result = swapPairs2(n1)
    while result:
        print(result.val, end=" ")
        result = result.next

solve()