from typing import *
import heapq

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def mergeKLists(lists: List[ListNode]) -> ListNode:
    root = result = ListNode()
    heap = []

    for i in range(len(lists)):
        if lists[i]:
            heapq.heappush(heap, (lists[i].val, i, lists[i]))

    while heap:
        node = heapq.heappop(heap)

        i = node[1]
        result.next = node[2]
        result = result.next

        if result.next:
            heapq.heappush(heap, (result.next.val, i, result.next))

    return root.next

def solve():
    n1 = ListNode(1)
    n2 = ListNode(4)
    n3 = ListNode(5)

    n1.next = n2
    n2.next = n3

    m1 = ListNode(1)
    m2 = ListNode(3)
    m3 = ListNode(4)

    m1.next = m2
    m2.next = m3

    u1 = ListNode(2)
    u2 = ListNode(6)

    u1.next = u2

    result = mergeKLists([n1, m1, u1])

    while result:
        print(result.val, end=" ")
        result = result.next


solve()