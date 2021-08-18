from collections import defaultdict

def solution(servers, sticky, requests):
    if not sticky:
        return [requests[i::servers] for i in range(servers)]
    answer = [[]]
    
    server = defaultdict(int)
    server_list = [[] for _ in range(servers + 1)]
    index = 0
    
    for request in requests:
        if request not in server:
            server_list[index + 1].append(request)
            server[request] = index + 1
            index += 1
            index %= servers
            continue
        
        server_list[server[request]].append(request)
        
    return server_list[1:]