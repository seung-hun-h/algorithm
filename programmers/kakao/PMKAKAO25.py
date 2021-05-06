from copy import deepcopy
def solution(user_id, banned_id):
    answer = 0
    candidate = [[] for _ in range(len(banned_id))]
    
    for i in range(len(banned_id)):
        ban = banned_id[i]
        for user in user_id:
            if len(ban) != len(user): continue
            flag = True
            for j in range(len(ban)):
                if ban[j] == "*":continue
                if ban[j] != user[j]:
                    flag = False
                    break
            
            if flag:
                candidate[i].append(user)
    
    results = []
    dfs(candidate, 0, set(), results)
    return len(results)

def dfs(candidate, idx, current, results):
    if len(current) == len(candidate):
        if check(results, current):
            results.append(deepcopy(current))
        return
    
    for c in candidate[idx]:
        if c not in current:
            current.add(c)
            dfs(candidate, idx+1, current, results)
            current.remove(c)

def check(results, current):
    for r in results:
        if r == current:
            return False

    return True

res = solution(["frodo", "fradi", "crodo", "abc123", "frodoc"],["fr*d*", "*rodo", "******", "******"]	)
print(res)