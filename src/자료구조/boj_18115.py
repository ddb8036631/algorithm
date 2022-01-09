N = int(input())
A = list(input().split())
stack = [0] * N
first, second, third = 0, 1, N - 1
for a in A:
    if a == "1":
        stack[first] = N
        while first < len(stack) and stack[first]:
            first += 1
        second = first + 1
        while second < len(stack) and stack[second]:
            second += 1
    elif a == "2":
        stack[second] = N
        while second < len(stack) and stack[second]:
            second += 1
    elif a == "3":
        stack[third] = N
        while third >= 0 and stack[third]:
            third -= 1
    N -= 1

print(*stack)
