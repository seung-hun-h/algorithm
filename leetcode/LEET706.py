from typing import *
from collections import defaultdict

class ListNode:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.table = defaultdict(ListNode)       

    # Insert
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % self.size

        if self.table[index].value is None:
            self.table[index] = ListNode(key, value)
            return
        
        p = self.table[index]
        while p:
            # Update
            if p.key == key:
                p.value = value
                return
            
            if p.next is None:
                break

            p = p.next
        
        p.next = ListNode(key, value)

    # Show
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % self.size
        if self.table[index].value is None:
            return -1
        
        p = self.table[index]
        
        while p:
            if p.key == key:
                return p.value
            p = p.next
        
        return -1
    
    # Delete
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % self.size

        if self.table[index].value is None:
            return
        
        p = self.table[index]
        if p.key == key:
            self.table[index] = p.next
            return
        
        prev = p
        while p:
            if p.key == key:
                prev.next = p.next
                return
            prev, p = p, p.next

def solve():
    _map = MyHashMap()
    _map.put(1, 10)
    _map.put(11, 110)
    _map.put(45, 55)
    _map.put(1001, 1)

    print(_map.get(1))
    print(_map.get(11))
    print(_map.get(45))
    print(_map.get(1001))
    _map.remove(1)
    print(_map.get(1001))
solve()