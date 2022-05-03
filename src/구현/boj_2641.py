n = int(input())
a = list(input().split())
m = int(input())
b = a[::-1]
answer = []

for i in range(n):
    if b[i] == "1":
        b[i] = "3"
    elif b[i] == "2":
        b[i] = "4"
    elif b[i] == "3":
        b[i] = "1"
    else:
        b[i] = "2"

A = [a[i:] + a[:i] for i in range(n)]
B = [b[i:] + b[:i] for i in range(n)]

for _ in range(m):
    sample = input().split()
    if sample in A or sample in B:
        answer.append(" ".join(sample))

print(len(answer), "\n".join(answer), sep="\n")
