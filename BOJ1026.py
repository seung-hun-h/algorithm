from sys import stdin
from itertools import combinations as cb
readline = stdin.readline

N, K = map(int, readline().split())
chars = set()
words = [(readline().split("anta")[1]).split("tica")[0] for _ in range(N)]
if K < 5:
    print(0)
elif K == 26:
    print(N)
else:
    ans = 0
    for word in words:
        for i in range(len(word)):
            if word[i] != 'a' and word[i] != 'n' and word[i] != 't' and word[i] != 'i' and word[i] != 'c':
                chars.add(word[i])
    if len(chars) + 5 <= K:
        print(N)
    else:
        chars_cb = cb(list(chars), K-5)

        for char in chars_cb:
            _hash = [0] * 26
            for c in char:
                _hash[ord(c)-ord('a')] = 1
            cnt = 0
            for word in words:
                flag = True
                for i in range(len(word)):
                    if word[i] == 'a' or word[i] == 'n' or word[i] == 't' or word[i] == 'i' or word[i] == 'c':
                        continue
                    if not _hash[ord(word[i]) - ord('a')]:
                        flag = False
                        break
                    if not flag: break
                if flag: cnt += 1
            ans = max(ans, cnt)
        print(ans)