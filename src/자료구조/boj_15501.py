from collections import defaultdict

n = int(input())
given = input().split()
target = input().split()
dic = defaultdict(list)
found = True

for i in range(n):
    dic[given[i]].extend([given[i - 1], given[(i + 1) % n]])

for i in range(n):
    if target[i - 1] not in dic[target[i]] or target[(i + 1) % n] not in dic[target[i]]:
        found = False
        break

print("good puzzle" if found else "bad puzzle")
