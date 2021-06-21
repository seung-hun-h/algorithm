import collections

def solution(gems):
    left, right, gems_set = 0, 0, set(gems)
    counter = collections.defaultdict(int)
    ans = [0, len(gems)]
    for right, item in enumerate(gems):
        counter[item] += 1
        
        while counter[gems[left]] > 1:
            counter[gems[left]] -= 1
            left += 1
            
        if len(counter) == len(gems_set) and ans[1]-ans[0] > right-left:
            ans = [left+1, right+1]
        
    return ans