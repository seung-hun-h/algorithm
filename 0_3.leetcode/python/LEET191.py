from typing import *
def hammingWeight(n: int) -> int:
    return bin(n).count('1')

def hammingWeight2(n: int) -> int:
    count = 0
    while n:
        n &= (n-1)
        count += 1
    return count