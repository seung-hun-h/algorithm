from collections import defaultdict

def solution(gems):
    result = [1, len(gems)]
    left, right = 0, 0 
    num_of_gems = len(set(gems))
    counter = defaultdict(int)
    counter[gems[0]] = 1
    while left <= right and right < len(gems):
        if len(counter.keys()) == num_of_gems:
            if result[1] - result[0] > right - left:
                result = [left+1, right+1]

            counter[gems[left]] -= 1
            if counter[gems[left]] == 0:
                del counter[gems[left]]
            left += 1
        else:
            right += 1
            if right == len(gems):break
            counter[gems[right]] += 1
    
    return result


res = solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"])
print(res)