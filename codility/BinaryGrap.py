# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N):
    # write your code in Python 3.6
    result = 0
    binary = bin(N)[2:]

    left, right = 0, 1

    while right < len(binary):
        if binary[right] == "1":
            result = max(result, right - left - 1)
            left = right
        right += 1

    return result
