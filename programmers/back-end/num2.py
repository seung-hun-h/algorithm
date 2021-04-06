def solution(enroll, referral, seller, amount):
    answer = []
    enroll_idx = dict()
    graph = dict()
    parent = dict()
    profit = dict()
    amount_dict = dict()
    
    profit['-'] = 0
    for i in range(len(enroll)):
        enroll_idx[enroll[i]] = i
        profit[enroll[i]] = 0
    for i in range(len(referral)):
        if referral[i] not in graph.keys():
            graph[referral[i]] = []
        if enroll[i] not in parent.keys():
            parent[enroll[i]] = '-'
        graph[referral[i]].append(enroll[i])
        parent[enroll[i]] = referral[i]
        
    for s, a in zip(seller, amount):
        amount_dict[s] = a * 100
    
    dfs('-', graph, parent, amount_dict, profit)
    answer = list(profit.values())[1:]
    return answer

def dfs(cur, graph, parent, amount, profit):
    if cur not in graph.keys():
        if cur in amount.keys():
            profit[cur] = amount[cur]
        return

    for child in graph[cur]:
        dfs(child, graph, parent, amount, profit)
        p = profit[child] * 0.1
        profit[cur] += int(p)
        profit[child] -= int(p)

    if cur in amount.keys():
        profit[cur] += amount[cur]

a = solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"], ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],["young", "john", "tod", "emily", "mary"],[12, 4, 2, 5, 10])
print(a)