import re
def solution(new_id):
    answer = new_id.lower()
    answer = re.sub("[^a-z0-9-_.]", "", answer)
    answer = re.sub("\.+", ".", answer)
    answer = re.sub("^[.]|[.]$", "", answer)
    answer = "a" if not answer else answer
    answer = answer[:15].rstrip(".") if len(answer) >= 16 else answer
    answer = answer if len(answer) > 2 else answer + "".join(answer[-1] for _ in range(3-len(answer)))
    return answer