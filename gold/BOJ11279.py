from sys import stdin
readline = stdin.readline

def main():
    arr = [0]    
    for _ in range(N):
        c = int(readline().strip())
        if c == 0:
            if len(arr) > 1:
                print(remove(arr))
            else:
                print(0)
        else:
            insert(arr, c)

def insert(arr, num):
    arr.append(num)
    i = len(arr) - 1
    while i > 1:
        if i // 2 >= 1 and arr[i//2] < arr[i]:
            temp = arr[i]
            arr[i] = arr[i//2]
            arr[i//2] = temp
            i //= 2
        else:
            break

def remove(arr):
    return_value = arr[1]
    arr[1] = arr[-1]
    arr[-1] = return_value
    arr.pop()

    parent = 1
    child = 2 * parent
    while child <= len(arr) - 1:
        if child < len(arr) - 1 and arr[child] < arr[child+1]:
            child += 1
        
        if arr[parent] < arr[child]:
            temp = arr[child]
            arr[child] = arr[parent]
            arr[parent] = temp
            parent = child
            child = 2 * parent
        else:
            break
    return return_value

# def remove(arr):
#     maxVal = arr[1]
#     tmp = arr.pop()

#     parent = 1
#     child = 2

#     while child <= len(arr) - 1:
#         if child < len(arr)-1 and arr[child] < arr[child+1]:
#             child += 1
        
#         if arr[child] <= tmp:
#             break
            
#         arr[parent] = arr[child]
#         parent = child
#         child *= 2

#     if len(arr) != 1:
#         arr[parent] = tmp
#     return maxVal
if __name__ == "__main__":
    N = int(readline())
    main()