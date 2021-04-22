from typing import *
from collections import deque

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
def isPalindrome(head: ListNode) -> bool:
    q: Deque = deque()
    node = head
    while node:
        q.append(node.val)
        node = node.next

    while len(q) > 1:
        if q.popleft() != q.pop():
            return False

    return True

def isPalindrome_(head: ListNode) -> bool:
    rev = None
    slow = fast = head

    while fast and fast.next:
        fast = fast.next.next
        rev, rev.next, slow = slow, rev, slow.next
    
    if fast:
        slow = slow.next

    while rev.val == slow.val:
        rev, slow = rev.next, slow.next
    
    return not rev
def solve():
    node1 = ListNode(1)
    node2 = ListNode(2)
    # node3 = ListNode(2)
    # node4 = ListNode(1)

    node1.next = node2
    # node2.next = node3
    # node3.next = node4

    result = isPalindrome_(head=node1)
    print(result)

solve()