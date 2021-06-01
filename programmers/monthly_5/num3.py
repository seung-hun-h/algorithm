def solution(strings):
    answer = []
    upper = {"111"}
    lower = {"000", "001", "010", "100", "011", "101"}
    for s in strings:
        index = s.index("110")
        left = s[:index]
        right = s[index+3:]
        print(s.index("110"))
        # for i in range(len(s)-2):
        #     cur = s[i:i+3]
        #     if cur == "110":
        #         flag = False
        #         # 앞에서 upper 찾기
        #         for j in range(0, i):
        #             u = s[j:j+3]
        #             # 있으면 바꾸기
        #             if u in upper:
        #                 # 인덱스 안겹칠 때
        #                 if i > j+2:
        #                     s = s[:j] + cur + s[j+3:i] + u + s[i+3:]
        #                 # 인덱스 겹칠 때
        #                 else:
        #                     s = s[:j] + cur + s[j:i] + s[i+3:]
        #                 flag = True
        #                 break
        #         if flag: continue
        #         # 뒤에서 lower 찾기
        #         for j in range(len(s), i, -1):
        #             l = s[j-3:j]
        #             if l in lower:
        #                 # 인덱스 겹칠 때
        #                 if j-3 <= i+2:
        #                     s = s[:i] + l + s[i:j-3] + s[j:]
        #                 else:
        #                     s = s[:i] + l + s[i+3:j-3] + cur + s[j:]
        #                 break
        answer.append(s)
    return answer

solution(["1110","100111100","0111111010"])