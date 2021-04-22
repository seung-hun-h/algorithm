import re
import collections

def mostCommonWord(paragraph, banned):
    words = [char for char in re.sub(r'[^\w]', " ", paragraph).lower().split()]
    counts = collections.Counter(words)
    for w, c in counts.most_common():
        if w not in banned:
            return w

print(mostCommonWord(paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]))