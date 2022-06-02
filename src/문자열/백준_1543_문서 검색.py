a = input()
b = input()
idx = 0
answer = 0

while idx <= len(a) - len(b):
    if a[idx : idx + len(b)] == b:
        idx += len(b)
        answer += 1
    else:
        idx += 1

print(answer)
