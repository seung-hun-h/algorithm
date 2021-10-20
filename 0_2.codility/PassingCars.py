# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    east = []
    west_sum = [0]

    for i, _dir in enumerate(A):
        if _dir == 1:
            west_sum.append(west_sum[-1]+1)
        else:
            west_sum.append(west_sum[-1])
            east.append(i)
    result = sum(west_sum[-1] - west_sum[e] for e in east)

    return result if result <= 1000000000 else -1