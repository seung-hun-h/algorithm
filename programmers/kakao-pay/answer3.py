from collections import defaultdict

def solution(line1, line2):
    
    if len(line1) == len(line2):
        return 1 if line1 == line2 else 0

    step, length = 1, len(line2)
    answer = 0

    while length <= len(line1):
        for start in range(len(line1)):
            index = start
            current = ""
            while index < len(line1) and len(current) < len(line2):
                current += line1[index]
                index += step

            if len(current) < len(line2):
                break

            if current == line2:
                answer += 1
            print(current, start, step)
        step += 1
        length += len(line2) - 1

    return answer

def solution2(line1, line2):
    dp = list()
    ans = 0
    n, m = len(line1), len(line2)

    for i in range(n - m + 1):
        current = line1[i:i+m]
        dp.append(current)
        if current == line2:
            ans += 1

    for i in range(1, n - m + 1):
        new_dp = []
        for j in range(len(dp) - m + 1):
            current = ""
            for k in range(m):
                current += dp[j+k][k]
            new_dp.append(current)
            if current == line2:
                ans += 1

        if not new_dp:
            break

        dp = new_dp

    print(dp)
    return ans
print(solution2("abcbcd", "bcd"))