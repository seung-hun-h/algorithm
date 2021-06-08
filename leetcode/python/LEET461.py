from typing import *

def hammingDistance(x: int, y: int) -> int:
    return bin(x ^ y).count('1')