from sys import stdin
import re
readline = stdin.readline

def solve():
    name = readline().strip()
    if "_" in name:
        return to_java(name)
    else:
        return to_cpp(name)

def to_java(name):
    # there is "_" at front or rear of name or double "_"
    if name[0] == "_" or name[-1] == "_" or "__" in name:
        return "Error!"
    
    name_list = name.split("_")

    for i in range(len(name_list)):
        for j in range(len(name_list[i])):
            # there is upper case in cpp name
            if name_list[i][j].isupper():
                return "Error!"

        if i != 0:
            name_list[i] = name_list[i].capitalize()
    
    return "".join(name_list)

def to_cpp(name):
    # first letter is upper case
    if name[0].isupper():
        return "Error!"
    name_list = []

    prev = 0
    for i in range(1, len(name)):
        if name[i].isupper():
            name_list.append(name[prev:i].lower())
            prev = i
    name_list.append(name[prev:].lower())

    return "_".join(name_list)
res = solve()
print(res)