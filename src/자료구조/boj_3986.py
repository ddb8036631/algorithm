N = int(input())
answer = 0
for _ in range(int(input())):
    s = input()
    stack = []
    for ch in s:
        if stack:
            if stack[-1] == ch:
                stack.pop()
            else:
                stack.append(ch)
        else:
            stack.append(ch)

    if not stack:
        answer += 1

print(answer)
