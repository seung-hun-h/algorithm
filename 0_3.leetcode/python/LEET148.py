from typing import *

class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

def main():
    arr = [4,2,1,3]
    head = ListNode(arr[0])
    cur = head
    for i in range(1, len(arr)):
        node = ListNode(arr[i])
        cur.next = node
        cur = node
    
    head = sortList(head)
    while head:
        print(head.val, end=' ')
        head = head.next

def sortList(head: ListNode) -> ListNode:
    if not (head and head.next):
        return head
    
    half, slow, fast = None, head, head

    while fast and fast.next:
        half, slow, fast = slow, slow.next, fast.next.next
    # 연결 끊음
    half.next = None

    l1 = sortList(head)
    l2 = sortList(slow)

    return merge_two_list(l1, l2)

def merge_two_list(l1: ListNode, l2: ListNode) -> ListNode:
    if l1 and l2:
        if l1.val > l2.val:
            l1, l2 = l2, l1
        l1.next = merge_two_list(l1.next, l2)
    return l1 or l2

def sortList2(head: ListNode):
    node = head
    arr = []
    while node:
        arr.append(node.val)
        node = node.next
    
    arr.sort()
    
    node = head
    for i in range(len(arr)):
        node.val = arr[i]
        node = node.next

    return head
main()