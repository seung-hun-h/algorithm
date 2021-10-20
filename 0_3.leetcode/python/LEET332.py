from typing import *
import collections

def findItinerary(tickets: List[List[str]]) -> List[str]:
    def dfs(city):
        print(result)
        print(city, graph[city])
        while graph[city]:
            dfs(graph[city].pop())
        result.append(city)

    graph = collections.defaultdict(list)

    for u, v in sorted(tickets):
        graph[u].append(v)

    result = []
    dfs("JFK")
    return result[::-1]

def findItinerary2(tickets: List[List[str]]) -> List[str]:
    def dfs():
        while stack:
            while graph[stack[-1]]:
                stack.append(graph[stack[-1]].pop(0))
            route.append(stack.pop())
    graph = collections.defaultdict(list)

    for u, v in sorted(tickets):
        graph[u].append(v)

    route, stack = [], ["JFK"]
    dfs()
    return route[::-1]

tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
res = findItinerary2(tickets = tickets)
print(res)