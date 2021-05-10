from typing import *

class ListNode:
    def __init__(self, val=None):
        self.val = val
        self.right, self.left = None, None

class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.head = ListNode()
        self.tail = ListNode()
        self.len = 0
        self.maxlen = k

        self.head.right, self.tail.left = self.tail, self.head

    def _add(self, node: ListNode, new: ListNode):
        n = node.right
        node.right = new
        n.left = new
        new.left, new.right= node, n

    def _delete(self, node: ListNode):
        n = node.right.right
        node.right, n.left = n, node

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.len == self.maxlen:
            return False
        
        self.len += 1
        self._add(self.head, ListNode(value))
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.len == self.maxlen:
            return False
        self.len += 1
        self._add(self.tail.left, ListNode(value))
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.len == 0:
            return False
        self.len -= 1
        self._delete(self.head)
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.len == 0:
            return False
        self.len -= 1
        self._delete(self.tail.left.left)
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        return self.head.right.val if self.len else -1

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        return self.tail.left.val if self.len else -1

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.len == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self.len == self.maxlen