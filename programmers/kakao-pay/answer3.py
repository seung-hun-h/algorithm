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

print(solution("a", "b"))