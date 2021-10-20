from typing import *

def getSum(a: int, b: int) -> int:
    MASK = 0xFFFFFFFF
    INT_MAX = 0x7FFFFFFF

    a_bin = bin(a & MASK)[2:].zfill(32)
    b_bin = bin(b & MASK)[2:].zfill(32)
    
    carry = 0
    _sum = 0
    result = []
    for i in range(32):
        A = int(a_bin[31 - i])
        B = int(b_bin[31 - i])

        # 전가산기 구현
        Q1 = A & B
        Q2 = A ^ B
        Q3 = Q2 & carry
        _sum = carry ^ Q2
        carry = Q1 | Q3

        result.append(str(_sum))
    if carry == 1:
        result.append('1')

    # 초과 자리수 정리
    result = int(''.join(result[::-1]), 2) & MASK

    # 음수 처리
    if result > INT_MAX:
        result = ~(result ^ MASK)

    return result

def getSum2(a: int, b: int) -> int:
    MASK = 0xFFFFFFFF
    INT_MAX = 0x7FFFFFFF

    while b != 0:
        a, b = (a ^ b) & MASK, ((a & b) << 1) & MASK
    
    if a > INT_MAX:
        a = ~(a ^ MASK)

    return a

print(getSum(2, 3)) 