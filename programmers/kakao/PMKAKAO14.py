from collections import defaultdict
def solution(record):
    answer = []
    ment = {"Enter": "님이 들어왔습니다.", "Leave": "님이 나갔습니다."}
    logs = []
    name = defaultdict(str)
    for r in record:
        info = r.split()
        if info[0] != "Leave":
            name[info[1]] = info[2]
        if info[0] != "Change":
            if len(info) > 2:
                logs.append(info[:2])
            else:
                logs.append(info)

    for log in logs:
        answer.append(name[log[1]]+ment[log[0]])
    return answer

res = solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"])
print(res)