def solution(new_id):
    answer = ''
    # 1
    new_id = new_id.lower()
    # 2
    special = {".", "_", "-"}
    temp = ''
    for i in range(len(new_id)):
        if new_id[i].isalnum():
            temp += new_id[i]
        elif new_id[i] in special:
            temp += new_id[i]

    new_id = temp
    # 3
    while new_id.find("..") != -1:
        new_id = new_id.replace("..", '.')

    # 4
    new_id = new_id.lstrip(".").rstrip(".")
    
    # 5
    if not len(new_id):
        new_id = "a"

    # 6
    if len(new_id) >= 16:
        new_id = new_id[:15].rstrip(".")

    # 7
    if len(new_id) <= 2:
        temp = new_id
        while len(temp) != 3:
            temp += new_id[-1]
        new_id = temp
    
    return new_id
import re
def solution2(new_id):
    answer = new_id.lower()
    answer = re.sub("[^a-z0-9-_.]", "", answer)
    answer = re.sub("\.+", ".", answer)
    answer = re.sub("^[.]|[.]$", "", answer)
    answer = "a" if not answer else answer
    answer = answer[:15].rstrip(".") if len(answer) >= 16 else answer
    answer = answer if len(answer) > 2 else answer + "".join(answer[-1] for _ in range(3-len(answer)))
    return answer
print(solution2("...!@BaT#*..y.abcdefg-hi_jklm"))