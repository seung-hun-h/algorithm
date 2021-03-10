from sys import stdin, maxsize

readline = stdin.readline

def main():
    left = arr.copy()
    right = []
    cursor = len(arr)

    for _ in range(N):
        command = readline().strip().split()

        if command[0] == "P":
            left.append(command[1])
        elif command[0] == "L":
            if left:
                right.append(left.pop())
        elif command[0] == "D":
            if right:
                left.append(right.pop())
        elif command[0] == "B":
            if left:
                left.pop()
    
    
    print("".join(left +list(reversed(right))))

if __name__ == "__main__":
    arr = list(readline().strip())
    N = int(readline().strip())
    main()