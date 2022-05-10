N = int(input())
kbs1, kbs2 = 0, 0
answer = []

for i in range(1, N + 1):
    s = input()
    if s == "KBS1":
        kbs1 = i
    elif s == "KBS2":
        kbs2 = i

if kbs1 > kbs2:
    kbs2 += 1

for _ in range(kbs1 - 1):
    answer.append("1")
for _ in range(kbs1 - 1):
    answer.append("4")
for _ in range(kbs2 - 1):
    answer.append("1")
for _ in range(kbs2 - 2):
    answer.append("4")

print("".join(answer))
